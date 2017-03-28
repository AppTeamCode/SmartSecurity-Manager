package app.edu.cdu.com.smartsecurity_manager.ui;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.List;
import app.edu.cdu.com.smartsecurity_manager.service.SmartService;
import app.edu.cdu.com.smartsecurity_manager.utils.StaticClass;

/**
 * 项目名：  SmartSecurity-Manager
 * 包名：    app.edu.cdu.com.smartsecurity_manager.ui
 * 文件名：  BaseActivity
 * 创建者：  zhl
 * 创建时间： 2017/3/5 10:37
 * 描述：activity基类
 * 1.统一的属性
 * 2.统一的接口
 * 3.统一的方法
 */

public class BaseActivity extends AppCompatActivity {
    /**
     * 整数1代表设备消息
     * 整数2代表报警消息
     * 整数3代表联系人消息
     * 整数4代表聊天消息
     */
    //区分不同的消息类型
    protected int messageType = 0;
    //区分不同的activity
    protected int activityId;
    //service实例变量
    protected SmartService mService;
    //获取service实例
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ((SmartService.SmartBinder) service).getSmartService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    /**
     * 1.判断service是否在运行采取不同的启动方式
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        Intent intent = new Intent(this,SmartService.class);
        initData(intent);
    }

    //初始化方法
    private void initData(Intent intent) {
        if (runService(this)){
            bindService(intent,serviceConnection,BIND_AUTO_CREATE);
        }else{
            startService(intent);
            bindService(intent,serviceConnection,BIND_AUTO_CREATE);
        }
    }

    // 特别说明，这里的msg要替换成一个对象（自定义可能使用的对象）,activityId用来判断是哪个activivty传的值
    public void sendMessageToService(String msg, String activityId) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("msg", msg);
        final Intent intent = new Intent(this, SmartService.class);
        intent.putExtras(bundle);
        intent.putExtra("activityId", activityId);
        startService(intent);
    }

    // 这里的msg也是要替换成自己定义的对象。(字符串，整型以及布尔值)
    public String getMessageFromService() {
        return null;
    }

    //菜单栏操作
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                    break;
                default:
                    break;
        }
        return super.onOptionsItemSelected(item);
    }

    //判断MyService是否在运行
    public  boolean isServiceRunning(Context mContext,String className) {

        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager)
                mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList
                = activityManager.getRunningServices(30);

        if (!(serviceList.size()>0)) {
            return false;
        }

        for (int i=0; i<serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }

    //判断是否开启service
    public Boolean runService(Context mContext){
        if(isServiceRunning(mContext,StaticClass.SERVICE_NAME)){
            return true;
        }else{
            return false;
        }
    }
}
