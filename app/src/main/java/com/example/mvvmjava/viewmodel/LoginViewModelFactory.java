package com.example.mvvmjava.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmjava.interfacemodel.LoginResultCallBack;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginResultCallBack loginResultCallBack;

    public LoginViewModelFactory(LoginResultCallBack loginResultCallBack) {
        this.loginResultCallBack = loginResultCallBack;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new LoginViewModel(loginResultCallBack);
    }
}
