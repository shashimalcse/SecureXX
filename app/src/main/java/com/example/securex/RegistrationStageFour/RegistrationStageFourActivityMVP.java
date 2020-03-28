package com.example.securex.RegistrationStageFour;

import android.content.Context;

import com.example.securex.data.user.User;

public interface RegistrationStageFourActivityMVP {

    interface View {

        void showSuccess();

        void showError();


        void startNextActivity();

        String getUsername();

        String getEmail();

        String getSize();

        String getColor();

        String getPassword();

        String getPin();

        String getConfirmPin();


    }

    interface Presenter {
        void setView(RegistrationStageFourActivityMVP.View view);

        void setContext(Context context);

        void pinListener();

    }

    interface Model {
        void createUser(String Username, String Email,String Color,String Pin,int Size,String Password);

        User getUser();

        void print();


    }

}
