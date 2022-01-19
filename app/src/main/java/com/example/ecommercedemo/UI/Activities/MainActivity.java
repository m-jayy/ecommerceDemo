package com.example.ecommercedemo.UI.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.ecommercedemo.Helpers.FragmentHandler;
import com.example.ecommercedemo.Interface.OnFragmentInteractionListener;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.Interface.IBase;
import com.example.ecommercedemo.UI.Fragments.Home;

public class MainActivity extends Base implements IBase, OnFragmentInteractionListener, View.OnClickListener {

    public FragmentHandler fragmentHandler;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout content = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_main, content);
        callInitializer(this);
    }

    public void setBackEnabled(Boolean enable) {
        if (enable) {
            btnBack.setVisibility(View.VISIBLE);
        } else {
            btnBack.setVisibility(View.GONE);
        }
    }

    @Override
    public void initializeControls() {
        fragmentHandler = new FragmentHandler(R.id.rlFragmentHandler, this);
        fragmentHandler.replaceFragment(new Home(fragmentHandler), false);
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

    @Override
    public void onFragmentInteraction(String from, String action) {

    }
}
