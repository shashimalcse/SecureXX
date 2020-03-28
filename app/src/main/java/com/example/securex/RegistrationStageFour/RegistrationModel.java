package com.example.securex.RegistrationStageFour;

import android.content.Context;
import android.util.Log;

import com.example.securex.data.user.RegistrationRepository;
import com.example.securex.data.user.User;
import com.example.securex.data.user.UserRepository;

public class RegistrationModel implements RegistrationStageFourActivityMVP.Model {


    private RegistrationRepository repository;
    Context context;

    public  RegistrationModel(Context context){
        this.context=context;
        repository = new UserRepository(context);
    }



    @Override
    public void createUser(String Username, String Email, String Color, String Pin, int Size, String Password) {
        repository.saveUser(new User(Username, Email, Color, Pin, Size,Password));

    }

    @Override
    public User getUser() {
        return repository.getUser();
    }


}
