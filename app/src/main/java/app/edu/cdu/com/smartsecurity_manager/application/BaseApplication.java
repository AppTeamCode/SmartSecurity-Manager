package app.edu.cdu.com.smartsecurity_manager.application;

import android.app.Application;

import com.antfortune.freeline.FreelineApplication;
import com.antfortune.freeline.FreelineCore;

/**
 * Created by zhl on 2017/3/5.
 * application基类取代系统默认application
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
