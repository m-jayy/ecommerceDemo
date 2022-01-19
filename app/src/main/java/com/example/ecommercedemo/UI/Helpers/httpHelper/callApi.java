package com.example.ecommercedemo.UI.Helpers.httpHelper;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.ecommercedemo.UI.Dialogs.DefaultDialog;
import com.example.ecommercedemo.UI.Dialogs.Loading_Dialog;
import com.example.ecommercedemo.UI.Helpers.Enitits.Constants;
import com.example.ecommercedemo.UI.Helpers.Enitits.Utils;
import com.example.ecommercedemo.UI.Interface.IBase;
import com.example.ecommercedemo.UI.Interface.apiDefinition;
import com.google.gson.Gson;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class callApi {
    public IBase ibase;
    ProgressDialog loadingDialog;
    Context context;

    public callApi(IBase _ibase, Context _context) {
        ibase = _ibase;
        context = _context;
    }

    protected void showLoadingDialog(String message) {
        loadingDialog = Loading_Dialog.ctor(context);
        loadingDialog.setMessage("");
        loadingDialog.show();
    }

    protected void hideLoadingDialog() {
        if (loadingDialog != null)
            loadingDialog.dismiss();
    }

    public void apiCal(final String type, Object cv, final boolean loader) {

        if (loader) {
            showLoadingDialog("");
        }
        apiDefinition apiService;
        RequestBody body = null;

        apiService = RestCall.getMainClient().create(apiDefinition.class);

        Call<ResponseBody> call = null;

        //call api
        ////////////////////////////////////

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (loader) {
                    hideLoadingDialog();
                }

                try {
                    int responceCode = response.code();
                    String responceMessagae = response.message();
                    String responceBody = "";

                    if (response.isSuccessful()) {
                        responceBody = response.body().string();
                    } else {
                        responceBody = response.errorBody().string();
                    }
                    Log.i("onApiResponseType", type + " ");
                    Log.i("onApiResponseBody", responceBody + " ");
                    Log.i("onApiResponseCode", responceCode + " ");
                    Log.i("onApiResponse", "*****************************************");

                    if (responceCode == 200) {
                        Object obj = new Gson().fromJson(responceBody, Utils.getResponseClass(type));

                        if (ibase != null) {
                            ibase.apiCallBack(obj, type);
                        }
                    } else {

                        if (Utils.isHTML(responceBody)) {
                            new DefaultDialog(context, "Server is not reachable", false);
                        } else {
                            Object obj = new Gson().fromJson(responceBody, Utils.getResponseClass(Constants.apiError));
                            if (ibase != null) {
                                ibase.apiCallBackFailed(obj, type);
                            }
                        }
                    }

                } catch (Exception e) {
                    showToast(" " + e.getMessage());
                }
            }


            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (loader) {
                    hideLoadingDialog();
                }

                Log.i("onApiFailure", "***************************************** Time ");
                try {
                    Log.i("onApiFailureMsg", t.getCause().getMessage() + " ");
                } catch (Exception e) {
                    try {
                        Log.i("onApiFailureMsgExcep", t.getMessage() + " ");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                Log.i("onApiResponse", "*****************************************");
                try {
                    String msg = t.getCause().getMessage();
                    if (msg.toLowerCase().contains("socket close")) {
                        showToast("Network Error : Request Timeout");
                    } else {
                        showToast("Network Error : " + msg);
                    }

                } catch (Exception e) {

                    try {
                        String msg = t.getMessage();
                        if (msg.toLowerCase().contains("socket close")) {
                            showToast("Network Error : Request Timeout");
                        } else {
                            showToast("Network Error : " + msg);
                        }

                    } catch (Exception ex) {
                        //  ex.printStackTrace();
                    }
                    //  e.printStackTrace();
                }


            }
        });

    }

    protected void showToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
