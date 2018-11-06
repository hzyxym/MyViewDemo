package com.fzs.hzy.myviewdemo.view;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class RotateTextView extends android.support.v7.widget.AppCompatTextView {


    public RotateTextView(Context context) {
        super(context);
    }

    public RotateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //倾斜度45,上下左右居中
        canvas.rotate(45, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        super.onDraw(canvas);
    }

}