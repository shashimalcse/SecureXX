package com.example.securex.LoginSpin;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;

import com.example.securex.MainActivity;
import com.example.securex.data.spins.Spin;
import com.example.securex.data.spins.SpinEight;
import com.example.securex.data.spins.SpinFour;
import com.example.securex.data.spins.SpinSix;
import com.example.securex.data.user.User;
import com.example.securex.registrationStageOne.RegistrationStageOneActivity;

import java.util.ArrayList;

public class LoginSpinActivityPresenter implements LoginSpinActivityMVP.Presenter {
    LoginSpinActivityMVP.View view;
    LoginSpinActivityMVP.Model model;
    Spin spin;
    Context context;
    User user;

    float oldDegree;
    float newDegree;
    int Degree;
    int Size;
    private String UserColor;
    ArrayList<String> ColorsArray;
    ArrayList<String> FruitsArray;
    private int Color_Index;
    int PhaseChange;
    private String UserPassword;
    private String MatchingPassword;
    int SelectedFruits;
    int Attempts;


    public LoginSpinActivityPresenter() {


    }

    @Override
    public void setView(LoginSpinActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void confirmButtonClicked() {
        SelectedFruits++;

        if (Color_Index < 0) {
            Color_Index = Size + Color_Index;
        }


        MatchingPassword += FruitsArray.get(Color_Index);

        Log.d("PASSWORD",MatchingPassword);
        if (MatchingPassword.equals(UserPassword)) {
            SelectedFruits = 0;
            MatchingPassword="";
            view.showSuccess();
        }
        else if (!MatchingPassword.equals(UserPassword) && SelectedFruits == FruitsArray.size()) {
            view.showError();
            SelectedFruits = 0;
            MatchingPassword = "";
            Attempts++;
        }
        if (Attempts > 3) {
            view.setButtonStatus(false);
            view.startNextActivity();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Attempts = 0;
                    SelectedFruits=0;
                    MatchingPassword="";
                    view.setButtonStatus(true);
                    Log.d("TIME","CALLED");
                }
            }, 5000);


            Log.d("FRUIT", FruitsArray.get(Color_Index));


        }


        view.setCount(SelectedFruits);

    }

    @Override
    public void leftButtonClicked() {
        float d = newDegree-Degree;
        spin(oldDegree,d);
        oldDegree=d;
        newDegree-=Degree;
        if(Color_Index<=-PhaseChange){
            Color_Index=0;
        }
        else{
            Color_Index--;
        }
        Log.d("s",Integer.toString(Color_Index));

    }

    @Override
    public void rightButtonClicked() {
        float d = newDegree+Degree;
        spin(oldDegree,d);
        oldDegree=d;
        newDegree+=Degree;
        if(Color_Index>=PhaseChange){
            Color_Index=0;
        }
        else{
            Color_Index++;
        }
        Log.d("s",Integer.toString(Color_Index));

    }

    @Override
    public void setSpins() {
        model = new LoginSpinModel(context);
        user = model.getUser();
        int Size = user.getSize();
        if(Size==4){
            spin = new SpinFour();
        }
        else if(Size==6){
            spin = new SpinSix();
        }
        else if (Size==8){
            spin = new SpinEight();
        }


        view.setSpins(spin);
        setVariables(spin,user);
    }

    @Override
    public void setContext(Context context) {
        this.context=context;
    }

    @Override
    public void setVariables(Spin spin, User user) {
        oldDegree = 0;
        newDegree = 0;
        Size = user.getSize();
        UserColor = user.getColor();
        UserPassword=user.getPassword();
        MatchingPassword="";
        SelectedFruits=0;
        Attempts=0;

        Degree = spin.getDegree();
        ColorsArray = spin.getColors();
        FruitsArray = spin.getFruits();
        PhaseChange = spin.getPhaseChange();

        Color_Index = ColorsArray.indexOf(UserColor);
    }

    public void spin(float oldDegree,float newDegree){
        RotateAnimation rotateAnimation = new RotateAnimation(oldDegree,newDegree,RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(100);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // we empty the result text view when the animation start

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // we display the correct sector pointed by the triangle at the end of the rotate animation

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.spinAnimation(rotateAnimation);
    }
}
