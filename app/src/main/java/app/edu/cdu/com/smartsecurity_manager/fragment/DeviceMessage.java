package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.ui.widget.TopView;
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;

import static app.edu.cdu.com.smartsecurity_manager.R.id.send_message_btn;

/**
 * Created by Hai on 2017/4/26.
 */

public class DeviceMessage extends BaseFragment{
    private FragmentManager fm;
    private Fragment fragment;
    private TopView mTopView;
    private Button SendMessageBtn;

    @Override
    protected void initViews(View view) {
        mTopView = (TopView) CommonViewHolder.get(view, R.id.device_message_topView);
        mTopView.setText("返回","设备消息",null);
        SendMessageBtn = (Button)CommonViewHolder.get(view, send_message_btn);

    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {
        fm = getActivity().getSupportFragmentManager();
        mTopView.setupListeners(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fragment = new DeviceFragment();
                fm.beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        },null);

        SendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_device_message;
    }
}
