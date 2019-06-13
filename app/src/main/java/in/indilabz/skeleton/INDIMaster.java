package in.indilabz.skeleton;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.indilabz.skeleton.rest.API;
import in.indilabz.skeleton.rest.RetrofitInstance;
import in.indilabz.skeleton.utils.Constants;

/**
 * Created by mjdem on 27-12-2018.
 */

public class INDIMaster extends Application implements Constants {

    public static Context applicationContext = null;
    private static INDIMaster indiMaster;
    private static API loginApi = RetrofitInstance.getLoginInstance().create(API.class);

    private static LinearLayoutManager linearLayoutManager;
    private static GridLayoutManager gridLayoutManager;

    private static GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson gson = gsonBuilder.create();
    private static RequestOptions requestOptions = null;

    @Override
    public void onCreate() {
        super.onCreate();
        indiMaster = INDIMaster.this;

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        applicationContext = getApplicationContext();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static synchronized INDIMaster getInstance() {
        return indiMaster;
    }

    public static Gson getGson(){

        return gson;
    }

    public static API loginApi(){ return loginApi; }

    public static LinearLayoutManager getVerticalLayoutManager(){

        linearLayoutManager = new LinearLayoutManager(applicationContext);
       // linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        return linearLayoutManager;
    }

    public static LinearLayoutManager getHorizontalLayoutManager(){

        linearLayoutManager = new LinearLayoutManager(applicationContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        return linearLayoutManager;
    }

    public static GridLayoutManager getGridLayoutManager(){

        gridLayoutManager = new GridLayoutManager(applicationContext, 2);

        return gridLayoutManager;
    }

    /*public static RequestOptions getGlideRequest(){

        requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_default);
        requestOptions.error(R.drawable.ic_default);

        return requestOptions;
    }*/

    /*public static RequestOptions getMapGlideRequest(){

        requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_location_placeholder);
        requestOptions.error(R.drawable.ic_location_placeholder);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.fitCenter();
        //requestOptions.override(1000,1000);

        return requestOptions;
    }*/

}
