package com.example.testproject.helper;

public class Message {
    private String content;
    private String className;

    public Message() {
    }

    public Message(String content, String className) {
        this.content = content;
        this.className = className;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
