package app.edu.cdu.com.smartsecurity_manager.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.entity.ChatMSG;
import app.edu.cdu.com.smartsecurity_manager.entity.ChatMSGLab;
import app.edu.cdu.com.smartsecurity_manager.ui.widget.TopView;
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;

/**
 * SmartSecurity-Manager
 * app.edu.cdu.com.smartsecurity_manager.fragment
 * Created by Pantiy on 2017/4/26.
 * Copyright © 2017 All rights Reserved by Pantiy
 */

public class ChatFragment extends BaseFragment {

    private ChatAdapter mChatAdapter;

    private TopView mTopView;
    private RecyclerView mChatRv;
    private EditText mChatContentEt;
    private Button mSendBtn;

    @Override
    protected void initViews(View view) {
        mTopView = findView(R.id.topView);
        mTopView.setText("消息", "老王", null);
        mChatRv = findView(R.id.chat_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setStackFromEnd(true);
        mChatRv.setLayoutManager(linearLayoutManager);
        mChatContentEt = findView(R.id.chatContent_editText);
        mSendBtn = findView(R.id.send_button);
    }

    @Override
    protected void setupAdapters() {
        mChatAdapter = new ChatAdapter(ChatMSGLab.touch().get());
        mChatRv.setAdapter(mChatAdapter);
    }

    @Override
    protected void setupListeners() {

        mTopView.setupListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        }, null);

        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mChatContentEt.getText().toString().equals("")) {
                    ChatMSG chatMSG = ChatMSG.get();
                    chatMSG.setMessage(mChatContentEt.getText().toString());
                    chatMSG.setFromMe(true);
                    mChatContentEt.setText(null);
                    ChatMSGLab.touch().add(chatMSG);
                    updateChatMessage();
                }
            }
        });
    }

    private void updateChatMessage() {
        mChatAdapter.setChatMSGList(ChatMSGLab.touch().get());
        mChatAdapter.notifyDataSetChanged();
        mChatRv.scrollToPosition(mChatAdapter.getLastPosition());
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_chat;
    }

    private class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

        private List<ChatMSG> mChatMSGList;

        private ChatAdapter(List<ChatMSG> chatMSGList) {
            mChatMSGList = chatMSGList;
        }

        @Override
        public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.list_item_for_chat, parent, false);
            return new ChatViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ChatViewHolder holder, int position) {
            holder.bindChatMSG(mChatMSGList.get(position));
        }

        @Override
        public int getItemCount() {
            return mChatMSGList.size();
        }

        private void setChatMSGList(List<ChatMSG> chatMSGList) {
            mChatMSGList = chatMSGList;
        }

        private int getLastPosition() {
            return mChatMSGList.size() - 1;
        }
    }

    private class ChatViewHolder extends RecyclerView.ViewHolder {

        private View mItemView;
        private LinearLayout mFriendView;
        private LinearLayout mMyView;
        private TextView mFriendTv;
        private TextView mMyTv;

        private ChatViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            init();
        }

        private void bindChatMSG(ChatMSG chatMSG) {
            if (chatMSG.isFromMe()) {
                mMyView.setVisibility(View.VISIBLE);
                mFriendView.setVisibility(View.GONE);
                mMyTv.setText(chatMSG.getMessage());
            } else {
                mFriendView.setVisibility(View.VISIBLE);
                mMyView.setVisibility(View.GONE);
                mFriendTv.setText(chatMSG.getMessage());
            }
        }

        private void init() {
            mFriendView = getView(R.id.friendView);
            mMyView = getView(R.id.myView);
            mFriendTv = getView(R.id.friendMessage_textView);
            mMyTv = getView(R.id.myMessage_textView);
        }

        @SuppressWarnings("unchecked")
        private <T extends View> T getView(int id) {
            return CommonViewHolder.get(mItemView, id);
        }
    }
}
