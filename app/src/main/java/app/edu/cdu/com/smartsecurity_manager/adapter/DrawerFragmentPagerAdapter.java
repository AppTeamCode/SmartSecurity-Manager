package app.edu.cdu.com.smartsecurity_manager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;
import app.edu.cdu.com.smartsecurity_manager.ui.contact.ContactFragment;
import app.edu.cdu.com.smartsecurity_manager.ui.device.DeviceFragment;
import app.edu.cdu.com.smartsecurity_manager.ui.message.MessageFragment;

/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class DrawerFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList = new ArrayList<>();

    public DrawerFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        mFragmentList.add(0, new DeviceFragment());
        mFragmentList.add(1, new ContactFragment());
        mFragmentList.add(2, new MessageFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
