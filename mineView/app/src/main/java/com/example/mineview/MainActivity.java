package com.example.mineview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyImageView mImg;
    private MyTitleView mMyTitle;
    private MyCircleView circleView;

    int angle = 0;//扇形区域

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mImg = (MyImageView) findViewById(R.id.img);
        mImg.setOnClickListener(this);
        mMyTitle = (MyTitleView) findViewById(R.id.myTitle);
        mMyTitle.setActivity(this);
        circleView = findViewById(R.id.circle);

        handler.postDelayed(runnable,30);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(runnable,30);
            angle ++;
            angle = angle > 360 ? 1 : angle;
            circleView.setAngle(angle);
            //动态触发circleView组件绘制
            circleView.invalidate();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img:
                intentIv();
                break;
        }
    }


    private void intentIv() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
