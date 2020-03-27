package com.example.securex.registrationStageOne;

import com.example.securex.data.User;

public interface RegistrationStageOneActivityMVP {

    interface View {
        String getUsername();

        String getEmail();

        void showUsernameError();

        void showEmailError();

        void showSuccess();

        void startNextActivity();


    }

    interface Presenter {
        void setView(View view);

        void submitButtonClicked();


        String Validation(String Username, String Email);

        boolean isValidEmail(String email);

        boolean isValidUsername(String username);


    }

}