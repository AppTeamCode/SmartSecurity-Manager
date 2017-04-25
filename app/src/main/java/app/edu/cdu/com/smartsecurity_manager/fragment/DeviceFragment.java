package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.adapter.DeviceItemsAdapter;
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;

/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class DeviceFragment extends BaseFragment {

    private ListView mDeviceItemsListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "Device create", Toast.LENGTH_SHORT).show();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

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
