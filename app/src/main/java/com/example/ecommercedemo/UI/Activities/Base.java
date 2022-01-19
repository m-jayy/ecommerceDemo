package com.example.ecommercedemo.UI.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.UI.Helpers.httpHelper.callApi;
import com.example.ecommercedemo.UI.Interface.IBase;

public class Base extends AppCompatActivity implements View.OnClickListener {

    IBase ibase;
    ProgressDialog loadingDialog;
    ImageView btnBack;

    protected void callApi() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void closeKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    protected void showToastLong(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
    }

    protected void callInitializer(IBase ibase_) {
        ibase = ibase_;
        ibase.initializeControls();
    }

    public void restCall(final String type, Object cv, boolean loader) {
        closeKeyBoard();
        callApi callObj = new callApi(ibase, getApplicationContext());
        callObj.apiCal(type, cv, loader);
    }
}
