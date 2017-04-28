package app.edu.cdu.com.smartsecurity_manager.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import app.edu.cdu.com.smartsecurity_manager.R;
<<<<<<< Updated upstream
import app.edu.cdu.com.smartsecurity_manager.fragment.ChatFragment;
=======
import app.edu.cdu.com.smartsecurity_manager.fragment.ChatSettingsFragment;
>>>>>>> Stashed changes
import app.edu.cdu.com.smartsecurity_manager.fragment.DeviceFragment;
import app.edu.cdu.com.smartsecurity_manager.fragment.DeviceMessage;
import app.edu.cdu.com.smartsecurity_manager.fragment.DevicesSettingsFragment;

/**
 * SmartSecurity-Manager
 * app.edu.cdu.com.smartsecurity_manager.ui
 * Created by Pantiy on 2017/4/25.
 * Copyright © 2017 All rights Reserved by Pantiy
 */

public class SingleFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = createFragment();
        if (fragment != null) {
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    private Fragment createFragment() {
<<<<<<< Updated upstream
        return new ChatFragment();
=======
        return new DeviceMessage();
>>>>>>> Stashed changes
    }
}
