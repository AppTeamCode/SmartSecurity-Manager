package app.edu.cdu.com.smartsecurity_manager.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * SmartSecurity-Manager
 * app.edu.cdu.com.smartsecurity_manager.entity
 * Created by Pantiy on 2017/4/26.
 * Copyright © 2017 All rights Reserved by Pantiy
 */

public class ChatMSG {

    private List<ChatMSG> mChatMSGList = new ArrayList<>();

    private boolean mIsFromMe;
    private String mMessage;

    public static ChatMSG get() {
        return new ChatMSG();
    }

    private ChatMSG() {
        init();
    }

    public boolean isFromMe() {
        return mIsFromMe;
    }

    public void setFromMe(boolean isFromMe) {
        mIsFromMe = isFromMe;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    private void init() {

    }

    public List<ChatMSG> getChatMSGList() {
        return mChatMSGList;
    }
}
