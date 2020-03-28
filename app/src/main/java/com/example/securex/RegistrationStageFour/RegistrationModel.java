package com.example.securex.RegistrationStageFour;

import com.example.securex.data.user.RegistrationRepository;
import com.example.securex.data.user.User;
import com.example.securex.data.user.UserRepository;

public class RegistrationModel implements RegistrationStageFourActivityMVP.Model {


    private UserRepository repository;

    public  RegistrationModel(UserRepository repository){
        this.repository=repository;
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
