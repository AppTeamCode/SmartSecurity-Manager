package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.adapter.ContactItemsAdapter;
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;

/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class ContactFragment extends BaseFragment {

    private ExpandableListView mContactELV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "Contact create", Toast.LENGTH_SHORT).show();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initViews(View view) {
        mContactELV = CommonViewHolder.get(view, R.id.contact_elv);
    }

    @Override
    protected void setupAdapters() {
        ContactItemsAdapter adapter = new ContactItemsAdapter(getActivity());
        mContactELV.setAdapter(adapter);
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_contact;
    }
}
