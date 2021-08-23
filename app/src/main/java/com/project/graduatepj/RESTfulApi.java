package com.project.graduatepj;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RESTfulApi {
    @GET("patient")
    Call<List<Paitent_Api>> getPosts();

    @GET("patient/{patientNum}")
    Call<Paitent_Api> getOne(@Path("patientNum")String patientNum);

    @GET("staff/{emid}")
    Call<Staff_Api> get_staff(@Path("emid")String emid);
}
