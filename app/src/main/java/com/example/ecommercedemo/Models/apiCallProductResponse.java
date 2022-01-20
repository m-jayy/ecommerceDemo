package com.example.ecommercedemo.Models;

import java.util.ArrayList;
import java.util.List;

public class apiCallProductResponse {
    private ArrayList<apiCallProductsDetailResponse> responseBody = null;

    public ArrayList<apiCallProductsDetailResponse> getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ArrayList<apiCallProductsDetailResponse> responseBody) {
        this.responseBody = responseBody;
    }
}
