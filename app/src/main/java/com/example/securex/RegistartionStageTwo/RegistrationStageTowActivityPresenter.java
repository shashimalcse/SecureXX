package com.example.securex.RegistartionStageTwo;

import android.graphics.Color;
import android.util.Log;

import com.example.securex.data.Colors;
import com.example.securex.registrationStageOne.RegistrationStageOneActivityMVP;

public class RegistrationStageTowActivityPresenter implements RegistrationStageTowActivityMVP.Presenter {

    int Size;
    String Color;

    RegistrationStageTowActivityMVP.View view;
    String[] colorArray;


    @Override
    public void setView(RegistrationStageTowActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void setSize() {
        view.setSize();
    }

    @Override
    public void submitButtonClicked() {
        if(view!=null){
            Size = view.getSize();
            Color =view.getColor();
            if(Size != 0 || Color.equals("")){
                view.showSuccess();
            }
            else {
                view.showError();
            }
        }
    }

    @Override
    public void setColors(int Size) {
        Colors colors = new Colors();
        if(Size==4){

            colorArray=colors.getColorsFour();
        }
        else if(Size==6){
            colorArray=colors.getColorsSix();
        }
        else if(Size==8){
            colorArray=colors.getColorsEight();
        }
        view.setColor(colorArray);
    }

}
