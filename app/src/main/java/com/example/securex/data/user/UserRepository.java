package com.example.securex.data.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.securex.RegistrationStageFour.RegistrationStageFourConfirmationActivity;

public class UserRepository implements RegistrationRepository {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public UserRepository() {
        Log.d("REPO_BEFORE","CALLED");
        Context instance = RegistrationStageFourConfirmationActivity.getInstance();
        pref = instance.getSharedPreferences("com.android.app.users",instance.MODE_PRIVATE);
        editor = pref.edit();
        Log.d("REPO_AFTER","CALLED");
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
        Log.d("BEFORE_SAVE",user.getUsername());
        Log.d("BEFORE_SAVE",user.getEmail());
        Log.d("BEFORE_SAVE",user.getColor());
        Log.d("BEFORE_SAVE",user.getColor());
        Log.d("BEFORE_SAVE",user.getPassword());
        Log.d("BEFORE_SAVE",user.getPin());
        Log.d("BEFORE_SAVE",Integer.toString(user.getSize()));

        editor.putString("Username",user.getUsername());
        editor.putString("Email",user.getEmail());
        editor.putString("Color",user.getColor());
        editor.putString("Password",user.getPassword());
        editor.putString("Pin",user.getPin());
        editor.putInt("Size",user.getSize());

        editor.apply();
        Log.d("DONE","DONE");
    }
}
