package com.nearsoft.sktrabbit.models;

/**
 * Created by antoniohernandez on 7/17/17.
 */
public class Message {

    private String title;
    private String content;

    public Message(String title, String content) {
        setContent(content);
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
