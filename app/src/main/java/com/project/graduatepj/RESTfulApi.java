package com.project.graduatepj;
<<<<<<< HEAD

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
=======
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
>>>>>>> b929755c5c7a990e93dfc68ed9bee5897ca29519
import retrofit2.http.Path;

public interface RESTfulApi {
    @GET("patient")
    Call<List<Paitent_Api>> getPosts();

    @GET("patient/{patientNum}")
<<<<<<< HEAD
    Call<Paitent_Api> getOne(@Path("patientNum")String patientNum);

    @GET("staff/{emid}")
    Call<Staff_Api> get_staff(@Path("emid")String emid);
=======
    Call<Paitent_Api> getOne(@Path("patientNum") String patientNum);
////2021/8/18/////
    @POST("patient")
    Call<Paitent_Api> postData(@Body Paitent_Api paitentApi);
>>>>>>> b929755c5c7a990e93dfc68ed9bee5897ca29519
}
