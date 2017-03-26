package app.edu.cdu.com.smartsecurity_manager.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 项目名：  SmartSecurity-Manager
 * 包名：    app.edu.cdu.com.smartsecurity_manager.utils
 * 文件名：  SharedUtils
 * 创建者：  zhl
 * 创建时间： 2017/3/5 11:05
 * 描述：SharedPreference的封装类
 * 1.对APP中的一些字符串、整型、布尔值进行处理
 */

public class SharedUtils {
    public static final String NAME = "config";

    //存储字符串
    public static void putString(Context mContext,String key,String value){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    //获取字符串
    public static String getString(Context mContext,String key,String defaultValue){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
         return sp.getString(key,defaultValue);
    }

    //存储整型
    public static void putInt(Context mContext,String key,int value){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    //获取整型
    public static int getInt(Context mContext,String key,int defaultValue){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getInt(key,defaultValue);
    }

    //存储布尔值
    public static void putBoolean(Context mContext,String key,Boolean value){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    //获取布尔值
    public static Boolean getBoolean(Context mContext,String key,Boolean defaultValue){
        SharedPreferences sp = mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(key,defaultValue);
    }
}
