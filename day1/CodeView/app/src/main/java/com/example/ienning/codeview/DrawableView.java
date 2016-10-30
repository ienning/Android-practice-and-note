package com.example.ienning.codeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ienning on 16-10-30.
 */

public class DrawableView extends View {
    /*
    private static final int DEFAULT_FAST_DURATION = 300;
    private static final int DEFAULT_DURATION = 1200;
    private static final int DEFAULT_TRANSPARENT_DURATION = 300;

    private static final int DEFAULT_ALPHA = 33;
    public static final int DEFAULT_COLOR = Color.BLACK;
    private boolean mIspress;
    private boolean mIsCancelAnimation;
    private ObjectAnimator mAnimation;
    private boolean mIsAnimation;
    private int mMinPadding;
    private int mViewRadius;
    private int mColor = Color.BLACK;
    private int mCircleColor;
    private int mFocusColor;
    private android.view.animation.Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    */

    /* 创建画笔*/
    public float currentX = 40;
    public float currentY = 50;
    Paint p = new Paint();

    public DrawableView(Context context) {
        super(context);
//        ViewConfiguration configuration = ViewConfiguration.get(context);
//        mMinPadding = configuration.getScaledEdgeSlop();
    }
    public DrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.RED);
//        canvas.drawColor(mFocusColor);
        /*
        绘制一个小圆，其中的参数是，绘制小圆的定位，在屏幕上，是X和Y坐标值，然后
        15是小圆的半径长度，p是创建的画笔对象，将画笔对象传进该方法，某种意义上来说就是
        p是一个通用的属性集合，在调用某个形状方法时，将这个属性集合和显示在屏幕中的位置以及大小
        当做参数进行绘画，从而显现在屏幕上
         */
        canvas.drawCircle(currentX, currentY, 15, p);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();
        // 通知当前组件重绘自己
        invalidate();
        //返回true表明该处理事件已经处理改事件中
        return true;
    }
    /*
    public void setColor() {

    }
    public void setAlpha(int alpha) {
        mFocusColor = ColorUtils.getColorAtlpha(mColor, alpha);
        mCircleColor = ColorUtils.getColorAtlpha(mColor, alpha);
        resetPaint();
        invalidate();
    }
    private void resetPaint() {
        p.setColor(mCircleColor);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /*
        通过获取event事件中，触屏的位置来定位小球的位置
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mIspress = true;
                if (!mIsAnimation) {
                    startShadowAnimation(event);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                cancelShadowAnimation();
                break;
        }
    }
    private void startShadowAnimation(MotionEvent event) {
        //获取该组件的长度和宽度，得出波纹的半径，这个可以到时候自己自定义
        mViewRadius = (int)Math.sqrt((getWidth()) * (getWidth()) / 4 + (getHeight()) * (getHeight()) / 4);
        currentX = event.getX();
        currentY = event.getY();
        mAnimation = ObjectAnimator.ofFloat(this, "radius", mMinPadding, mViewRadius);
        int mDuration = DEFAULT_DURATION;
        mAnimation.setDuration(mDuration);
        mAnimation.setInterpolator(mInterpolator);
        mAnimation.addListener(animatorListener);
        mAnimation.start();
        Log.i("Ienning", "startShadowAnimation: test result is " + mViewRadius + " and min padding is " + mMinPadding);
    }
    private void cancelShadowAnimation() {
        if (mIsCancelAnimation) {
            return;
        }
        mIspress = false;

    }
    private Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            mIsAnimation = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            mIsAnimation = false;
            invalidate();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };
    private Animator.AnimatorListener mCancelAnimatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            mIsCancelAnimation = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            mIsCancelAnimation = false;
            invalidate();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };
    static class ColorUtils {
        public static int getColorAtlpha(int color, int alpha) {
            if (alpha < 0 || alpha > 255) {
                throw new IllegalArgumentException("The alpha should be 0 - 255.");
            }
            return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
        }
    } */
}
