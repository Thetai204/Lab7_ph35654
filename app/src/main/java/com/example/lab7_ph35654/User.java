package com.example.lab7_ph35654;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String passWord;
    private boolean save=false;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord, boolean save) {
        this.userName = userName;
        this.passWord = passWord;
        this.save = save;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }
}
