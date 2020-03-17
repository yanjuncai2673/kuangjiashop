package com.example.mineview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


/**
 * 自定义一个标题组件  继承布局
 * 实现：返回按钮
 * 标题显示
 * 分享按钮
 */
public class MyTitleView extends ConstraintLayout implements View.OnClickListener {

    private Boolean share_show;
    String title;
    Context context;
    AppCompatActivity activity;
    private TextView title1;
    private TextView back;
    private TextView share;
    private ITitleClick clickFun;

    public MyTitleView(Context context) {
        super(context);
    }

    public MyTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context, attrs);
    }

    public MyTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    //初始化属性
    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.mytitleview);
        share_show = typedArray.getBoolean(R.styleable.mytitleview_title_visible_share, false);
        title = typedArray.getString(R.styleable.mytitleview_tv_title);

        //添加布局内容 找控件
        View view = LayoutInflater.from(context).inflate(R.layout.layout_title, null);
        addView(view, new ConstraintLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        back = view.findViewById(R.id.tv_back);
        title1 = view.findViewById(R.id.tv_title);
        share = view.findViewById(R.id.tv_share);

        //设置返回按钮的监听
        back.setOnClickListener(this);
        if (TextUtils.isEmpty(title)) {
            title1.setText(title);
        }

        //分享按钮的属性和事件
        share.setVisibility(share_show ? View.VISIBLE : View.GONE);
        if (share_show) {
            share.setOnClickListener(this);
        }
    }

    public void setActivity(AppCompatActivity activity){
        this.activity = activity;
    }

    /**
     * 设置接口回调
     * @param click
     */
    public void setClick(ITitleClick click){
        this.clickFun = click;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                if (activity != null&&!activity.isFinishing()) {//可以吧 Activity传进来 也可以接口回调
                    activity.finish();
                    activity = null;
                }
                break;
            case R.id.tv_share:
                //将分享的内容传进来 通过接口回调
                Toast.makeText(context, "点击了分享", Toast.LENGTH_SHORT).show();
                //通过接口回调将点击事件传出去
                if (clickFun != null) {
                    clickFun.titleClick(v);
                }
                break;
        }
    }


    //点击事件触发的接口回调
    interface ITitleClick{
        void titleClick(View view);
    }
}
