package com.example.mytouchevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.mytouchevent.utils.MineUtils;
import com.example.mytouchevent.views.MineView;
import com.example.mytouchevent.views.MineViewGroup;

public class MainActivity extends AppCompatActivity {

    private static String TAG;
    private MineViewGroup mvg;
    private MineView mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG = this.getClass().getName();
        initView();

    }

    private void initView() {
        mvg = findViewById(R.id.mvg);
        mv = findViewById(R.id.mv);
        mv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("view click","click");
            }
        });
        mv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        MineUtils.showEvent(TAG,ev,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MineUtils.showEvent(TAG,event,"onTouchEvent");
        return true;
    }
}
