package com.example.securex.RegistrationStageFour;

import android.content.Context;
import android.util.Log;

public class RegistrationStageFourActivityPresenter implements RegistrationStageFourActivityMVP.Presenter{

    RegistrationStageFourActivityMVP.View view;


    @Override
    public void setView(RegistrationStageFourActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void setContext(Context context) {

    }


    @Override
    public void pinListener() {

        if(!view.getPin().equals("")){
            view.showSuccess();
            view.startNextActivity();
        }


    }


}
