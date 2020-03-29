package com.example.securex.Login;

import android.content.Context;

import com.example.securex.data.user.User;
import com.example.securex.data.user.UserRepository;

public class LoginModel implements LoginSpinActivityMVP.Model {

    UserRepository repository;
    Context context;


    public LoginModel(Context context) {
        this.context=context;
        repository = new UserRepository(context);
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
