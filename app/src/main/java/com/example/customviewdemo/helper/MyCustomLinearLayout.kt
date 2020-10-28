package com.example.customviewdemo.helper

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.customviewdemo.R

class MyCustomLinearLayout(context: Context, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {
    var textView: TextView
    var imageView: ImageView

    init {
        //need to inflate xml as always
        inflate(context, R.layout.my_custom_layout, this)

        //initilizing the views
        imageView = findViewById(R.id.image_view)
        textView = findViewById(R.id.text_view)
        val myCustomView = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView)
        imageView.setImageDrawable(myCustomView.getDrawable(R.styleable.MyCustomView_image))
        textView.text = myCustomView.getString(R.styleable.MyCustomView_text)
        myCustomView.recycle()
    }
}