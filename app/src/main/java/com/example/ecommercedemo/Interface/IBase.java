package com.example.ecommercedemo.Interface;


import android.view.View;

import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;

public interface IBase {
    void initializeControls();
    void apiCallBack(Object obj, String type);
    void initializeControls(View view);
    void apiCallBackFailed(Object obj, String type);
}