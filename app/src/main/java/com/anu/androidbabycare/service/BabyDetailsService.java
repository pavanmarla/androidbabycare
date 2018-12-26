package com.anu.androidbabycare.service;

import com.anu.androidbabycare.model.BabyDetails;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by hp on 12/24/2018.
 */

public interface BabyDetailsService {

    @POST("/baby-details")
        //   @FormUrlEncoded
    Call<BabyDetails> saveBabyDetails(@Body BabyDetails babyDetails);


    @GET("/baby-details/{id}")
    Call<BabyDetails> getBabyDetails(@Path("id") Integer id);
}







