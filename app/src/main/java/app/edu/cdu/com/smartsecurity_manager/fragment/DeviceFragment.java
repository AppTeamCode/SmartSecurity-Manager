package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.view.View;
import android.widget.ListView;
import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.adapter.DeviceItemsAdapter;
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;

/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class DeviceFragment extends BaseFragment {

    private ListView mDeviceItemsListView;

    @Override
    protected void initViews(View view) {
        mDeviceItemsListView = CommonViewHolder.get(view, R.id.deviceItems_listView);
    }

    @Override
    protected void setupAdapters() {
        DeviceItemsAdapter deviceItemsAdapter = new DeviceItemsAdapter(getActivity());
        mDeviceItemsListView.setAdapter(deviceItemsAdapter);
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_device;
    }
}
