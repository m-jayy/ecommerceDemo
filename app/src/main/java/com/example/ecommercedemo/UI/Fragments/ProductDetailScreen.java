package com.example.ecommercedemo.UI.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.ecommercedemo.Helpers.FragmentHandler;
import com.example.ecommercedemo.Interface.IBase;
import com.example.ecommercedemo.Interface.OnFragmentInteractionListener;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.UI.Activities.MainActivity;
import com.example.ecommercedemo.UI.CustomComponents.Button_N;
import com.example.ecommercedemo.UI.CustomComponents.TextView_B;
import com.example.ecommercedemo.UI.CustomComponents.TextView_N;
import com.example.ecommercedemo.ViewModels.ProductCartViewModel;

import java.util.ArrayList;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class ProductDetailScreen extends Base implements IBase, View.OnClickListener {

    Context mContext;
    private OnFragmentInteractionListener mListener;
    FragmentHandler fragmentHandler;
    apiCallProductsDetailResponse _apiCallProductsDetailResponse;
    ProductCartViewModel productCartViewModel;

    TextView_B tvTitle;
    TextView_N tvDesc;
    TextView_B tvPrice;
    MaterialRatingBar rbProductRating;
    Button_N btnAddToCart;
    ImageView imImage;

    public ProductDetailScreen(FragmentHandler _fragmentHandler) {
        fragmentHandler = _fragmentHandler;
    }

    public ProductDetailScreen(FragmentHandler _fragmentHandler, apiCallProductsDetailResponse apiCallProductsDetailResponse) {

        fragmentHandler = _fragmentHandler;
        _apiCallProductsDetailResponse = apiCallProductsDetailResponse;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        callInitializer(this, _view);

        return _view;
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            ((MainActivity) getActivity()).setBackEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }

    @Override
    public void initializeControls() {


    }


    @Override
    public void initializeControls(View view) {
        tvTitle = (TextView_B) view.findViewById(R.id.tvTitle);
        tvDesc = (TextView_N) view.findViewById(R.id.tvDesc);
        tvPrice = (TextView_B) view.findViewById(R.id.tvPrice);
        imImage= (ImageView) view.findViewById(R.id.imImage);
        rbProductRating =(MaterialRatingBar) view.findViewById(R.id.rbProductRating);
        btnAddToCart= (Button_N) view.findViewById(R.id.btnAddToCart);
        productCartViewModel = ViewModelProviders.of(this).get(ProductCartViewModel.class);

        btnAddToCart.setOnClickListener(this);
        tvTitle.setText(_apiCallProductsDetailResponse.getTitle());
        tvDesc.setText(_apiCallProductsDetailResponse.getDescription());
        tvPrice.setText("$ "+_apiCallProductsDetailResponse.getPrice().toString());
        rbProductRating.setRating(_apiCallProductsDetailResponse.getRating().getRate().floatValue());
        Glide.with(mContext).load(_apiCallProductsDetailResponse.getImage()).centerCrop().into(imImage);

        rbProductRating.setRating(3.6f);
    }


    @Override
    public void apiCallBack(Object obj, String type) {

    }

    @Override
    public void apiCallBackFailed(Object obj, String type) {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        if(view==btnAddToCart)
        {
            showToast("Added to Cart");
            fragmentHandler.popStack();
            productCartViewModel.inset(_apiCallProductsDetailResponse);
        }
    }

}