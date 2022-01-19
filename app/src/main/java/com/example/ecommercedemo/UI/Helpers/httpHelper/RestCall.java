package com.example.ecommercedemo.UI.Helpers.httpHelper;

import com.example.ecommercedemo.UI.Helpers.Enitits.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestCall {

    private static Retrofit retrofitMain = null;


    public static Retrofit getMainClient() {

        if (retrofitMain == null) {

            final OkHttpClient okHttpClient = new OkHttpClient.Builder()

                    .readTimeout(Constants.RetroFItTimeout, TimeUnit.SECONDS)
                    .connectTimeout(Constants.RetroFItTimeout, TimeUnit.SECONDS)
                    .callTimeout(Constants.RetroFItTimeout, TimeUnit.SECONDS)
                    .build();

            retrofitMain = new Retrofit.Builder()
                    .baseUrl(Constants.getMainUrl())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofitMain;
    }
}
