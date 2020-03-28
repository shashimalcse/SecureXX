package com.example.securex.data.user;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.securex.RegistrationStageFour.RegistrationStageFourConfirmationActivity;

public class UserRepository implements RegistrationRepository {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public UserRepository() {

        Context instance = RegistrationStageFourConfirmationActivity.getInstance();
        pref = instance.getSharedPreferences("com.android.app.users",instance.MODE_PRIVATE);
        editor = pref.edit();
    }

    @Override
    public User getUser() {
        String Username =pref.getString("Username",null);
        String Email =pref.getString("Email",null);
        String Pin =pref.getString("Pin",null);
        String Password =pref.getString("Password",null);
        String Color =pref.getString("Color",null);
        int Size =pref.getInt("Pin",0);


        return new User(Username, Email, Color, Pin, Size,Password);



    }

    @Override
    public void saveUser(User user) {
        editor.putString("Username",user.getUsername());
        editor.putString("Email",user.getEmail());
        editor.putString("Color",user.getColor());
        editor.putString("Password",user.getPassword());
        editor.putString("Pin",user.getPin());
        editor.putInt("Size",user.getSize());

        editor.apply();
    }
}
