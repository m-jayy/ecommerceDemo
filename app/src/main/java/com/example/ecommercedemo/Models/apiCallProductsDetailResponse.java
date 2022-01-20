package com.example.ecommercedemo.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.ecommercedemo.Helpers.DataConverters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "productCart")
public class apiCallProductsDetailResponse {

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @ColumnInfo(name = "title")
    @Expose
    private String title;
    @SerializedName("price")
    @ColumnInfo(name = "price")
    @Expose
    private Double price;
    @SerializedName("description")
    @ColumnInfo(name = "description")
    @Expose
    private String description;
    @SerializedName("category")
    @ColumnInfo(name = "category")
    @Expose
    private String category;
    @SerializedName("image")
    @ColumnInfo(name = "image")
    @Expose
    private String image;
    @SerializedName("rating")
    @TypeConverters(DataConverters.class)
    @ColumnInfo(name = "rating")
    @Expose
    private ProductRating rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductRating getRating() {
        return rating;
    }

    public void setRating(ProductRating rating) {
        this.rating = rating;
    }

}
