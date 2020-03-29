package com.example.securex.LoginPin;

import android.content.Context;

import com.example.securex.data.user.User;
import com.example.securex.data.user.UserRepository;

public class LoginPinModel implements LoginPinActivityMVP.Model {
    UserRepository repository;
    Context context;

    public LoginPinModel(Context context) {
        this.context=context;
        repository = new UserRepository(context);
    }


    @Override
    public User getUser() {
        return repository.getUser();
    }
}
