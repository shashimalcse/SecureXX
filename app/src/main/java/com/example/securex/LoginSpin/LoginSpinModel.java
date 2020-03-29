package com.example.securex.LoginSpin;

import android.content.Context;

import com.example.securex.data.user.User;
import com.example.securex.data.user.UserRepository;

public class LoginSpinModel implements LoginSpinActivityMVP.Model {

    UserRepository repository;
    Context context;


    public LoginSpinModel(Context context) {
        this.context=context;
        repository = new UserRepository(context);
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
