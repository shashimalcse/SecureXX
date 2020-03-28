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
            Log.d("BEFORE_SAVE_PRE",view.getUsername());
            Log.d("BEFORE_SAVE_PRE",view.getEmail());
            Log.d("BEFORE_SAVE_PRE",view.getColor());
            Log.d("BEFORE_SAVE_PRE",view.getColor());
            Log.d("BEFORE_SAVE_PRE",view.getPassword());
            Log.d("BEFORE_SAVE_PRE",view.getPin());
            Log.d("BEFORE_SAVE_PRE",view.getSize());
            Log.d("AAAA",view.getPin());
            view.showSuccess();
            view.startNextActivity();
        }


    }


}
