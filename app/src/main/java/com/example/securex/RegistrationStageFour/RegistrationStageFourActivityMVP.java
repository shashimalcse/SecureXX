package com.example.securex.RegistrationStageFour;

import com.example.securex.RegistartionStageThree.ImageAdapter;
import com.example.securex.RegistartionStageThree.RegistrationStageThreeActivityMVP;

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

}
