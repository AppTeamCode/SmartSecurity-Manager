package app.edu.cdu.com.smartsecurity_manager.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.ui.widget.TopView;

/**
 * Created by Y.C. on 2017/3/27.
 */

public class SettingActivity extends BaseActivity {

    private TopView mTopView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mTopView = (TopView) findViewById(R.id.topView);
        mTopView.setText("返回","我的设置",null);
        mTopView.setListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        },null);
    }
}
