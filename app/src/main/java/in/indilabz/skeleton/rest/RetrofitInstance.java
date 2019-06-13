package in.indilabz.skeleton.rest;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import in.indilabz.skeleton.utils.Constants;
import in.indilabz.skeleton.INDIMaster;
import in.indilabz.skeleton.utils.INDIPreferences;
import in.indilabz.skeleton.utils.JSONParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class RetrofitInstance implements Constants {

    public static final int ERROR_CODE = 0;
    public static final int SUCCESS_CODE = 1;

    private static Retrofit retrofit;
    private static OkHttpClient client;
    private static Call<String> call;

    public static Retrofit getLoginInstance() {

        client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(chain -> {
                    Request newRequest  = chain.request().newBuilder()
                            .build();
                    return chain.proceed(newRequest);
                }).build();


        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Retrofit getSessionInstance() {

        client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(chain -> {
                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("AUTH-TOKEN", INDIPreferences.getEmployeeDetails().getAuth().getToken())
                            .build();
                    return chain.proceed(newRequest);
                }).build();


        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static void getRetrofit(final RetrofitListener retrofitListener, Call<String> call, final int code){
        new RetrofitAPI(retrofitListener, call, code).execute();

    }

    private static class RetrofitAPI extends AsyncTask<String, String, String> {

        private RetrofitListener retrofitListener;
        private int code;

        private RetrofitAPI (RetrofitListener retrofitListener, Call<String> calls, final int code){

            this.retrofitListener = retrofitListener;
            call = calls;
            this.code = code;
        }

        @Override
        protected String doInBackground(String... params) {

            call.clone().enqueue(new Callback<String>() {

                @Override
                public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {

                    if(response.isSuccessful()){

                        try{

                            Log.d("TAG_RETROFIT_RESULT", response.body());

                            String message = JSONParser.getJSONObject(response.body(), "error");
                            String result = JSONParser.getJSONObject(response.body(),"result");

                            if(message.equals("NO_ERROR")){


                                retrofitListener.onDataReceived(response.code(), true, result, code);
                            }
                            else {

                                retrofitListener.onDataReceived(response.code(), false, message, code);
                            }
                        }
                        catch (Exception e) {

                            Log.d("TAG_RETROFIT_ERROR", e.toString());

                            retrofitListener.onDataReceived(response.code(), false, "Error while getting data", code);
                        }
                    }
                    else {

                        try {
                            Log.d("TAG_REAL_ERROR", response.errorBody().string());
                        }
                        catch (Exception e){

                            Log.d("TAG_REAL_ERROR_EX", e.getMessage());
                        }

                        try{

                           ModelAPIError apiError = INDIMaster.getGson().fromJson(response.errorBody().string(), ModelAPIError.class);

                            if(apiError.getError().equals("AUTH_ERROR")){

                                //INDIPreferences.saveAppSession(false);
                                if(INDIPreferences.preferenceEditor().clear().commit()){

                                   INDIMaster.applicationContext.
                                            startActivity(new Intent(INDIMaster.applicationContext, SplashActivity.class));

                                   INDIPreferences.saveBackPress(false);
                                }

                            }
                            else {

                                retrofitListener.onDataReceived(response.code(),
                                        false, apiError.getError(), code);
                            }
                        }
                        catch (Exception e){

                            Log.d("TAG_EXCEPTION_ERROR", e.toString());

                            retrofitListener.onDataReceived(response.code(),
                                    false, "Error while getting data!", code);
                        }
                    }

                }

                @Override
                public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {

                    Log.d("TAG_RETROFIT_THROW", t.getMessage());
                    retrofitListener.onDataReceived(404, false, "Please check your internet connection", code);
                    //Toaster.LongToast("Unable to connect to internet");
                }
            });

            return null;
        }


        @Override
        protected void onPostExecute(String result) {

        }

        @Override
        protected void onPreExecute() {

        }

    }
}
