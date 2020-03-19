package com.example.mytouchevent.utils;

import android.util.Log;
import android.view.MotionEvent;

//工具类
public class MineUtils {
    //打印log日志
    public static void showLog(String tag,String mes){
        Log.i(tag,mes);
    }

    //显示触发的事件
    public static void showEvent(String tag, MotionEvent evt,String metholds){
        Log.i(tag,evt.getAction()+"-----"+metholds);//打印触发事件及方法名
    }
}
