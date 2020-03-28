package com.example.securex.RegistrationStageFour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.securex.R;
import com.example.securex.RegistartionStageThree.RegistartionStageThreeConfirmationActivity;
import com.goodiebag.pinview.Pinview;

public class RegistrationStageFourActivity extends AppCompatActivity implements RegistrationStageFourActivityMVP.View {
    private String Username;
    private String Email;
    private int Size;
    private String Color;
    private String Pin;

    TextView description;
    Pinview pinview;

    Intent intent;

    RegistrationStageFourActivityMVP.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_stage_four);

        description = (TextView) findViewById(R.id.EnterDescription);
        pinview = (Pinview) findViewById(R.id.pinview1);

        intent = getIntent();

        presenter = new RegistrationStageFourActivityPresenter();
        presenter.setView(this);

        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                presenter.pinListener();
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
        Intent i = new Intent(RegistrationStageFourActivity.this, RegistartionStageThreeConfirmationActivity.class);
        i.putExtra("Username",getUsername());
        i.putExtra("Email",getEmail());
        i.putExtra("Size",getSize());
        i.putExtra("Color",getColor());
        i.putExtra("Pin",getPin());
        startActivity(i);

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
        return pinview.getValue();
    }

    @Override
    public String getConfirmPin() {
        return null;
    }
}
