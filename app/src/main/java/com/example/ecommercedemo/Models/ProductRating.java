package com.example.ecommercedemo.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductRating {
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("count")
    @Expose
    private Integer count;

    public ProductRating(Double rate) {
       this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
