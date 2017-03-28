package app.edu.cdu.com.smartsecurity_manager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import app.edu.cdu.com.smartsecurity_manager.R;

/**
 * Created by Pantiy on 2017/3/9.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class SettingItemsAdapter extends BaseAdapter {

    private String[] mSettingItems = new String[] {"我的资料", "我的收藏", "我的设置", "关于与帮助"};

    private Context mContext;

    public SettingItemsAdapter(Context context) {
        super();
        mContext = context;
    }

    @Override
    public int getCount() {
        return mSettingItems.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_with_icon,viewGroup,false);
            TextView textView = (TextView) view.findViewById(R.id.itemName_textView);
            textView.setText(mSettingItems[i]);
            ImageView imageView = (ImageView) view.findViewById(R.id.itemIcon_imageView);
            imageView.setImageResource(R.mipmap.ic_setting);
            imageView.setBackgroundColor(Color.GRAY);
        }
        return view;
    }
}
