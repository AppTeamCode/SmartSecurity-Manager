package app.edu.cdu.com.smartsecurity_manager.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * SmartSecurity-Manager
 * app.edu.cdu.com.smartsecurity_manager.entity
 * Created by Pantiy on 2017/4/26.
 * Copyright © 2017 All rights Reserved by Pantiy
 */

public class ChatMSGLab {

    private static ChatMSGLab sChatMSGLab;

    private List<ChatMSG> mChatMSGList = new ArrayList<>();

    public static ChatMSGLab touch() {
        if (sChatMSGLab == null) {
            sChatMSGLab = new ChatMSGLab();
        }
        return sChatMSGLab;
    }

    private ChatMSGLab() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                ChatMSG chatMSG = ChatMSG.get();
                chatMSG.setFromMe(false);
                chatMSG.setMessage("Hello");
                mChatMSGList.add(chatMSG);
            } else {
                ChatMSG chatMSG = ChatMSG.get();
                chatMSG.setFromMe(true);
                chatMSG.setMessage("Hi");
                mChatMSGList.add(chatMSG);
            }
        }
    }

    public List<ChatMSG> get() {
        return mChatMSGList;
    }

    public void add(ChatMSG chatMSG) {
        mChatMSGList.add(chatMSG);
    }
}
