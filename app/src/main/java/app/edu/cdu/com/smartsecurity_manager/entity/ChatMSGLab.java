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

    public static List<ChatMSG> get() {
        List<ChatMSG> chatMSGList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                ChatMSG chatMSG = ChatMSG.get();
                chatMSG.setFromMe(false);
                chatMSG.setMessage("Hello");
                chatMSGList.add(chatMSG);
            } else {
                ChatMSG chatMSG = ChatMSG.get();
                chatMSG.setFromMe(true);
                chatMSG.setMessage("Hi");
                chatMSGList.add(chatMSG);
            }
        }
        return chatMSGList;
    }
}
