package com.anu.androidbabycare.utils;

import com.anu.androidbabycare.retrofitclient.RetrofitClient;
import com.anu.androidbabycare.service.HeightMasterService;

/**
 * Created by hp on 12/25/2018.
 */

public class HeightMasterUtils {

    public HeightMasterUtils(){

    }

    public static HeightMasterService getHeightMasterService(){
        return RetrofitClient.getClient(CommonUtils.BASE_URL).create(HeightMasterService.class);
    }
}
