package com.example.ecommercedemo.UI.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommercedemo.Adapters.cartAdapter;
import com.example.ecommercedemo.Helpers.FragmentHandler;
import com.example.ecommercedemo.Interface.IBase;
import com.example.ecommercedemo.Interface.OnFragmentInteractionListener;
import com.example.ecommercedemo.Interface.ProductOnClickCallback;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.UI.Activities.MainActivity;
import com.example.ecommercedemo.UI.CustomComponents.Button_N;
import com.example.ecommercedemo.UI.CustomComponents.TextView_B;
import com.example.ecommercedemo.ViewModels.ProductCartViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class Cart extends Base implements IBase, View.OnClickListener, ProductOnClickCallback {

    Context mContext;
    private OnFragmentInteractionListener mListener;
    FragmentHandler fragmentHandler;
    ProductCartViewModel productCartViewModel;

    TextView_B tvCart;

    ArrayList<apiCallProductsDetailResponse> _apiCallProductsDetailResponse;
    LinearLayoutManager linearLayoutManager;
    private RecyclerView rvAvailableSources;
    cartAdapter _cartAdapter;

    public Cart(FragmentHandler _fragmentHandler, ArrayList<apiCallProductsDetailResponse> apiCallProductsDetailResponses) {
        fragmentHandler = _fragmentHandler;
        _apiCallProductsDetailResponse = apiCallProductsDetailResponses;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_cart, container, false);
        callInitializer(this, _view);

        return _view;
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            ((MainActivity) getActivity()).setBackEnabled(true);
            ((MainActivity) getActivity()).cart.setVisibility(View.GONE);
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
        _cartAdapter = new cartAdapter(_apiCallProductsDetailResponse,mContext,this);
        rvAvailableSources = (RecyclerView) view.findViewById(R.id.rvAvailableSources);
        productCartViewModel = ViewModelProviders.of(this).get(ProductCartViewModel.class);
        tvCart = view.findViewById(R.id.tvCart);

        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rvAvailableSources.setLayoutManager(linearLayoutManager);
        rvAvailableSources.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvAvailableSources.getContext(),
                ((LinearLayoutManager) linearLayoutManager).getOrientation());

        rvAvailableSources.setAdapter(_cartAdapter);

        setUpCheckoutButton();
    }

    public void setUpCheckoutButton()
    {
        try {
            tvCart.setText("Checkout("+_apiCallProductsDetailResponse.size()+")");
        }
        catch (Exception e)
        {
            e.getLocalizedMessage();
            tvCart.setText("Checkout");
        }

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
    }

    @Override
    public void onClick(apiCallProductsDetailResponse apiCallProductsDetailResponse) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                productCartViewModel.deleteProductFromCart(apiCallProductsDetailResponse.getId());
                _apiCallProductsDetailResponse.remove(apiCallProductsDetailResponse);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(_apiCallProductsDetailResponse.size()==0)
                        {
                            fragmentHandler.popStack();
                        }
                        else {
                            _cartAdapter.notifyDataSetChanged();
                            setUpCheckoutButton();
                        }
                    }
                });
            }
        });
    }
}