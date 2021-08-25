package com.project.graduatepj;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 507e7ac434364fdd84eec8cd06800a0c89fd8765
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RESTfulApi {
    @GET("patient")
    Call<List<Paitent_Api>> getPosts();
<<<<<<< HEAD
    @GET("patient/{patientNum}")
    Call<Paitent_Api> getOne(@Path("patientNum")String patientNum);
    @GET("staff/{emid}")
    Call<Staff_Api> get_staff(@Path("emid")String emid);
    Call<Paitent_Api> getOne(@Path("patientNum") String patientNum);
////2021/8/18/////
=======

    @GET("patient/{patientNum}") //1 . 2 . 3 ...

    Call<Paitent_Api> getOne(@Path("patientNum")String patientNum);

    @GET("staff/{emid}") //A00001 ...
    Call<Staff_Api> get_staff(@Path("emid")String emid);

>>>>>>> 507e7ac434364fdd84eec8cd06800a0c89fd8765
    @POST("patient")
    Call<Paitent_Api> postData(@Body Paitent_Api paitentApi);
}
