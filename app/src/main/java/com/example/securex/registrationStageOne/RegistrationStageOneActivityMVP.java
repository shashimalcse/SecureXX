package com.example.securex.registrationStageOne;

import android.content.Context;

import com.example.securex.data.user.User;

public interface RegistrationStageOneActivityMVP {

    interface View {
        String getUsername();

        String getEmail();

        void showUsernameError();

        void showEmailError();

        void showSuccess();

        void startNextActivity();

        void userExist();


    }

    interface Presenter {
        void setView(View view);

        void submitButtonClicked();


        String Validation(String Username, String Email);

        boolean isValidEmail(String email);

        boolean isValidUsername(String username);

        void setContext(Context context);




    }


}