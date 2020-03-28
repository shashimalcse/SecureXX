package com.example.securex.RegistrationStageFour;

import android.content.Intent;
import android.util.Log;

public class RegistrationStageConfirmationActivityPresenter implements RegistrationStageFourActivityMVP.Presenter{

    RegistrationStageFourActivityMVP.View view;


    @Override
    public void setView(RegistrationStageFourActivityMVP.View view) {
        this.view=view;
    }




    @Override
    public void pinListener() {
        if(view.getPin().equals(view.getConfirmPin())){
            try {

                Log.d("BEFORE_SAVE_PRE",view.getUsername());
                Log.d("BEFORE_SAVE_PRE",view.getEmail());
                Log.d("BEFORE_SAVE_PRE",view.getColor());
                Log.d("BEFORE_SAVE_PRE",view.getColor());
                Log.d("BEFORE_SAVE_PRE",view.getPassword());
                Log.d("BEFORE_SAVE_PRE",view.getPin());
                Log.d("BEFORE_SAVE_PRE",view.getSize());
                RegistrationStageFourActivityMVP.Model  model = new RegistrationModel();
                Log.d("BEFORE","done");
                model.print();;
                model.createUser(view.getUsername(), view.getEmail(), view.getColor(), view.getPin(), Integer.parseInt(view.getSize()), view.getPassword());
                Log.d("SAVE","done");
                view.showSuccess();
                view.startNextActivity();

            }
            catch (Exception e){
                view.showError();
            }


        }

    }
}
