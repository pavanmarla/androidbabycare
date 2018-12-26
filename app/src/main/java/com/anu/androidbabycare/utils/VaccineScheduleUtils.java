package com.anu.androidbabycare.utils;

import com.anu.androidbabycare.retrofitclient.RetrofitClient;
import com.anu.androidbabycare.service.BabyDetailsService;
import com.anu.androidbabycare.service.VaccinationScheduleService;

/**
 * Created by hp on 12/25/2018.
 */

public class VaccineScheduleUtils {

    public VaccineScheduleUtils(){

    }

    public static VaccinationScheduleService getVaccineScheduleService(){
        return RetrofitClient.getClient(CommonUtils.BASE_URL).create(VaccinationScheduleService.class);
    }
}
