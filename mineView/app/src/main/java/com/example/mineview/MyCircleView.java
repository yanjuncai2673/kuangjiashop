package com.example.mineview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCircleView extends View {

    private int angle = 60;//设置当前圆的角度默认
    private int fontSize;
    private Paint paint;

    private int width,height;//当前组件宽高
    int circle_x,circle_y =0;//圆形点位置
    String loading="0%";//当前进度
    int radius;//半径
    private RectF rectF;
    private String circle_color;

    public MyCircleView(Context context) {
        super(context);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);

    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.mycircleview);
        if (typedArray != null) {
            circle_color = typedArray.getString(R.styleable.mycircleview_circle_color);
            float size = typedArray.getFloat(R.styleable.mycircleview_circle_loading_size, 14f);
            fontSize = Utils.sptopx(context, size);
            Log.i("fontSize",String.valueOf(fontSize));
            paint = new Paint();
            paint.setColor(Color.parseColor(circle_color));
            //是否自定义属性，进行回收处理
            typedArray.recycle();
        }
    }

    //设置当前绘制圆的角度
    public void setAngle(int angle){
        this.angle =angle;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         width = getWidth();//获取组件的宽高
         height = getHeight();

         circle_x = width/2;
         circle_y = width/2;
         radius=width/2;
         paint.setStyle(Paint.Style.STROKE);//画笔样式 边框线
        paint.setColor(Color.parseColor("#000000"));
        canvas.drawCircle(circle_x,circle_y,radius,paint);

        //设置扇形的范围
        rectF = new RectF();
        rectF.set(0,0,width,height);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(circle_color));

        //画扇形       扇形          开始角度  扇形区域    使用中心  画笔
        canvas.drawArc(rectF,-90,angle,true,paint);

        //当前%分号进度计算
        loading = (int)(((float)angle)/360f*100)+"%";
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.parseColor("#00ff00"));
        paint.setTextSize(fontSize);
        int txtX,txtY = 0;
        Rect rect = getTextWH(loading);
        txtX = width/2-rect.width()/2;
        txtY = height/2+rect.height()/2;
        //绘制文本
        canvas.drawText(loading,txtX,txtY,paint);
    }

    //动态获取文本宽高
    private Rect getTextWH(String loading) {
        Rect rect = new Rect();
        paint.getTextBounds(loading,0,loading.length(),rect);
        return rect;
    }
}
