package com.example.ecommercedemo.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommercedemo.Interface.ProductOnClickCallback;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.UI.CustomComponents.TextView_B;
import com.example.ecommercedemo.UI.CustomComponents.TextView_N;

import java.util.ArrayList;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class productFragmentShimmerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
 Context con;

    public productFragmentShimmerAdapter(Context con) {
        this.con = con;
    }
    
    
    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


                View view = LayoutInflater.from(con).inflate(R.layout.shimmer_product_row_header, parent, false);
                return new ViewHolderHeader(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

    @Override
    public int getItemCount() {
        try {
            return 20;
        }
        catch (Exception exception)
        {
            Log.d("Error",exception.getLocalizedMessage());
        }
        return 0;
    }

    class ViewHolderHeader extends RecyclerView.ViewHolder {

        public ViewHolderHeader(@NonNull View itemView) {
            super(itemView);
        }
    }

}
