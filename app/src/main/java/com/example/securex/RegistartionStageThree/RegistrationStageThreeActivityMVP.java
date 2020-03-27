package com.example.securex.RegistartionStageThree;

import android.content.Context;
import android.view.View;
import android.widget.GridView;

import com.example.securex.registrationStageOne.RegistrationStageOneActivityMVP;

public interface RegistrationStageThreeActivityMVP {

    interface View {

        void showSuccess();

        void showError();

        void setColumns();


        void setAdapter() ;

        void startNextActivity(String Password);

        String getUsername();

        String getEmail();

        int getSize();

        String getColor();

        String getPassword();



    }

    interface Presenter {
        void setView(RegistrationStageThreeActivityMVP.View view);

        void confirmButtonClicked();

        void removeButtonClicked();

        void gridViewListener(android.view.View view, int position);

        void getFruitsArray(ImageAdapter imageAdapter);


        void confirm2ButtonClicked();
    }
}
