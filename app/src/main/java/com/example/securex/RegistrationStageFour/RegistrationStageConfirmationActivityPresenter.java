package com.example.securex.RegistrationStageFour;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RegistrationStageConfirmationActivityPresenter implements RegistrationStageFourActivityMVP.Presenter{

    RegistrationStageFourActivityMVP.View view;
    Context context;


    @Override
    public void setView(RegistrationStageFourActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void setContext(Context context) {
        this.context=context;
    }


    @Override
    public void pinListener() {
        if(view.getPin().equals(view.getConfirmPin())){
            try {
                RegistrationStageFourActivityMVP.Model  model = new RegistrationModel(context);
                model.createUser(view.getUsername(), view.getEmail(), view.getColor(), view.getPin(), Integer.parseInt(view.getSize()), view.getPassword());

                view.showSuccess();
                view.startNextActivity();

            }
            catch (Exception e){
                view.showError();
            }


        }

    }
}
