package com.example.ecommercedemo.Interface;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface apiDefinition {



//    @Headers({
//            "Content-Type: text/xml",
//            "Accept-Charset: utf-8"
//    })

//
//    @POST("api/products")
//    Call<ResponseBody> products
//            (@Body apiRequestCall _req);
//

    @GET("products/")
    Call<ResponseBody> products();



}
