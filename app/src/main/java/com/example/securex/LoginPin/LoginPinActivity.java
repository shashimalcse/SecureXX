package com.example.securex.LoginPin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.securex.LandingActivity;
import com.example.securex.R;
import com.goodiebag.pinview.Pinview;

public class LoginPinActivity extends AppCompatActivity implements LoginPinActivityMVP.View {
    private Pinview pinView;

    LoginPinActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pin);

        pinView = (Pinview) findViewById(R.id.PinUnlock);
        presenter = new LoginPinActivityPresenter(this);
        presenter.setView(this);

        pinView.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                presenter.pinListener();
            }
        });

    }

    @Override
    public void showSuccess() {
        Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(),"WRONG",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void startNextActivity() {
        startActivity(new Intent(LoginPinActivity.this, LandingActivity.class));
        finish();

    }

    @Override
    public String getPin() {
        return pinView.getValue();
    }

    @Override
    public void clearPin() {
        pinView.clearValue();
    }
}
