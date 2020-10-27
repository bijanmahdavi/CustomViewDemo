package com.example.customviewdemo.helper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.customviewdemo.R;

public class MyCustomView extends LinearLayout {

    TextView textView;
    ImageView imageView;

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //need to inflate xml as always
        inflate(context, R.layout.my_custom_layout, this);

        //initilizing the views
        imageView = findViewById(R.id.image_view);
        textView = findViewById(R.id.text_view);

        TypedArray attribute = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        imageView.setImageDrawable(attribute.getDrawable(R.styleable.MyCustomView_image));
        textView.setText(attribute.getString(R.styleable.MyCustomView_text));
        attribute.recycle();


    }
}
