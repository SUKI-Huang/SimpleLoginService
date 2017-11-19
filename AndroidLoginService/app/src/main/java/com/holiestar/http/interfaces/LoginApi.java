package com.holiestar.http.interfaces;

import com.holiestar.http.model.AzureResultData;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LoginApi {

    @POST
    Flowable<AzureResultData> loginByFacebookViaAzure(
            @Url String url,
            @Body Map<String, Object> params
    );

}
