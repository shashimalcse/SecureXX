package com.example.securex.LoginPin;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.securex.LoginSpin.LoginSpinActivityMVP;
import com.example.securex.data.user.User;

public class LoginPinActivityPresenter implements  LoginPinActivityMVP.Presenter {

   LoginPinActivityMVP.View view;
   Context context;
   LoginPinActivityMVP.Model model;
   User user;

    private String Confirm;
    private String Pin;


    public LoginPinActivityPresenter(Context context) {
        this.context=context;
        model = new LoginPinModel(context);
        setUser();
    }

    @Override
    public void setView(LoginPinActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void pinListener() {
        Confirm = view.getPin();
        Pin =user.getPin();
        if (Pin.equals(Confirm)){
            view.showSuccess();
            view.startNextActivity();
        }
        else {
            view.showError();
            view.clearPin();

        }

    }

    @Override
    public void setContext(Context context) {
        this.context=context;
    }

    @Override
    public void setUser() {
        user =model.getUser();
    }
}
