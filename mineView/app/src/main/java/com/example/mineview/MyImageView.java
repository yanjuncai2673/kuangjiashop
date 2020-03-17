package com.example.mineview;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

//创建一个自定义的类继承ImageView
@SuppressLint("AppCompatCustomView")
public class MyImageView extends ImageView {


    private String tv_color;
    private String iv_color;
    private int tv_size;
    private Paint paint;
    private Paint ivpaint;
    private Path ivpath;
    private Path tvpath;

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }



    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    //初始化属性
    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.myimageview);
        tv_color = typedArray.getString(R.styleable.myimageview_tv_txt_color);
        iv_color = typedArray.getString(R.styleable.myimageview_iv_bg_color);
        tv_size = typedArray.getInteger(R.styleable.myimageview_tv_txt_size,10);

        paint = new Paint();
        paint.setTextSize(tv_size);
        paint.setColor(Color.parseColor(tv_color));

        ivpaint = new Paint();
        ivpaint.setColor(Color.parseColor(iv_color));
        ivpaint.setStyle(Paint.Style.FILL);//设置绘制的样式  充满模式

        tvpath = new Path();
        ivpath = new Path();
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //布局
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    //绘制

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        countWH(getMeasuredWidth(),getMeasuredHeight());
        canvas.drawPath(ivpath,ivpaint);//绘制图片的路径  画笔
        canvas.drawTextOnPath("hot",tvpath,80,-20,paint);//绘制文字
    }

    //获取位置 宽高
    private void countWH(int measuredWidth, int measuredHeight) {
        float x1,x2,y1,y2;
        int width = measuredWidth;
        int top = 0;
        int left_length = 100;
        int bar_length = 100;

         x1 = width - left_length - bar_length;
         x2 = width - bar_length;
         y1 = top + bar_length;
         y2 = top + bar_length+left_length;

         tvpath.reset();
         tvpath.moveTo(x1,top);//A点坐标
        tvpath.lineTo(width,y2);//D点坐标
        tvpath.close();

        ivpath.reset();
        ivpath.moveTo(x1,top);//A点坐标
        ivpath.lineTo(x2,top);//B点坐标
        ivpath.lineTo(width,y1);//c点坐标
        ivpath.lineTo(width,y2);//D点坐标
        ivpath.close();
    }
}
