package com.anu.androidbabycare.utils;

import com.anu.androidbabycare.retrofitclient.RetrofitClient;
import com.anu.androidbabycare.service.WeightMasterService;

/**
 * Created by hp on 12/25/2018.
 */

public class WeightMasterUtils {

    public WeightMasterUtils(){

    }

    public static WeightMasterService getWeightMasterService(){
        return RetrofitClient.getClient(CommonUtils.BASE_URL).create(WeightMasterService.class);
    }
}
