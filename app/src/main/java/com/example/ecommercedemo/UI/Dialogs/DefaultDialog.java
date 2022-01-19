package com.example.ecommercedemo.UI.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.ecommercedemo.R;

public class DefaultDialog extends Dialog implements View.OnClickListener {

    Context context;
    TextView tvText;
    String msg;

    public DefaultDialog(Context context, String _msg, boolean isSuccess) {
        super(context);
        this.context = context;
        msg = _msg;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCanceledOnTouchOutside(true);
        setContentView(R.layout.default_dialog);

        Window window = getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.CENTER_HORIZONTAL;
        window.setAttributes(wlp);


        Display display = getWindow().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        width = (int) (width * 0.9);
        getWindow()
                .setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT);


        tvText =  findViewById( R.id.tvText );
        tvText.setText(msg);

        if(isSuccess)
        {
            tvText.setTextColor(context.getResources().getColor(R.color.light_green));
        }
        else
        {
            tvText.setTextColor(context.getResources().getColor(R.color.colorRed));
        }
        show();
    }

    @Override
    public void onClick(View view) {
    }
}
