package com.example.mineview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

     MyTitleView mAcDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    private void initView() {
        mAcDetail = (MyTitleView) findViewById(R.id.detail_ac);
        mAcDetail.setActivity(this);
        mAcDetail.setClick(new MyTitleView.ITitleClick() {
            @Override
            public void titleClick(View view) {
                switch (view.getId()){
                    case R.id.tv_share:
                        break;
                    case R.id.tv_back:
                        break;
                }
            }
        });
    }




}
