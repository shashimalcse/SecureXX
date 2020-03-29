package com.example.securex.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.securex.R;
import com.example.securex.data.spins.Spin;

public class LoginSpinActivity extends AppCompatActivity implements  LoginSpinActivityMVP.View{

    ImageView ColorSpin;
    ImageView FruitSpin;
    Button SpinLeftBtn;
    Button SpinRightBtn;
    Button SpinConfirm;
    TextView FruitCount;


    LoginSpinActivityMVP.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_spin);

        ColorSpin = (ImageView) findViewById(R.id.colorspin);
        FruitSpin = (ImageView) findViewById(R.id.fruitspin);
        SpinLeftBtn = (Button) findViewById(R.id.leftspinbtn);
        SpinRightBtn = (Button) findViewById(R.id.rightspinbtn);
        SpinConfirm = (Button) findViewById(R.id.spinconfirm);
        FruitCount = (TextView) findViewById(R.id.fruitcount);

        presenter = new LoginSpinActivityPresenter();
        presenter.setView(this);
        presenter.setSpins();

        SpinRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.rightButtonClicked();
            }
        });

        SpinLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.leftButtonClicked();
            }
        });

        SpinConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.confirmButtonClicked();
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
    public void setSpins(Spin spin) {

        ColorSpin.setImageDrawable(getResources().getDrawable(spin.getColorRing()));

        FruitSpin.setImageDrawable(getResources().getDrawable(spin.getFruitRing()));


    }


}
