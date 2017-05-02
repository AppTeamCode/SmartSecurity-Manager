package app.edu.cdu.com.smartsecurity_manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.utils.L;

/**
 * Created by Administrator on 2017/4/9.
 */

public class PluginManageItemsAdapter extends BaseAdapter {
    private Context mContext;
    public  PluginManageItemsAdapter(Context Context){
        super();
        mContext=Context;
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_for_pluginmanage,viewGroup,false);
            L.e("Here");
        }
        return view;
    }
}
