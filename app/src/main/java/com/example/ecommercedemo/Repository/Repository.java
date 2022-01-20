package com.example.ecommercedemo.Repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.ecommercedemo.DataBase.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;


public class Repository {
    private Database database;
    private LiveData<List<apiCallProductsDetailResponse>> getAllProducts;

    public Repository(Application application) {
        database = Database.getInstance(application);
    }

    public void inset(apiCallProductsDetailResponse product){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.productCartDAO().insert(product);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //UI Thread work here
                    }
                });
            }
        });
    }

   public LiveData<List<apiCallProductsDetailResponse>> getGetAllProducts(){
       return database.productCartDAO().getAllCartProducts();
   }

    public void deleteAllDrugs(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                database.productCartDAO().deleteAll();
            }
        });

    }

    public void deleteProductFromCart(int id){
        database.productCartDAO().deleteProduct(id);
    }
}
