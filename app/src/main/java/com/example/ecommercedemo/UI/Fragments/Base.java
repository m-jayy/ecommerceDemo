package com.example.ecommercedemo.UI.Fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ecommercedemo.Helpers.AppLog;
import com.example.ecommercedemo.Helpers.httpHelper.callApi;
import com.example.ecommercedemo.Interface.IBase;
import com.example.ecommercedemo.Interface.OnFragmentInteractionListener;

public class Base extends Fragment implements View.OnClickListener {

    private static final String TAG = Base.class.getSimpleName();
    private OnFragmentInteractionListener mListener;
    private boolean doLog = false;
    IBase ibase;
    Context _context;

    public Base() {
        // Required empty public constructor
    }


    public boolean onBackPressed() {

        return false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (doLog) {
            AppLog.i(TAG, "onCreate: " + this.getClass().getName());
        }
    }


    protected void callInitializer(IBase ibase_, View view) {
        ibase = ibase_;
        ibase.initializeControls(view);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (doLog)
            AppLog.i(TAG, "onCreateView: " + this.getClass().getName());
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        _context = context;
        if (doLog) {
            AppLog.i(TAG, "onAttach: " + this.getClass().getName());
        }
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (Base.OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " Fragment interaction listener must extend " + OnFragmentInteractionListener.class.getName());
//        }
    }



    public void restCall(final String type,  Object cv, boolean loader)
    {
        closeKeyBoard();

            callApi callObj = new callApi(ibase,_context);
            callObj.apiCal(type,cv,loader);

    }

    protected void restCallUrl(String Url, final String type, Object cv, boolean loader) {
        closeKeyBoard();
        callApi callObj = new callApi(ibase, _context);
        callObj.apiCallURl(Url, type, cv, loader);

    }

    public void closeKeyBoard() {


        final InputMethodManager imm;
        try {
            imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    public void onResume() {
        super.onResume();
        if (doLog)
            AppLog.i(TAG, "onResume: " + this.getClass().getName());

    }

    @Override
    public void onPause() {
        super.onPause();
        if (doLog)
            AppLog.i(TAG, "onPause: " + this.getClass().getName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (doLog)
            AppLog.i(TAG, "onDestroyView: " + this.getClass().getName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (doLog)
            AppLog.i(TAG, "onDestroy: " + this.getClass().getName());
    }

    public void showToast(String Msg)
    {
        Toast.makeText(_context, Msg, Toast.LENGTH_SHORT).show();
    }


    public void showToastLong(String Msg)
    {
        Toast.makeText(_context, Msg, Toast.LENGTH_LONG).show();
    }


    /*
     * detach fragment interaction listener
     * */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        if (doLog)
            AppLog.i(TAG, "onDetach: " + this.getClass().getName());
    }

    public void refresh(){

    }

}