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

    ////////////////////// GOOGLE-MAPS API

    /*@GET("json") //i.e https://api.test.com/Search?
    Call<String> getNearByPlaces(
            @Query("location") String location,
            @Query("radius") String radius,
            @Query("type") String type,
            @Query("keyword") String keyword,
            @Query("key") String key
    );*/

    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyCsKl9-SV-8Bs_kTyq_GuXnLRFeqoHseOQ")
    Call<String> getNearbyPlaces(
            @Query("type") String type,
            @Query("location") String location,
            @Query("radius") int radius);


    /////////////////////////////////////// HOME

    @GET("home/{id}")
    Call<String> DashBoard(
            @Path("id") String user_id
    );

    //////////////////////////////////////// USER AUTH-CONTROLLER

    @FormUrlEncoded
    @POST("login/employee")
    Call<String> login(
            @Field("user_type") String user_type,
            @Field("user_auth") String user_auth,
            @Field("user_password") String password
    );


   ///////////////////////////////////////// LOCATION-APIS

    @Multipart
    @POST("location_media/create")
    Call<String> LocationMediaCreate(
            @Part MultipartBody.Part file,
            @Part("location_id") RequestBody employee_id);

    @FormUrlEncoded
    @POST("location_log/create")
    Call<String> PostLocationLog(
            @Field("user_id") String user_id,
            @Field("user_location") String user_location
    );

    @FormUrlEncoded
    @POST("location/check_in")
    Call<String> LocationCheckIn(
            @Field("user_id") String user_id,
            @Field("user_location") String user_location
    );

    @POST("location/check_out/{id}")
    Call<String> LocationCheckOut(
            @Path("id") String location_id
    );

    @GET("location/get/{id}")
    Call<String> GetLocationLog(
            @Path("id") String user_id
    );

    @GET("location_history/get/{id}/{date}/{offset}")
    Call<String> GetLocationHistory(
            @Path("id") String employee_id,
            @Path("date") String date,
            @Path("offset") String page
    );

    ////////////////////////////  LOCATION-MEDIA

    @GET("location_media/get/location/{id}")
    Call<String> GetLocationMedia(
            @Path("id") String location_id
    );


    ////////////////////////////  CLIENT

    @FormUrlEncoded
    @POST("client/create")
    Call<String> CreateClient(
            @Field("client_name") String client_name,
            @Field("client_email") String client_email,
            @Field("client_phone") String client_phone,
            @Field("client_type") String client_type,
            @Field("client_address") String client_address
    );

    @GET("client/list/{offset}")
    Call<String> ClientList(
            @Path("offset") String page
    );

    @FormUrlEncoded
    @POST("client/update/{id}")
    Call<String> UpdateClient(
            @Path("id") String client_id,
            @Field("client_name") String client_name,
            @Field("client_email") String client_email,
            @Field("client_phone") String client_phone,
            @Field("client_type") String client_type,
            @Field("client_address") String client_address
    );

    @Multipart
    @POST("client/profile/{id}")
    Call<String> UpdateClientProfile(
            @Path("id") String client_id,
            @Part MultipartBody.Part file);

    ////////////////////////////  CLIENT_TYPE

    @FormUrlEncoded
    @POST("client_type/create")
    Call<String> CreateClientType(
            @Field("type_name") String type_name
    );

    @GET("client_type/list/{offset}")
    Call<String> ClientType(
            @Path("offset") String page
    );

    @FormUrlEncoded
    @POST("client_type/update/{id}")
    Call<String> ClientTypeUpdate(
            @Path("id") String page,
            @Field("type_name") String type_name
    );

    ////////////////////////////  ROUTES

    @FormUrlEncoded
    @POST("route/create")
    Call<String> CreateRoute(
            @Field("route_name") String service_name,
            @Field("route_start") String route_start,
            @Field("route_end") String route_end
    );

    @GET("route/list/{offset}")
    Call<String> RouteList(
            @Path("offset") String page
    );

    @FormUrlEncoded
    @POST("route/update/{id}")
    Call<String> RouteUpdate(
            @Path("id") String page,
            @Field("route_name") String route_name,
            @Field("route_start") String route_start,
            @Field("route_end") String route_end

    );

    ////////////////////////////  SERVICE

    @FormUrlEncoded
    @POST("service/create")
    Call<String> CreateService(
            @Field("service_name") String service_name
    );

    @GET("service/list/{offset}")
    Call<String> ServiceList(
            @Path("offset") String page
    );

    @FormUrlEncoded
    @POST("service/update/{id}")
    Call<String> ServiceUpdate(
            @Path("id") String id,
            @Field("service_name") String service_name
    );

    ///////////////////////// FOLLOW_UPS

    @FormUrlEncoded
    @POST("follow_up/create")
    Call<String> FollowUpCreate(
            @Field("client_id") String client_id,
            @Field("employee_id") String employee_id,
            @Field("service_id") String service_id,
            @Field("scheduled_visit_date") String scheduled_visit_date,
            @Field("scheduled_visit_time") String scheduled_visit_time,
            @Field("remarks") String remarks
    );

    @GET("follow_up/get/{id}/{date}/{offset}")
    Call<String> FollowUpList(
            @Path("id") String employee_id,
            @Path("date") String date,
            @Path("offset") String page
    );

    /////////////////////////// CLIENT ROUTES

    @GET("route_clients/get/{id}/{offset}")
    Call<String> RoutesClientList(
            @Path("id") String route_id,
            @Path("offset") String page
    );

    @GET("route_clients/list/{offset}")
    Call<String> RoutesClientAll(
            @Path("offset") String page
    );

    @FormUrlEncoded
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
    );
}
