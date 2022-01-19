package com.example.ecommercedemo.UI.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.UI.Interface.IBase;

public class MainActivity extends Base implements IBase, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initializeControls() {

    }

    @Override
    public void apiCallBack(Object obj, String type) {

    }

    @Override
    public void initializeControls(View view) {

    }

    @Override
    public void apiCallBackFailed(Object obj, String type) {

    }
}