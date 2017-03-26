package app.edu.cdu.com.smartsecurity_manager.ui.device;

import android.util.Log;
import android.widget.ListView;
import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.adapter.DeviceItemsAdapter;
import app.edu.cdu.com.smartsecurity_manager.ui.BaseFragment;
import app.edu.cdu.com.smartsecurity_manager.utils.L;

/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class DeviceFragment extends BaseFragment {

    private ListView mDeviceItemsListView;

    @Override
    protected void findViews() {
        mDeviceItemsListView = (ListView) mView.findViewById(R.id.deviceItems_listView);
    }

    @Override
    protected void setAdapter() {
        DeviceItemsAdapter deviceItemsAdapter = new DeviceItemsAdapter(getActivity());
        mDeviceItemsListView.setAdapter(deviceItemsAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_device;
    }
}
