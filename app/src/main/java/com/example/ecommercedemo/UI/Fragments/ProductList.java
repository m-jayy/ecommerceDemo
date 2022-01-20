package com.example.ecommercedemo.UI.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommercedemo.Adapters.productFragmentAdapter;
import com.example.ecommercedemo.Adapters.productFragmentShimmerAdapter;
import com.example.ecommercedemo.Helpers.Enitits.Constants;
import com.example.ecommercedemo.Helpers.FragmentHandler;
import com.example.ecommercedemo.Interface.IBase;
import com.example.ecommercedemo.Interface.OnFragmentInteractionListener;
import com.example.ecommercedemo.Interface.ProductOnClickCallback;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.UI.Activities.MainActivity;
import com.example.ecommercedemo.ViewModels.ProductCartViewModel;

import java.util.ArrayList;

public class ProductList extends Base implements IBase, View.OnClickListener, ProductOnClickCallback {

    Context mContext;
    ArrayList<apiCallProductsDetailResponse> _apiCallProductsDetailResponse;
    private OnFragmentInteractionListener mListener;
    FragmentHandler fragmentHandler;
    LinearLayoutManager linearLayoutManager;
    private RecyclerView rvAvailableSources;
    productFragmentAdapter _productFragmentAdapter;
    productFragmentShimmerAdapter productFragmentShimmerAdapter;


    public ProductList(FragmentHandler _fragmentHandler) {
        fragmentHandler = _fragmentHandler;
    }

    public ProductList(FragmentHandler _fragmentHandler, Object obj) {

        fragmentHandler = _fragmentHandler;
        _apiCallProductsDetailResponse = (ArrayList<apiCallProductsDetailResponse>) obj;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_home, container, false);
        callInitializer(this, _view);


        return _view;

    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            ((MainActivity) getActivity()).setBackEnabled(false);
            ((MainActivity) getActivity()).cart.setVisibility(View.VISIBLE);
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
        rvAvailableSources = (RecyclerView) view.findViewById(R.id.rvAvailableSources);
        restCallUrl(Constants.getMainUrl(), Constants.products, null, false);
        addShimmerEffect();

    }

    private void addShimmerEffect() {
        productFragmentShimmerAdapter = new productFragmentShimmerAdapter(mContext);

        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rvAvailableSources.setLayoutManager(new GridLayoutManager(_context, 2));
        rvAvailableSources.setAdapter(productFragmentShimmerAdapter);
    }

    @Override
    public void apiCallBack(Object obj, String type) {
        _apiCallProductsDetailResponse = (ArrayList<apiCallProductsDetailResponse>) obj;
        _productFragmentAdapter = new productFragmentAdapter(_apiCallProductsDetailResponse, mContext, this);

        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rvAvailableSources.setLayoutManager(new GridLayoutManager(_context, 2));
        rvAvailableSources.setAdapter(_productFragmentAdapter);
    }

    @Override
    public void apiCallBackFailed(Object obj, String type) {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

    }

    @Override
    public void onClick(apiCallProductsDetailResponse apiCallProductsDetailResponse) {
        fragmentHandler.replaceFragment(new ProductDetailScreen(fragmentHandler, apiCallProductsDetailResponse), true);
    }
}