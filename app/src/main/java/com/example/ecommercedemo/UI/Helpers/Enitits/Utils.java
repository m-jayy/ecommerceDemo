package com.example.ecommercedemo.UI.Helpers.Enitits;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    static Pattern HTML_PATTERN = Pattern.compile("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");

    public static Class getResponseClass(String type) {

        // to be added
        return null;
    }


    public static String firstLetterCapital(String myString) {
        try {
            // return  myString.substring(0, 1).toUpperCase() + myString.substring(1);

            String firstLetter = myString.substring(0, 1);

            if (firstLetter.equals("µ")) {
                return firstLetter + myString.substring(1);
            } else {
                return myString.substring(0, 1).toUpperCase() + myString.substring(1);
            }

            //return  myString;

        } catch (Exception e) {
            return "";
        }
    }

    public static String formatDate(String dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "ddMMyyyyHHmmss");
        Date myDate = null;
        try {
            myDate = dateFormat.parse(dateTime);
            SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            return timeFormat.format(myDate);

        } catch (Exception e) {
            //  e.printStackTrace();
        }

        return "--";


    }


    public static String dateToString(Date _date) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("MM-dd-yyyy");
        return timeFormat.format(_date);
    }

    public static String availableDateTime(String EffectiveDateTime, String Issued) {
        try {
            if (!EffectiveDateTime.isEmpty())
                return EffectiveDateTime;
            else if (!Issued.isEmpty())
                return Issued;
        } catch (Exception e) {
            return null;
        }
        return null;

    }

    public static Date StringToDate(String _date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        Date myDate = null;
        try {
            myDate = dateFormat.parse(_date);
            return myDate;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();

    }

    public static boolean isHTML(String html) {
        Matcher matcher = HTML_PATTERN.matcher(html);
        return matcher.find();
    }

    public static boolean isEmpty(String text) {
        return text.equals("");
    }

    public static boolean isFullname(String str) {
        String expression = "^[a-zA-Z\\s]+";
        return str.matches(expression);
    }

}
