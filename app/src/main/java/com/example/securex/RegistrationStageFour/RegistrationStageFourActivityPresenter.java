package com.example.securex.RegistrationStageFour;

public class RegistrationStageFourActivityPresenter implements RegistrationStageFourActivityMVP.Presenter{

    RegistrationStageFourActivityMVP.View view;

    @Override
    public void setView(RegistrationStageFourActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void pinListener() {
        view.showSuccess();
        view.startNextActivity();

    }

    @Override
    public void pinListener2() {

        if(view.getPassword().equals(view.getConfirmPin())){

            view.showSuccess();
            view.startNextActivity();

        }

    }
}
