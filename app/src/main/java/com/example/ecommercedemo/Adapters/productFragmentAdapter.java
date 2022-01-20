package com.example.ecommercedemo.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommercedemo.Interface.ProductOnClickCallback;
import com.example.ecommercedemo.Models.ProductRating;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;
import com.example.ecommercedemo.R;
import com.example.ecommercedemo.UI.CustomComponents.TextView_B;
import com.example.ecommercedemo.UI.CustomComponents.TextView_N;

import java.util.ArrayList;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class productFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {


    Context con;
    ArrayList<apiCallProductsDetailResponse> _apiCallProductsDetailResponse;
    ProductOnClickCallback _productOnClickCallback;


    public productFragmentAdapter(ArrayList<apiCallProductsDetailResponse> _apiCallProductsDetailResponse, Context con, ProductOnClickCallback productOnClickCallback) {
        this._apiCallProductsDetailResponse = _apiCallProductsDetailResponse;
        this.con = con;
        _productOnClickCallback = productOnClickCallback;
    }
    
    
    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


                View view = LayoutInflater.from(con).inflate(R.layout.product_row_header, parent, false);
                return new ViewHolderHeader(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        apiCallProductsDetailResponse _apiCallDrugsResponseDetail = _apiCallProductsDetailResponse.get(position);
                ViewHolderHeader _viewHolderHeader = (ViewHolderHeader) holder;

                _viewHolderHeader.tvTitle.setText(_apiCallDrugsResponseDetail.getTitle());
        _viewHolderHeader.tvDesc.setText(_apiCallDrugsResponseDetail.getDescription());
        _viewHolderHeader.tvPrice.setText("$ "+_apiCallDrugsResponseDetail.getPrice().toString());
        Glide.with(con).load(_apiCallDrugsResponseDetail.getImage()).centerCrop().into(_viewHolderHeader.imImage);

        _viewHolderHeader.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _productOnClickCallback.onClick(_apiCallProductsDetailResponse.get(position));
            }
        });
        }

    @Override
    public int getItemCount() {
        try {
            return _apiCallProductsDetailResponse.size();
        }
        catch (Exception exception)
        {
            Log.d("Error",exception.getLocalizedMessage());
        }
        return 0;
    }

    class ViewHolderHeader extends RecyclerView.ViewHolder {

        public TextView_B tvTitle;
        public TextView_N tvDesc;
        public TextView_B tvPrice;
        public MaterialRatingBar rbProductRating;
        public CardView mainView;
        ImageView imImage;
        View view;

        public ViewHolderHeader(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            tvTitle = (TextView_B) itemView.findViewById(R.id.tvTitle);
            tvDesc = (TextView_N) itemView.findViewById(R.id.tvDesc);
            tvPrice = (TextView_B) itemView.findViewById(R.id.tvPrice);
            imImage= (ImageView) itemView.findViewById(R.id.imImage);
            mainView= (CardView) itemView.findViewById(R.id.mainView);
            rbProductRating =(MaterialRatingBar) itemView.findViewById(R.id.rbProductRating);
        }
    }

}
