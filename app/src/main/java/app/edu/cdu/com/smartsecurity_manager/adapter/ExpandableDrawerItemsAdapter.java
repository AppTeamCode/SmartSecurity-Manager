package app.edu.cdu.com.smartsecurity_manager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import app.edu.cdu.com.smartsecurity_manager.R;

/**
 * Created by Pantiy on 2017/3/28.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class ExpandableDrawerItemsAdapter extends BaseExpandableListAdapter {

    private static String[] sDrawerGroupItems = new String[] {"我的资料", "我的收藏", "我的设置", "关于与帮助"};
    private static String[][] sDrawerChildItems = new String[][] { null, null,
            {"账号管理", "消息管理", "流量管理", "流量管理", "记录管理", "隐私管理", "插件管理"},
            null};

    private Context mContext;

    public ExpandableDrawerItemsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getGroupCount() {
        return sDrawerGroupItems.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (groupPosition == 2) {
            return sDrawerChildItems[groupPosition].length;
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return sDrawerGroupItems[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return sDrawerChildItems[groupPosition][childPosition];
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_with_icon, parent, false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.itemIcon_imageView);
            imageView.setImageResource(R.mipmap.ic_setting);
            imageView.setBackgroundColor(Color.GRAY);
            TextView textView = (TextView) convertView.findViewById(R.id.itemName_textView);
            textView.setText(sDrawerGroupItems[groupPosition]);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_with_icon, parent, false);
            convertView.setPadding(35, 0, 0, 0);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.itemIcon_imageView);
            imageView.setImageResource(R.mipmap.ic_setting);
            imageView.setBackgroundColor(Color.GRAY);
            TextView textView = (TextView) convertView.findViewById(R.id.itemName_textView);
            textView.setText(sDrawerChildItems[groupPosition][childPosition]);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
