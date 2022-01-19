package com.example.ecommercedemo.Helpers;


import android.util.Log;

public class AppLog {

    private static final String CONSTANT_TAG = "APP:";

    public static int v(String tag, String msg) {
        tag = CONSTANT_TAG + tag;
        return Log.v(tag, msg);
    }

    public static int v(String tag, String msg, Throwable tr) {
        tag = CONSTANT_TAG + tag;
        return Log.v(tag, msg, tr);
    }

    public static int d(String tag, String msg) {
        tag = CONSTANT_TAG + tag;
        return Log.d(tag, msg);
    }

    public static int d(String tag, String msg, Throwable tr) {
        tag = CONSTANT_TAG + tag;
        return Log.d(tag, msg, tr);
    }

    public static int i(String tag, String msg) {
        tag = CONSTANT_TAG + tag;
        return Log.i(tag, msg);
    }

    public static int i(String tag, String msg, Throwable tr) {
        tag = CONSTANT_TAG + tag;
        return Log.i(tag, msg, tr);
    }

    public static int w(String tag, String msg) {
        tag = CONSTANT_TAG + tag;
        return Log.w(tag, msg);
    }

    public static int w(String tag, String msg, Throwable tr) {
        tag = CONSTANT_TAG + tag;
        return Log.w(tag, msg, tr);
    }

    public static int w(String tag, Throwable tr) {
        tag = CONSTANT_TAG + tag;
        return Log.w(tag, tr);
    }

    public static int e(String tag, String msg) {
        tag = CONSTANT_TAG + tag;
        return Log.e(tag, msg);
    }

    public static int e(String tag, String msg, Throwable tr) {
        tag = CONSTANT_TAG + tag;
        return Log.e(tag, msg, tr);
    }
}
