package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.content.Intent;
import android.view.View;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.ui.MainActivity;
import app.edu.cdu.com.smartsecurity_manager.ui.widget.TopView;
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;

/**
 * Created by 小帆哥 on 2017/4/25.
 */

public class AboutAndHelpFragment extends BaseFragment {
    private TopView mTopView;

    @Override
    protected void initViews(View view) {
        mTopView = CommonViewHolder.get(view, R.id.about_and_help_topView);
        mTopView.setText("设置", "关于与帮助", null);
    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {
        mTopView.setupListeners(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        },null);
        }



            @Override
            protected int setLayoutRes() {
                return R.layout.fragment_about_and_help;
            }
        }