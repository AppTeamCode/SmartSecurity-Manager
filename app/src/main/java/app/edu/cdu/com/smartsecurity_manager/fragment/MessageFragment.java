package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import app.edu.cdu.com.smartsecurity_manager.R;

/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class MessageFragment extends BaseFragment {

    private static final int ALARM = 0;
    private static final int INFORM = 1;
    private static final int CHAT = 2;

    private List<RadioButton> mRadioButtons = new ArrayList<>();
    private List<ListView> mListViews = new ArrayList<>();

    private RadioGroup mRadioGroup;

    @Override
    protected void initViews() {

        mRadioGroup = (RadioGroup) mView.findViewById(R.id.message_radioGroup);
        RadioButton radioButton = (RadioButton) mView.findViewById(R.id.alarm_radioButton);
        mRadioButtons.add(ALARM, radioButton);
        radioButton = (RadioButton) mView.findViewById(R.id.inform_radioButton);
        mRadioButtons.add(INFORM, radioButton);
        radioButton = (RadioButton) mView.findViewById(R.id.chat_radioButton);
        mRadioButtons.add(CHAT, radioButton);

        ListView listView = (ListView) mView.findViewById(R.id.alarm_listView);
        mListViews.add(ALARM, listView);
        listView = (ListView) mView.findViewById(R.id.inform_listView);
        mListViews.add(INFORM, listView);
        listView = (ListView) mView.findViewById(R.id.chat_listView);
        mListViews.add(CHAT, listView);
    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int current;
                switch (checkedId) {
                    case R.id.alarm_radioButton:
                        current = ALARM;
                        break;
                    case R.id.inform_radioButton:
                        current = INFORM;
                        break;
                    case R.id.chat_radioButton:
                        current = CHAT;
                        break;
                    default:
                        current = -1;
                        break;
                }
                switchMessageListView(current);
            }
        });
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_message;
    }

    private void switchMessageListView(int current) {
        for (int i = 0; i < mListViews.size(); i++) {
            if (i == current) {
                continue;
            }
            mListViews.get(i).setVisibility(View.GONE);
        }
        mListViews.get(current).setVisibility(View.VISIBLE);
    }
}