package com.example.ecommercedemo.ViewModels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;
import com.example.ecommercedemo.Repository.Repository;

import java.util.ArrayList;
import java.util.List;


public class ProductCartViewModel extends AndroidViewModel {
    Repository actorRepository;

    public ProductCartViewModel(@NonNull Application application) {
        super(application);
        actorRepository = new Repository(getApplication());
//        checkDb = actorRepository.getGetAllActors()

    }


    public LiveData<List<apiCallProductsDetailResponse>> getGetAllProducts() {
        return actorRepository.getGetAllProducts();
    }

    public void deleteAllDrugs() {
        actorRepository.deleteAllDrugs();
    }

    public void deleteProductFromCart(int id) {
        actorRepository.deleteProductFromCart(id);
    }



    public void inset(apiCallProductsDetailResponse product) {
        actorRepository.inset(product);
    }
}
