package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by asus on 2017/3/28.
 */

public class MySettingDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        return new AlertDialog.Builder(getActivity()).setTitle("是否确定退出当前设备").setPositiveButton("取消",null).setNegativeButton("确定退出",null).create();
    }

}
