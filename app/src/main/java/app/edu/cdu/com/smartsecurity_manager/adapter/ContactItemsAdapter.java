package app.edu.cdu.com.smartsecurity_manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;

/**
 * SmartSecurity-Manager
 * app.edu.cdu.com.smartsecurity_manager.adapter
 * Created by Pantiy on 2017/3/29.
 * Copyright © 2017 All rights Reserved by Pantiy
 */

public class ContactItemsAdapter extends BaseExpandableListAdapter {

    private static final String[] sContactGroupItems = new String[] {"我的联系人", "同事"};
    private static final String[][] sContactChildItems =
            new String[][] { {"张三", "李四"}, {"老王", "小李"} };

    private Context mContext;

    public ContactItemsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getGroupCount() {
        return sContactGroupItems.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return sContactChildItems.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return sContactGroupItems[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return sContactChildItems[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.list_item_for_contact_group, parent, false);
        } else {
            TextView contactGroupName = CommonViewHolder.get(convertView, R.id.contactGroupName_tv);
            contactGroupName.setText(sContactGroupItems[groupPosition]);
            TextView contactGroupState = CommonViewHolder.get(convertView, R.id.contactGroupState_tv);
            contactGroupState.setText("1/2");
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_for_contact, parent, false);
        } else {
            TextView contactName = CommonViewHolder.get(convertView, R.id.contactName_tv);
            contactName.setText(sContactChildItems[groupPosition][childPosition]);
            TextView contactUserType = CommonViewHolder.get(convertView, R.id.contactUserType_tv);
            contactUserType.setText("一般用户");
            TextView contactState = CommonViewHolder.get(convertView, R.id.contactState_tv);
            contactState.setText("在线");
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
