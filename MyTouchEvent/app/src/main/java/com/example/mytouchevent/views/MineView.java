package com.example.mytouchevent.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mytouchevent.utils.MineUtils;

public class MineView extends View {

    private static  String TAG;

    public MineView(Context context) {
        super(context);
        initTag();

    }

    public MineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initTag();
    }

    public MineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTag();
    }

    private void initTag() {
        TAG = this.getClass().getName();
    }

    //重写View内的两个方法
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        MineUtils.showEvent(TAG,event,"dispatchTouchEvent");
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MineUtils.showEvent(TAG,event,"onTouchEvent");
        return true;
    }
}
