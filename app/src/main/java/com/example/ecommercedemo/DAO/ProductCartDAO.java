package com.example.ecommercedemo.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface ProductCartDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(apiCallProductsDetailResponse product);

    @Query("SELECT * FROM productCart")
    LiveData<List<apiCallProductsDetailResponse>> getAllCartProducts();

    @Query("DELETE FROM productCart")
    void deleteAll();

    @Query("DELETE FROM productCart WHERE id = :productID")
    void deleteProduct(int productID);
}
