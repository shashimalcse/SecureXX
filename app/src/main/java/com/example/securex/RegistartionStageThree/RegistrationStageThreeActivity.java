package com.example.securex.RegistartionStageThree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.securex.R;

public class RegistrationStageThreeActivity extends AppCompatActivity implements RegistrationStageThreeActivityMVP.View {

    GridView gridView;
    Button Confirm;
    Button Remove;
    int Size;
    ImageAdapter imageAdapter;
    Intent intent;

    RegistrationStageThreeActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_stage_three);
        gridView = (GridView) findViewById(R.id.gridview);
        Confirm = (Button) findViewById(R.id.fruitsconfirmbtn);
        Remove = (Button) findViewById(R.id.fruitsremovebtn);

        intent = getIntent();

        presenter = new RegistrationStageThreeActivityPresenter(getApplicationContext(),gridView);
        presenter.setView(this);

        setColumns();

        setAdapter();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.gridViewListener(view,position);
            }
        });

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.confirmButtonClicked();
            }
        });

        Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.removeButtonClicked();
            }
        });


    }

    @Override
    public void showSuccess() {
        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setColumns() {

        Size=getSize();

    }

    @Override
    public void setAdapter() {
        imageAdapter = new ImageAdapter(this,Size);
        gridView.setAdapter(imageAdapter);
        presenter.getFruitsArray(imageAdapter);
    }


    @Override
    public String getColor() {
        return intent.getStringExtra("Color");
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void startNextActivity(String Password) {
        Intent i = new Intent(RegistrationStageThreeActivity.this,RegistartionStageThreeConfirmationActivity.class);
        i.putExtra("Username",getUsername());
        i.putExtra("Email",getEmail());
        i.putExtra("Size",getSize());
        i.putExtra("Color",getColor());
        i.putExtra("Password",Password);
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
        return intent.getIntExtra("Size",0);
    }


}
