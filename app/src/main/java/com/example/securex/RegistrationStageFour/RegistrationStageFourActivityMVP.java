package com.example.securex.RegistrationStageFour;

import com.example.securex.data.user.User;

public interface RegistrationStageFourActivityMVP {

    interface View {

        void showSuccess();

        void showError();


        void startNextActivity();

        String getUsername();

        String getEmail();

        int getSize();

        String getColor();

        String getPassword();

        String getPin();

        String getConfirmPin();


    }

    interface Presenter {
        void setView(RegistrationStageFourActivityMVP.View view);

        void pinListener();

        void pinListener2();
    }

    interface Model {
        void createUser(String name, String lastName);

        User getUser();


    }

}
