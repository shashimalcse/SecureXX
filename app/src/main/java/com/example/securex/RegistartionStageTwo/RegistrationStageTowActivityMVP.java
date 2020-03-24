package com.example.securex.RegistartionStageTwo;

import com.example.securex.registrationStageOne.RegistrationStageOneActivityMVP;

public interface RegistrationStageTowActivityMVP {

    interface View {
        int getSize();

        void setSize();

        String getColor();

        void setColor(String [] Colors);


        void showSuccess();

        void showError();




    }

    interface Presenter {
        void setView(View view);

        void setSize();

        void submitButtonClicked();

        void setColors(int Size);




    }



}
