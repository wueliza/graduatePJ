package com.project.graduatepj;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RESTfulApi {
    @GET("patient")
    Call<List<Patient_Api>> getPosts();

    @GET("patient/{patientNum}") //1 . 2 . 3 ...
    Call<Patient_Api> getOne(@Path("patientNum")String patientNum);

    @GET("staff/{emid}") //A00001 ...
    Call<Staff_Api> get_staff(@Path("emid")String emid);

    @POST("patient")
    Call<Patient_Api> postData(@Body Patient_Api paitentApi);

    @GET("eisai/{eisaiNum}")
    Call<Eisai_Api> get_eisai(@Path("eisaiNum")String eisaiNum);

    @GET("operation/{ora4Chart}")
    Call<Operation_Api> get_operation(@Path("ora4Chart")String ora4Chart);


}
