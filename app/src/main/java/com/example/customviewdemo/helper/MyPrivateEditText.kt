package com.example.customviewdemo.helper

import android.content.Context
import android.renderscript.ScriptGroup
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.util.Log
import android.view.animation.Transformation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.customviewdemo.R

class MyPrivateEditText(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    var customText: TextView
    var imageView: ImageView
    var private = false

    init {
        inflate(context, R.layout.edit_text_private, this)

        customText = findViewById(R.id.edit_text_private)
        imageView = findViewById(R.id.image_view_private)
        val myPrivateEditText = context.obtainStyledAttributes(attrs, R.styleable.MyPrivateEditText)
        imageView.setImageDrawable(myPrivateEditText.getDrawable(R.styleable.MyPrivateEditText_image2))
        customText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        customText.hint = myPrivateEditText.getString(R.styleable.MyPrivateEditText_text2)
        imageView.setOnClickListener {
            val temp = customText.transformationMethod
            if(!private) {
                customText.transformationMethod = PasswordTransformationMethod.getInstance()
                imageView.setImageDrawable(myPrivateEditText.getDrawable(R.styleable.MyPrivateEditText_image3))
                //customText.inputType = InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD
                private = true
            } else {
                customText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                imageView.setImageDrawable(myPrivateEditText.getDrawable(R.styleable.MyPrivateEditText_image2))
                //customText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                private = false
            }
        }
        //was giving me an error with this
        //myPrivateEditText.recycle()
    }
}