package app.edu.cdu.com.smartsecurity_manager.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;

/**
 * SmartSecurity-Manager
 * app.edu.cdu.com.smartsecurity_manager.utils
 * Created by Pantiy on 2017/4/23.
 * Copyright © 2017 All rights Reserved by Pantiy
 */

public class CommonViewHolder {

    public static final String TAG = "CommonViewHolder";

    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            Log.i(TAG, "viewHolder is null");
            viewHolder = new SparseArray<>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            Log.i(TAG, "childView is null");
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        Log.i(TAG, "getChildView");
        return (T) childView;
    }
}
