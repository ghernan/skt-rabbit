package com.nearsoft.sktrabbit.models;

/**
 * Created by antoniohernandez on 7/17/17.
 */
public class SKTmessage {

    private String title;
    private String content;

    public SKTmessage() {

    }

    public SKTmessage(String title, String content) {
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

    public String toString() {

        return "SKTmessage [ title: " + this.title + ", content: " + this.content + "]";

    }
}
