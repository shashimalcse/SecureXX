package com.example.securex.LoginPin;

import android.content.Context;
import android.view.animation.RotateAnimation;

import com.example.securex.LoginSpin.LoginSpinActivityMVP;
import com.example.securex.data.spins.Spin;
import com.example.securex.data.user.User;

public interface LoginPinActivityMVP {

    interface View {

        void showSuccess();

        void showError();

        void startNextActivity();

        String getPin();

        void clearPin();











    }

    interface Presenter {
        void setView(LoginPinActivityMVP.View view);

        void pinListener();


        void setContext(Context context);

        void  setUser();


    }

    interface Model {

        User getUser();



    }
}
