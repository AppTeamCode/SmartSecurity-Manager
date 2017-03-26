package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public abstract class BaseFragment extends Fragment {

    protected View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(setLayoutRes(), container, false);
        findViews();
        setAdapter();
        setListener();
        return mView;
    }

    protected abstract void findViews();

    protected abstract void setAdapter();

    protected abstract void setListener();

    protected abstract int setLayoutRes();
}
