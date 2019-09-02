package com.example.mvvmjava.model;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;

import java.util.regex.Pattern;

public class User extends BaseObservable {
    @NonNull
    private String email,password;

    public User(@NonNull String email, @NonNull String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
    public int isValidData(){
        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
        return 1;
        else if (getPassword().length() < 6)
            return 2;
        else
            return -1;



    }
}
