package com.example.ecommercedemo.UI.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ecommercedemo.Helpers.FragmentHandler;
import com.example.ecommercedemo.Interface.IBase;
import com.example.ecommercedemo.Interface.OnFragmentInteractionListener;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.UI.Activities.MainActivity;

public class Home extends Base implements IBase, View.OnClickListener {

    Context mContext;

    private OnFragmentInteractionListener mListener;
    FragmentHandler fragmentHandler;

    public Home(FragmentHandler _fragmentHandler) {
        fragmentHandler = _fragmentHandler;
    }

    public Home() {
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
        showToast("Hello");
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
}