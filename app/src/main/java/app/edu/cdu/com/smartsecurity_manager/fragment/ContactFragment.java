package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.widget.ExpandableListView;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.adapter.ContactItemsAdapter;

/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class ContactFragment extends BaseFragment {

    private ExpandableListView mContactElv;

    @Override
    protected void initViews() {
        mContactElv = (ExpandableListView) mView.findViewById(R.id.contact_elv);
    }

    @Override
    protected void setupAdapters() {
        ContactItemsAdapter adapter = new ContactItemsAdapter(getActivity());
        mContactElv.setAdapter(adapter);
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_contact;
    }
}
