package com.example.ecommercedemo.Helpers;

import androidx.room.TypeConverter;

import com.example.ecommercedemo.Models.ProductRating;

import java.util.Date;

public class DataConverters {
        @TypeConverter
        public static ProductRating toRating(Double dateLong){
            return dateLong == null ? null: new ProductRating(dateLong);
        }

        @TypeConverter
        public static Double fromRating(ProductRating rating){
            return rating == null ? null : rating.getRate();
        }
}
