package app.edu.cdu.com.smartsecurity_manager.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.adapter.ExpandableDrawerItemsAdapter;
import app.edu.cdu.com.smartsecurity_manager.ui.widget.TopView;

/**
 * Created by Y.C. on 2017/3/27.
 */

public class SettingActivity extends BaseActivity {

    private ExpandableListView mExpandableListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        ExpandableDrawerItemsAdapter adapter = new ExpandableDrawerItemsAdapter(this);
        mExpandableListView.setAdapter(adapter);
        mExpandableListView.setGroupIndicator(null);
        mExpandableListView.setDivider(null);
    }
}
