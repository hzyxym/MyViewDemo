package com.fzs.hzy.mylibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by hzy on 2017/11/21.
 */

@SuppressLint("AppCompatCustomView")
public class AutoImage extends ImageView {
    private int widthScale = 1;
    private int heigthScale = 1;

    public AutoImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public AutoImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.AutoImage);
        widthScale = mTypedArray.getInt(R.styleable.AutoImage_widthScale,1);
        if (widthScale != 1){
            heigthScale = mTypedArray.getInt(R.styleable.AutoImage_heigthScale,1);
        }
    }

    public AutoImage(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
                getDefaultSize(0, heightMeasureSpec));
		int childWidthSize = getMeasuredWidth();
        int childHeightSize = childWidthSize * heigthScale/widthScale;
        // 高度和宽度一样
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(
                childHeightSize, MeasureSpec.EXACTLY);
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
