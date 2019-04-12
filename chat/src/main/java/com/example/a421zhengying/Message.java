package com.example.a421zhengying;

/**
 * Created by 郑莹 on 2019/4/12.
 */

public class Message {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private String content;
    private int type;

    public Message(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
