package com.example.mineview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyImageView mImg;
    private MyTitleView mMyTitle;

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
    }

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
