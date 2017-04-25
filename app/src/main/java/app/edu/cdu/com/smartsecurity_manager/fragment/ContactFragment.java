package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.view.View;
import android.widget.ExpandableListView;
import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.adapter.ContactItemsAdapter;
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;

/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class ContactFragment extends BaseFragment {

    private ExpandableListView mContactELV;

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
