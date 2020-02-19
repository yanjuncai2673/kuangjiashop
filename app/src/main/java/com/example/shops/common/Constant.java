package com.example.shops.common;

import com.example.shops.app.MyApp;

import java.io.File;
//这是个常量类
public class Constant {
    public static final String BASE_SHOP_URL = "https://cdwan.cn/api/";  //商城的基础地址
    //网络缓存的地址
    public static final String PATH_DATA = MyApp.myApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/shop";


    public static final String PRICE_MODEL = "$元起";
}
