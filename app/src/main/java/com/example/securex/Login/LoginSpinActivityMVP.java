package com.example.securex.Login;

import com.example.securex.RegistartionStageThree.ImageAdapter;
import com.example.securex.RegistartionStageThree.RegistrationStageThreeActivityMVP;
import com.example.securex.data.spins.Spin;
import com.example.securex.data.user.User;

public interface LoginSpinActivityMVP {

    interface View {

        void showSuccess();

        void showError();

        void startNextActivity();

        void setSpins(Spin spin);









    }

    interface Presenter {
        void setView(LoginSpinActivityMVP.View view);

        void confirmButtonClicked();

        void leftButtonClicked();

        void rightButtonClicked();

        void setSpins();
    }

    interface Model {

        User getUser();



    }
}

