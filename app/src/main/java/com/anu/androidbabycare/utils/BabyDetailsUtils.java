package com.anu.androidbabycare.utils;

import com.anu.androidbabycare.retrofitclient.RetrofitClient;
import com.anu.androidbabycare.service.BabyDetailsService;

/**
 * Created by hp on 12/24/2018.
 */

public class BabyDetailsUtils {
    public BabyDetailsUtils() {

    }

    public static BabyDetailsService getBabyDetailsService(){
        return RetrofitClient.getClient(CommonUtils.BASE_URL).create(BabyDetailsService.class);
    }


}
