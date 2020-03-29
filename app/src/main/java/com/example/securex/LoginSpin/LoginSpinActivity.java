package com.example.securex.LoginSpin;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.securex.LandingActivity;
import com.example.securex.LoginPin.LoginPinActivity;
import com.example.securex.R;
import com.example.securex.data.spins.Spin;

import java.util.concurrent.Executor;

public class LoginSpinActivity extends AppCompatActivity implements  LoginSpinActivityMVP.View{

    ImageView ColorSpin;
    ImageView FruitSpin;
    Button SpinLeftBtn;
    Button SpinRightBtn;
    Button SpinConfirm;
    TextView FruitCount;
    Button FingerPrint;
    Button GoPin;

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    LoginSpinActivityMVP.Presenter presenter;
    @RequiresApi(api = Build.VERSION_CODES.Q)
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
        FingerPrint = (Button) findViewById(R.id.fingerprint);
        GoPin = (Button) findViewById(R.id.gopin);

        presenter = new LoginSpinActivityPresenter();
        presenter.setView(this);
        presenter.setContext(this);
        presenter.setSpins();

       fingerprint();

        FingerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);
            }
        });



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

        GoPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity();
            }
        });


    }

    @Override
    public void showSuccess() {
        Toast t = Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void showError() {
        Toast t = Toast.makeText(getApplicationContext(),"WRONG",Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void startNextActivity() {
        Intent  intent = new Intent(LoginSpinActivity.this, LoginPinActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void startFinishActivity() {
        startActivity(new Intent(LoginSpinActivity.this, LandingActivity.class));
        finish();
    }

    @Override
    public void setSpins(Spin spin) {

        ColorSpin.setImageDrawable(getResources().getDrawable(spin.getColorRing()));

        FruitSpin.setImageDrawable(getResources().getDrawable(spin.getFruitRing()));


    }

    @Override
    public void spinAnimation(RotateAnimation rotateAnimation) {
        ColorSpin.startAnimation(rotateAnimation);
    }

    @Override
    public void setCount(int count) {
        FruitCount.setText(Integer.toString(count));
    }

    @Override
    public void setButtonStatus(Boolean status) {
        SpinConfirm.setEnabled(status);
    }

    void fingerprint(){
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(LoginSpinActivity.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                        "Authentication error: " + errString, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "Authentication succeeded!", Toast.LENGTH_SHORT).show();
                startFinishActivity();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "Authentication failed",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login for my app")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Use account password")
                .build();

    }


}
