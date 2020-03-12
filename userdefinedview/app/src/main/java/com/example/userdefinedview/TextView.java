package com.example.userdefinedview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

//自定义的TextView 继承view
public class TextView extends View {

    private String text;
    private String color;
    private int size;
    private Paint paint;

    public TextView(Context context) {
        super(context);
    }

    public TextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initattr(context,attrs);//初始化属性
    }



    public TextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initattr(Context context, AttributeSet attrs) {
        //将属性传进
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.myview);
        text = typedArray.getString(R.styleable.myview_text);//获取各个属性
        color = typedArray.getString(R.styleable.myview_textColor);
        size = typedArray.getInteger(R.styleable.myview_textSize, 10);

        //创建画笔
        paint = new Paint();
        paint.setColor(Color.parseColor(color));//设置画笔
        paint.setTextSize(size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);//Canvas 画板
       canvas.drawText(text,150,200,paint);
    }
}
