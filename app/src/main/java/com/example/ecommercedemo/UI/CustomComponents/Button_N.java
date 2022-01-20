package com.example.ecommercedemo.UI.CustomComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

import com.example.ecommercedemo.R;

public class Button_N extends AppCompatButton {




    public Button_N(Context context) {
        super(context);
        // init();
    }

    public Button_N(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray taButton = context.obtainStyledAttributes(attrs, R.styleable.Button);
        init(taButton,context);
    }

    public Button_N(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray taButton = context.obtainStyledAttributes(attrs, R.styleable.Button);
        init(taButton,context);




    }

    private void init(TypedArray taButton,Context context) {

        setAllCaps(false);
        setTextSize(20);
        if (taButton != null) {

            Log.i("ButtonCheck", "init: ");
            int backColor  = taButton.getInteger(R.styleable.Button_background_color, 0);
            setBackground(getResources().getDrawable(R.drawable.button_magenta));
            setTextColor(Color.WHITE);
        }
        Typeface tf = ResourcesCompat.getFont(context, R.font.helvetica_neue);

        setTypeface(tf);
    }
}