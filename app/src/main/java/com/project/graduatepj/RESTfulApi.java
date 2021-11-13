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

    @GET("patient/{qrChart}") //1 . 2 . 3 ... 病人的api
    Call<Patient_Api> getOne(@Path("qrChart")String qrChart);

    @GET("staff/{emid}") //A00001 ...
    Call<Staff_Api> get_staff(@Path("emid")String emid);

    @POST("patient")
    Call<Patient_Api> postData(@Body Patient_Api patientApi);

    @GET("eisai/{eisaiNum}")
    Call<Eisai_Api> get_eisai(@Path("eisaiNum")String eisaiNum);

    @GET("ora4chart/{ora4Chart}")
    Call<ORA4_CHART_API> get_ora4Chart(@Path("ora4Chart")String ora4Chart);

    @GET("bloodbank/{blnos}")
    Call<Bloodbank_Api> get_bloodbank(@Path("blnos")String blnos);

    @GET("checkoperation/{bsnos}")
    Call<CheckOperation_Api> get_checkoperation(@Path("bsnos")String bsnos);

    @GET("medicine/{tubg}")
    Call<Medicine_Api> get_medicine(@Path("tubg")String tubg);

    @GET("tpr/{tprnum}")
    Call<Tpr_Api> get_Tpr(@Path("tprnum")String tprnum);

    @GET("tpr/{tprnum}")
    Call<Tprtime_Api> get_tprtime(@Path("tprnum")String tprnum);

    @GET("tpr/{rqno}")
    Call<TransOperation_Api> get_transoperation(@Path("rqno")String rqno);
}
