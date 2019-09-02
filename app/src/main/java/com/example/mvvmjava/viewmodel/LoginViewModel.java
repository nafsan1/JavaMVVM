package com.example.mvvmjava.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.mvvmjava.interfacemodel.LoginResultCallBack;
import com.example.mvvmjava.model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallBack loginResultCallBack;

    public LoginViewModel(LoginResultCallBack loginResultCallBack) {
        this.loginResultCallBack = loginResultCallBack;
        this.user = new User();
    }

    public TextWatcher getEmailTexWatcher(){
            return new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
                }
            };
    }

    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    public void onLoginClicked(View view){
       int errorCode = user.isValidData();
       if (errorCode == 0){
           loginResultCallBack.onError("You must enter email addres");
       }else if(errorCode == 1){
           loginResultCallBack.onError("Your email is invalid");
        }else if (errorCode == 2){
           loginResultCallBack.onError("Password length must greater than 6 characters");
       }else {
           loginResultCallBack.onSucces("Login Succes");
       }
    }
}

