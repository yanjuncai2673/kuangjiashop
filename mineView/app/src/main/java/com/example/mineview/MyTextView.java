package com.example.mineview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
//自定义一个类继承View  文本类
public class MyTextView extends View {

    private String text;
    private String color;
    private int size;
    private Paint paint;

    //重写四个构造方法
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }



    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //初始化属性
    private void initView(Context context, AttributeSet attrs) {
        //上下文调用方法得到样式集合
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.mytextview);//文本属性风格
        text = typedArray.getString(R.styleable.mytextview_text);
        color = typedArray.getString(R.styleable.mytextview_textColor);
        //int 类型的size  给个默认值
        size = typedArray.getInteger(R.styleable.mytextview_textSize,10);

        ////创建画笔
        paint = new Paint();
        paint.setColor(Color.parseColor(color));//画笔设置颜色
        paint.setTextSize(size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text,50,50,paint);//调用ondraw方法   画布绘制文本
    }
}
