package com.example.mineview;

import android.content.Context;
import android.util.DisplayMetrics;

public class Utils {
    //根据不同手机分辨率从dp转成px;
    public static int dptopx(Context context,float dpvalues){
        float density = context.getResources().getDisplayMetrics().density;
        return (int)(dpvalues*density+0.5f);
    }

    //将sp值转换成px值，保证文本大小
    public static int sptopx(Context context,float spvalues){
        float density = context.getResources().getDisplayMetrics().density;
        return (int)(spvalues*density+0.5f);
    }

    //将px值转换成dp值，保证文本大小
       public static int pxtodp(Context context,float pxvalues){
           float density = context.getResources().getDisplayMetrics().density;
            return (int)(pxvalues/density+0.5f);
        }

    //将px值转换成sp值，保证文本大小
    public static int pxtosp(Context context,float pxvalues){
        float density = context.getResources().getDisplayMetrics().density;
        return (int)(pxvalues/density+0.5f);
    }
}
