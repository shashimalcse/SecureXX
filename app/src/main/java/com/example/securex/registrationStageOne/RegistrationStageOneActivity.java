package com.example.securex.registrationStageOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.securex.R;
import com.example.securex.RegistartionStageTwo.RegistrationStageTowActivity;

import javax.inject.Inject;

public class RegistrationStageOneActivity extends AppCompatActivity implements RegistrationStageOneActivityMVP.View {


    RegistrationStageOneActivityMVP.Presenter presenter;

    private EditText Username;
    private EditText Email;
    private Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisatration_stage_one);

        Email = (EditText) findViewById(R.id.registrationEmail);
        Username = (EditText) findViewById(R.id.registrationUsername);
        Submit = (Button) findViewById(R.id.registrationSubmitBtn);

        presenter = new RegistartionStageOneActivityPresenter();
        presenter.setView(this);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.submitButtonClicked();
            }
        });

    }

    @Override
    public String getUsername() {
        return Username.getText().toString();
    }

    @Override
    public String getEmail() {
        return Email.getText().toString();
    }

    @Override
    public void showUsernameError() {
        this.Username.setError("Not valid");
    }

    @Override
    public void showEmailError() {
        this.Email.setError("Not Valid");

    }

    @Override
    public void showSuccess() {
        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
;

    }

    @Override
    public void startNextActivity() {
        Intent intent = new Intent(RegistrationStageOneActivity.this, RegistrationStageTowActivity.class);
        intent.putExtra("Username",getUsername());
        intent.putExtra("Email",getEmail());
        startActivity(intent);

    }
}
