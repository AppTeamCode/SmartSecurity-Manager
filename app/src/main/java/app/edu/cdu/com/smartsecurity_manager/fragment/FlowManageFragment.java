package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.ui.MainActivity;
import app.edu.cdu.com.smartsecurity_manager.ui.widget.TopView;

/**
 * Created by asus on 2017/3/28.
 */

public class FlowManageFragment extends BaseFragment {
    private FragmentManager fm;
    private Fragment fragment;
    private TopView mTopView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "FlowManage create", Toast.LENGTH_SHORT).show();
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    protected void initViews(View view) {

        mTopView = (TopView)mView.findViewById(R.id.flow_manage_topView);
        mTopView.setText("返回","流量管理",null);
        fm = getActivity().getSupportFragmentManager();
    }
    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {

        mTopView.setupListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        },null);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_flow_manage;
    }
}
