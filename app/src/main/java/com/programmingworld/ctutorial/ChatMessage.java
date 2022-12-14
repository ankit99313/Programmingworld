package com.programmingworld.ctutorial;

import android.util.Log;

import java.util.Date;

public class ChatMessage {
   // private String id;
    private String messageText;
    private  String messageUser;
    private long messageTime;

    private String userId;

    public ChatMessage(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;
       // this.userId=userId;

        // Initialize to current time
       messageTime = new Date().getTime();
    }


    public ChatMessage(String messageText, String messageUser,String userId) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        messageTime = new Date().getTime();
         this.userId=userId;

        // Initialize to current time
     //   messageTime = new Date().getTime();
    }

   public ChatMessage(String messageUser) {
        this.messageUser = messageUser;
    }


    public ChatMessage(String messageText, String messageUser,long messageTime) {
        this.messageText = messageText;
        this.messageUser=messageUser;
        this.messageTime=messageTime;
    }




    public ChatMessage(long messageTime) {
        this.messageTime = messageTime;
    }

    public ChatMessage(){

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public  String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
   public String getUserId() {
        return userId;
    }

    public void setUserIdr(String userId) {
        this.userId = userId;
    }


}
