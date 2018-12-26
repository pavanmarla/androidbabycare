package com.anu.androidbabycare.service;

import com.anu.androidbabycare.model.WeightMaster;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hp on 12/25/2018.
 */

public interface WeightMasterService {

    @GET("/weight-master")
    Call<List<WeightMaster>> getWeightMaster();
}
