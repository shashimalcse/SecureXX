package com.example.securex.LoginSpin;

import android.content.Context;
import android.view.animation.RotateAnimation;

import com.example.securex.data.spins.Spin;
import com.example.securex.data.user.User;

public interface LoginSpinActivityMVP {

    interface View {

        void showSuccess();

        void showError();

        void startNextActivity();

        void setSpins(Spin spin);

        void spinAnimation(RotateAnimation rotateAnimation);

        void setCount(int count);











    }

    interface Presenter {
        void setView(LoginSpinActivityMVP.View view);

        void confirmButtonClicked();

        void leftButtonClicked();

        void rightButtonClicked();

        void setSpins();

        void setContext(Context context);

        void setVariables(Spin spin,User user);
    }

    interface Model {

        User getUser();



    }
}

