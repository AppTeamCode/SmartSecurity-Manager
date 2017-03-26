package app.edu.cdu.com.smartsecurity_manager.service;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.util.List;

import app.edu.cdu.com.smartsecurity_manager.R;

/**
 * 项目名：  SmartSecurity-Manager
 * 包名：    app.edu.cdu.com.smartsecurity_manager.service
 * 文件名：  SmartService
 * 创建者：  zhl
 * 创建时间： 2017/3/6 11:24
 * 描述：服务类
 */

public class SmartService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 内部类
     * 返回当前的service实例
     */
    public class SmartBinder extends Binder{
        public SmartService getSmartService(){
            return SmartService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    //判断APP是否运行于前台
    @SuppressWarnings("deprecation")
    public boolean isRunningForeground(Context context){
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        String currentPackageName = cn.getPackageName();
        if(currentPackageName != null && currentPackageName.equals(getPackageName())){
            return true;
        }
        return false;
    }

    //获得请求acivity的id
    public String getActivityType(Intent intent){
        return intent.getStringExtra("activityId");
    }

    //发送通知信息
    public void showMsgNotification(String msg, String tickerText, Class activity) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nm = (NotificationManager) getSystemService(ns);
        long when = System.currentTimeMillis();
        NotificationCompat.Builder notification = new NotificationCompat.Builder(
                this);
        notification.setSmallIcon(R.drawable.notification);
        notification.setContentTitle(tickerText);
        notification.setWhen(when);
        notification.setContentText(msg);
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this,
                activity), 0);
        notification.setContentIntent(pi);
        nm.notify(1, notification.build());
    }

    // 消息发送到activity
    public void showMSGToActivity(String msg, String tickerText, Class activity) {
        Toast.makeText(getApplicationContext(),
                tickerText + ":" + msg + "发送到" + activity, Toast.LENGTH_SHORT)
                .show();
    }

    // 发送消息时调用该方法
    public void sendMSG(String msg, String tickerText, Class activity) {
        if (isBackground(this)) {
            showMsgNotification(msg, tickerText, activity);
        } else {
            showMSGToActivity(msg, tickerText, activity);
        }
    }

    // 判断当前应用程序处于前台还是后台的两种方法
    public static boolean isBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {

                    return true;
                } else {
                    return false;
                }
            }
        }
        return  false;
    }

}
