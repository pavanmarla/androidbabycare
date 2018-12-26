package com.anu.androidbabycare.service;

import com.anu.androidbabycare.model.BabyVaccine;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by hp on 12/25/2018.
 */

public interface BabyVaccineService {

    @POST("baby-vaccination")
    Call<BabyVaccine> saveBabyVaccine(@Body BabyVaccine babyVaccine);

    @GET("baby-vaccination")
    Call<List<BabyVaccine>> getBabyVaccine();
}
