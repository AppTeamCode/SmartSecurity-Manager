package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.ui.widget.TopView;

/**
 * Created by asus on 2017/3/28.
 */

public class LoginSettingFragment extends BaseFragment {
    private FragmentManager fm;
    private Fragment fragment;
    private TopView mTopView;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "LoginSetting create", Toast.LENGTH_SHORT).show();
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    protected void initViews(View view) {

        mTopView = (TopView) mView.findViewById(R.id.login_setting_topView);
        mTopView.setText("返回", "登录设置", null);
        mTextView1 = (TextView) mView.findViewById(R.id.textView_login_setting_in);
        mTextView2 = (TextView)mView.findViewById(R.id.textView_login_setting_out);
        mTextView3 = (TextView)mView.findViewById(R.id.textview_login_setting_test1);
        mTextView4 = (TextView)mView.findViewById(R.id.textview_login_setting_test2);
        mTextView3.setVisibility(View.VISIBLE);
        mTextView4.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {
        fm = getActivity().getSupportFragmentManager();
        mTopView.setupListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new AccoutManageFragment();
                fm.beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        },null);
        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView3.setVisibility(View.VISIBLE);
                mTextView4.setVisibility(View.INVISIBLE);
            }
        });
        mTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView3.setVisibility(View.INVISIBLE);
                mTextView4.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_login_setting;
    }
}
