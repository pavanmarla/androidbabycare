package com.anu.androidbabycare.utils;

import com.anu.androidbabycare.retrofitclient.RetrofitClient;
import com.anu.androidbabycare.service.BabyVaccineService;

/**
 * Created by hp on 12/25/2018.
 */

public class BabyVaccineUtils {
    public BabyVaccineUtils(){

    }

    public static BabyVaccineService getBabyVaccineService(){

        return RetrofitClient.getClient(CommonUtils.BASE_URL).create(BabyVaccineService.class);
    }

}
