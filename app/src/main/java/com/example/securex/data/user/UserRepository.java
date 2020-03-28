package com.example.securex.data.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.securex.RegistrationStageFour.RegistrationStageFourConfirmationActivity;

public class UserRepository implements RegistrationRepository {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    Context context;

    public UserRepository(Context context) {
        pref = context.getSharedPreferences("com.android.app.users",context.MODE_PRIVATE);
        editor=pref.edit();

    }

    @Override
    public User getUser() {
        String Username =pref.getString("Username",null);
        String Email =pref.getString("Email",null);
        String Pin =pref.getString("Pin",null);
        String Password =pref.getString("Password",null);
        String Color =pref.getString("Color",null);
        int Size =pref.getInt("Size",0);


        return new User(Username, Email, Color, Pin, Size,Password);



    }

    @Override
    public void saveUser(User user) {
        editor.clear();

        editor.putString("Username",user.getUsername());
        editor.putString("Email",user.getEmail());
        editor.putString("Color",user.getColor());
        editor.putString("Password",user.getPassword());
        editor.putString("Pin",user.getPin());
        editor.putInt("Size",user.getSize());
        editor.putString("UserStatus","Registered");

        editor.apply();

    }
}
