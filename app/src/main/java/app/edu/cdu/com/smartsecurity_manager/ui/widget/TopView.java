package app.edu.cdu.com.smartsecurity_manager.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.edu.cdu.com.smartsecurity_manager.R;

/**
 * Created by Pantiy on 2017/3/21.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class TopView extends LinearLayout {

    private static final String TAG = "TopView";

    private static final String LEFT = "左边";
    private static final String TITLE = "标题";
    private static final String RIGHT = "右边";

    private Context mContext;

    private TextView mTitleTextView;
    private Button mLeftButton;
    private Button mRightButton;

    public TopView(Context context) {
        super(context);
        mContext = context;
        initViews();
    }

    public TopView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initViews();
    }

    public TopView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initViews();
    }


    private void initViews() {

        Log.i(TAG, " initViews() " );

        setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutParams buttonLayoutParams = new LayoutParams(150, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutParams textViewLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);

        mLeftButton = new Button(mContext);
        mLeftButton.setId(R.id.leftButtonInTopBar);
        mLeftButton.setBackgroundColor(Color.TRANSPARENT);
        mLeftButton.setText(LEFT);
        mLeftButton.setTextColor(Color.WHITE);
        mLeftButton.setTextSize(18f);
        mLeftButton.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_left_arrow, 0, 0, 0);
        addView(mLeftButton, buttonLayoutParams);

        mTitleTextView = new TextView(mContext);
        mTitleTextView.setId(R.id.titleTextViewInTopBar);
        mTitleTextView.setGravity(Gravity.CENTER);
        mTitleTextView.setBackgroundColor(Color.TRANSPARENT);
        mTitleTextView.setText(TITLE);
        mTitleTextView.setTextSize(20f);
        mTitleTextView.setTextColor(Color.WHITE);
        addView(mTitleTextView, textViewLayoutParams);

        mRightButton = new Button(mContext);
        mRightButton.setId(R.id.rightButtonInTopBar);
        mRightButton.setBackgroundColor(Color.TRANSPARENT);
        mRightButton.setText(RIGHT);
        mRightButton.setTextSize(18f);
        mRightButton.setTextColor(Color.WHITE);
        addView(mRightButton, buttonLayoutParams);

    }

    public void setText(String left, String title, String right) {
        mLeftButton.setText(left);
        mTitleTextView.setText(title);
        mRightButton.setText(right);
    }

    public void setListeners(OnClickListener left, OnClickListener right) {
        mLeftButton.setOnClickListener(left);
        mRightButton.setOnClickListener(right);
    }

}
