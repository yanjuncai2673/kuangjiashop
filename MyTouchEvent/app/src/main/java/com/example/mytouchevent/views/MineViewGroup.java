package com.example.mytouchevent.views;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytouchevent.utils.MineUtils;

public class MineViewGroup extends ViewGroup{

    private static String TAG;

    public MineViewGroup(Context context) {
        super(context);
        initTag();
    }

    public MineViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTag();
    }

    public MineViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTag();
    }

    private void initTag() {
        TAG = this.getClass().getName();
    }


    //ViewGroup重写测量和布局方法

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec,heightMeasureSpec);//测量子类宽高
        //设置测量的尺寸
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec),getDefaultSize(getSuggestedMinimumHeight(),heightMeasureSpec));
    }


    /**
     * 子View中宽度最大值
     * @return
     */
    private int getMaxChildWidth(){
        int childCount = getChildCount();
        int maxWidth = 0;
        for(int i=0; i<childCount; i++){
            View childView = getChildAt(i);
            if(childView.getMeasuredWidth() > maxWidth){
                maxWidth = childView.getMeasuredWidth();
            }
        }
        return maxWidth;
    }

    /**
     * 所有子View的高度相加
     * @return
     */
    private int getTotleHeight(){
        int childCount = getChildCount();
        int height = 0;
        for(int i=0; i<childCount; i++){
            View childView = getChildAt(i);
            height += childView.getMeasuredHeight();
        }
        return height;
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        final int count = getChildCount();
        int childMeasureWidth = 0;
        int childMeasureHeight = 0;
        int layoutWidth = 0;    // 容器已经占据的宽度
        int layoutHeight = 0;   // 容器已经占据的宽度
        int maxChildHeight = 0; //一行中子控件最高的高度，用于决定下一行高度应该在目前基础上累加多少
        for(int i = 0; i<count; i++){
            View child = getChildAt(i);
            //注意此处不能使用getWidth和getHeight，这两个方法必须在onLayout执行完，才能正确获取宽高
            childMeasureWidth = child.getMeasuredWidth();
            childMeasureHeight = child.getMeasuredHeight();
            if(layoutWidth<getWidth()){
                //如果一行没有排满，继续往右排列
                l = layoutWidth;
                r = l+childMeasureWidth;
                t = layoutHeight;
                b = t+childMeasureHeight;
            } else{
                //排满后换行
                layoutWidth = 0;
                layoutHeight += maxChildHeight;
                maxChildHeight = 0;

                l = layoutWidth;
                r = l+childMeasureWidth;
                t = layoutHeight;
                b = t+childMeasureHeight;
            }

            layoutWidth += childMeasureWidth;  //宽度累加
            if(childMeasureHeight>maxChildHeight){
                maxChildHeight = childMeasureHeight;
            }

            //确定子控件的位置，四个参数分别代表（左上右下）点的坐标值
            child.layout(l, t, r, b);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        MineUtils.showEvent(TAG,ev,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        MineUtils.showEvent(TAG,ev,"onInterceptTouchEvent");
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MineUtils.showEvent(TAG,event,"onTouchEvent");
        return false;
    }
}
