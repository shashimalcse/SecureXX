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
        Log.d("Model_CREATE","CALLED");
        this.context=context;
        repository = new UserRepository(context);
    }



    @Override
    public void createUser(String Username, String Email, String Color, String Pin, int Size, String Password) {
        Log.d("BEFORE_CREATE","CALLED");
        repository.saveUser(new User(Username, Email, Color, Pin, Size,Password));
        Log.d("AFTER_CREATE","CALLED");
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }


    @Override
    public void print(){
        Log.d("FUNXCTION","called");
    }
}
