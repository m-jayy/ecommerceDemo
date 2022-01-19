package com.example.ecommercedemo.Helpers.Enitits;

public class Constants {


    enum Environment {
        Testing,
        Dev,
        Staging,
        DevPublic,
    }


    // Testing for local QA
    // Dev for local Development
    // DevPublic for Public Development
    // Staging for Live Environment


    static Environment env = Environment.Dev;

    /////////////////////////////////


    public static String getMainUrl() {
        if (env == Environment.Dev) {

            return "http://10.0.2.2:8000/";   // IPATH

        }
        return "";
    }

    public static int RetroFItTimeout = 360;
    public static String apiError = "apiError";


}
