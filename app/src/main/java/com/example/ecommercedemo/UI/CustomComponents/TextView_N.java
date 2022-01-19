package com.example.ecommercedemo.UI.CustomComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.ecommercedemo.R;
import com.example.ecommercedemo.Helpers.Enitits.Utils;


public class TextView_N extends AppCompatTextView {

    Boolean isSpannable= false;

    public TextView_N(Context context) {
        super(context);

    }

    public TextView_N(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta= context.obtainStyledAttributes(attrs, R.styleable.TextView);
        init(context,ta);
    }

    public TextView_N(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta= context.obtainStyledAttributes(attrs, R.styleable.TextView);
        init(context,ta);
    }

    private void init(Context context,TypedArray taButton) {


        isSpannable= taButton.getBoolean(R.styleable.TextView_is_spannable, false);



    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        if(text==null)
        {
            text ="";
        }

        super.setText(Utils.firstLetterCapital(text.toString()), type);
        //
        //  super.setText(Utils.firstLetterCapital(text.toString()), type);

    }



}