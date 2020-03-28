package com.example.securex.RegistrationStageFour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.securex.R;
import com.goodiebag.pinview.Pinview;

public class RegistrationStageFourConfirmationActivity extends AppCompatActivity implements RegistrationStageFourActivityMVP.View{
    private String Username;
    private String Email;
    private int Size;
    private String Color;
    private String Pin;
    private  String ConfirmPin;

    private static Context instance;


    TextView description;
    Pinview pinview;

    Intent intent;

    RegistrationStageFourActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_stage_four_confirmation);

        description = (TextView) findViewById(R.id.ConfirmDescription);
        pinview = (Pinview) findViewById(R.id.pinview2);

        intent = getIntent();

        instance=this;

        presenter = new RegistrationStageFourActivityPresenter();
        presenter.setView(this);

        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                presenter.pinListener2();
            }
        });
    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void startNextActivity() {

    }

    @Override
    public String getUsername() {
        return intent.getStringExtra("Username");
    }

    @Override
    public String getEmail() {
        return intent.getStringExtra("Email");
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String getColor() {
        return intent.getStringExtra("Color");
    }

    @Override
    public String getPassword() {
        return intent.getStringExtra("Password");
    }

    @Override
    public String getPin() {
        return intent.getStringExtra("Pin");
    }

    @Override
    public String getConfirmPin() {
        return pinview.getValue();
    }

     public static Context getInstance(){
        return instance;
     }
}
