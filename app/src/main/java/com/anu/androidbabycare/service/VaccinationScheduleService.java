package com.anu.androidbabycare.service;

import com.anu.androidbabycare.model.VaccineSchedule;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hp on 12/25/2018.
 */

public interface VaccinationScheduleService {

    @GET("/vaccine-schedule")
    Call<List<VaccineSchedule>> getVaccineSchedule();
}
