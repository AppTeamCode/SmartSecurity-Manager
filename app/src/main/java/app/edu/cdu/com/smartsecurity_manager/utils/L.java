package app.edu.cdu.com.smartsecurity_manager.utils;

/**
 * 项目名：  SmartSecurity-Manager
 * 包名：    app.edu.cdu.com.smartsecurity_manager.utils
 * 文件名：  L
 * 创建者：  zhl
 * 创建时间： 2017/3/6 10:55
 * 描述：    Log封装类
 * 五个等级  DIWE
 */

public class L {
    //开关
    public static final boolean DEBUG = true;
    //TAG
    public static final String TAG = "SmartSecurity-Manager";

    public static void i(String text){
        if(DEBUG){
        android.util.Log.i(TAG,text);
        }
    }

    public static void d(String text){
        if(DEBUG){
            android.util.Log.d(TAG,text);
        }
    }

    public static void w(String text){
        if(DEBUG){
            android.util.Log.w(TAG,text);
        }
    }

    public static void e(String text){
        if(DEBUG){
            android.util.Log.e(TAG,text);
        }
    }
}
