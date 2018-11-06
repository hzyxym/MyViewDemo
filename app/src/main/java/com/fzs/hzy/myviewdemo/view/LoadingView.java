package com.fzs.hzy.myviewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class LoadingView extends android.support.v7.widget.AppCompatImageView {
    private AnimationDrawable animationDrawable;

    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnim();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        relaseAnim();
    }

    private void initLoading(){
        animationDrawable = (AnimationDrawable) getBackground();
    }

    @Override
    public void setVisibility(int visibility) {
        if (getVisibility() != visibility) {
            super.setVisibility(visibility);
            if (visibility == GONE || visibility == INVISIBLE) {
                stopAnim();
            } else {
                startAnim();
            }
        }
    }

    private void startAnim() {
        if (animationDrawable == null) {
            initLoading();
        }
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    private void stopAnim() {
        if (animationDrawable == null) {
            initLoading();
        }
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    private void relaseAnim(){
        if (animationDrawable != null) {
            if(animationDrawable.isRunning()){
                animationDrawable.stop();
            }
            animationDrawable = null;
        }
    }
}
