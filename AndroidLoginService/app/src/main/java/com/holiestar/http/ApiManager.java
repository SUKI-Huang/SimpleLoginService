package com.holiestar.http;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Suki on 9/18/2017.
 */

public class ApiManager {
    private static Context context;
    private static final String TAG = ApiManager.class.getSimpleName();

    private static Gson gson;
    private static Retrofit retrofit;

    public static void initialize(Context _context) {
        context = _context.getApplicationContext();
    }

    public static Retrofit getRetrofit() {
        if (retrofit != null) return retrofit;
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.google.com")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Gson getGson() {
        if (gson != null) return gson;
        gson = new GsonBuilder().setPrettyPrinting().create();
        return gson;
    }

}
