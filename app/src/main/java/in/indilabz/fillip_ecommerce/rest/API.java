package in.indilabz.fillip_ecommerce.rest;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mjdem on 06-05-2018.
**/

public interface API {

   ///// RETROFIT APIS HERE

    /*@FormUrlEncoded
    @POST("route_clients/assign_routes")
    Call<String> AssignRoutes(
            @Field("clients") String clients,
            @Field("route") String route
    );

    /////////////////////////// SEARCH

    @GET("search/{table}/{column}/{query}")
    Call<String> Search(
            @Path("table") String table,
            @Path("column") String column,
            @Path("query") String query
    );*/
}
