package com.project.graduatepj;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RESTfulApi {
    @GET("patient")
    Call<List<Paitent_Api>> getPosts();
<<<<<<< HEAD
=======
    @GET("patient/{patientNum}")
    Call<Paitent_Api> getOne(@Path("patientNum")String patientNum);
    @GET("staff/{emid}")
    Call<Staff_Api> get_staff(@Path("emid")String emid);
    Call<Paitent_Api> getOne(@Path("patientNum") String patientNum);
////2021/8/18/////
>>>>>>> 880dc64bb1b4ac02da92c0d356b0fc3cd4c8b939

    @GET("patient/{patientNum}") //1 . 2 . 3 ...
    Call<Paitent_Api> getOne(@Path("patientNum")String patientNum);

    @GET("staff/{emid}") //A00001 ...
    Call<Staff_Api> get_staff(@Path("emid")String emid);

    @POST("patient")
    Call<Paitent_Api> postData(@Body Paitent_Api paitentApi);

}
