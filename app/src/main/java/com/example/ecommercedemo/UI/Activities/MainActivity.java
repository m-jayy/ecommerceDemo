package com.example.ecommercedemo.UI.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.ecommercedemo.Helpers.FragmentHandler;
import com.example.ecommercedemo.Interface.OnFragmentInteractionListener;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.Interface.IBase;
import com.example.ecommercedemo.UI.Fragments.Cart;
import com.example.ecommercedemo.UI.Fragments.ProductList;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;
import com.example.ecommercedemo.ViewModels.ProductCartViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Base implements IBase, OnFragmentInteractionListener, View.OnClickListener {

    public FragmentHandler fragmentHandler;
    ProductCartViewModel productCartViewModel;
    public FloatingActionButton cart;
    ImageView btnBack;
    ArrayList<apiCallProductsDetailResponse> _apiCallProductsDetailResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout content = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_main, content);
        callInitializer(this);
    }

    @Override
    public void initializeControls() {
        fragmentHandler = new FragmentHandler(R.id.rlFragmentHandler, this);
        btnBack = (ImageView) findViewById(R.id.btnBack);
        cart = (FloatingActionButton) findViewById(R.id.cart);
        productCartViewModel = ViewModelProviders.of(this).get(ProductCartViewModel.class);
        cart.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        productCartViewModel.getGetAllProducts().observe(this, new Observer<List<apiCallProductsDetailResponse>>() {
            @Override
            public void onChanged(List<apiCallProductsDetailResponse> apiCallProductsDetailResponses) {
                if(apiCallProductsDetailResponses.size()==0)
                {
                    _apiCallProductsDetailResponses = null;
                    cart.setVisibility(View.GONE);
                }
                else
                {
                    _apiCallProductsDetailResponses = new ArrayList<>();
                    _apiCallProductsDetailResponses.addAll(apiCallProductsDetailResponses);
                    cart.setVisibility(View.VISIBLE);
                }
            }
        });
        fragmentHandler.replaceFragment(new ProductList(fragmentHandler), false);
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

    @Override
    public void onClick(View view) {
        super.onClick(view);

        if(view ==cart)
        {
            fragmentHandler.replaceFragment(new Cart(fragmentHandler,_apiCallProductsDetailResponses), true);
        }
        else if(view == btnBack)
        {
            fragmentHandler.popStack();
        }
    }

    public void setBackEnabled(Boolean enable) {
        if (enable) {
            btnBack.setVisibility(View.VISIBLE);
        } else {
            btnBack.setVisibility(View.GONE);
        }
    }
}
