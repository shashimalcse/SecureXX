package com.example.securex.Login;

import com.example.securex.RegistartionStageThree.RegistrationStageThreeActivityMVP;
import com.example.securex.data.spins.Spin;

public class LoginSpinActivityPresenter implements LoginSpinActivityMVP.Presenter {
    LoginSpinActivityMVP.View view;
    LoginSpinActivityMVP.Model model;
    Spin spin;


    public LoginSpinActivityPresenter() {
        

    }

    @Override
    public void setView(LoginSpinActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void confirmButtonClicked() {

    }

    @Override
    public void leftButtonClicked() {

    }

    @Override
    public void rightButtonClicked() {

    }

    @Override
    public void setSpins() {
        view.setSpins(spin);
    }
}
