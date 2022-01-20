package com.example.ecommercedemo.UI.CustomComponents;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

import com.example.ecommercedemo.R;


public class TextView_B extends AppCompatTextView {
    public TextView_B(Context context) {
        super(context);
        init(context);
    }

    public TextView_B(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextView_B(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Typeface tf = ResourcesCompat.getFont(context, R.font.helvetica_neue_bold);
        setTypeface(tf);
    }
}