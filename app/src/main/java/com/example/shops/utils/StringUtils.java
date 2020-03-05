package com.example.shops.utils;

//字符串工具类
public class StringUtils {
    //将arraylist切割成以逗号分隔的字符串
    public static String splitArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
