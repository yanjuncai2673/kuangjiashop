package com.example.shops.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.shops.app.MyApp;

//sharedPrefecess封装的工具类
public class SpUtils {

    private  SharedPreferences sp;
    private static SpUtils instance;

    public SpUtils() {
        sp = MyApp.myApp.getSharedPreferences("shops", Context.MODE_PRIVATE);
    }
    //单例模式
    public static SpUtils getInstance(){
        if ( instance== null) {
            synchronized (SpUtils.class){
                if (instance == null) {
                    instance = new SpUtils();
                }
            }
        }
        return instance;
    }
    /**
     * 设置数据
     * @param key
     * @param value
     */
    public void setValue(String key,Object value){
        SharedPreferences.Editor editor = sp.edit();
        if(value instanceof String){
            editor.putString(key, (String) value);
        }else if(value instanceof Integer){
            editor.putInt(key, (Integer) value);
        }else if(value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        }else if(value instanceof Float){
            editor.putFloat(key, (Float) value);
        }else if(value instanceof Long){
            editor.putLong(key, (Long) value);
        }
        editor.commit();
    }


    public String getString(String key){
        return sp.getString(key,"");
    }

    public int getInt(String key){
        return sp.getInt(key,0);
    }

    public Boolean getBoolean(String key){
        return sp.getBoolean(key,false);
    }

    public float getFloat(String key){
        return sp.getFloat(key,0);
    }

    public Long getLong(String key){
        return sp.getLong(key,0);
    }
}
