package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.ui.MainActivity;
import app.edu.cdu.com.smartsecurity_manager.ui.widget.TopView;
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;

/**
 * Created by 小帆哥 on 2017/4/26.
 */

public class DeviceShareFragment extends BaseFragment {

    private TopView mTopView;
    private Button mConfirmShareButton;

    @Override
    protected void initViews(View view){
        mTopView = CommonViewHolder.get(view, R.id.device_share_topView);
        mTopView.setText("设备","分享","取消");
        mConfirmShareButton = CommonViewHolder.get(view,R.id.Confirm_share_button);
    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {
        mTopView.setupListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        },new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        mConfirmShareButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_device_share;
    }
}
