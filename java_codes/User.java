package com.yunuskaratepe.e_mailapplication;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

public class User {

    private String userName, password, mailAddress;
    private Bitmap image;

    public User(String userName, String password, Bitmap image){
        this.userName = userName;
        this.password = password;
        this.image = image;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }


}
