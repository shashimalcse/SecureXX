package com.example.securex.RegistartionStageTwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.securex.R;
import com.example.securex.RegistartionStageThree.RegistrationStageThreeActivity;

public class RegistrationStageTowActivity extends AppCompatActivity implements RegistrationStageTowActivityMVP.View , AdapterView.OnItemSelectedListener{

    RegistrationStageTowActivityMVP.Presenter presenter;

    Spinner Color;
    Spinner Size;
    Button Submit;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_stage_tow);

        Size = (Spinner) findViewById(R.id.spinner);
        Color= (Spinner) findViewById(R.id.spinner2);
        Submit =(Button) findViewById(R.id.StageTwoSubmit);

        presenter = new RegistrationStageTowActivityPresenter();
        presenter.setView(this);
        presenter.setSize();

        intent = getIntent();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.submitButtonClicked();
            }
        });

        Size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("POSITION", Integer.toString(position));
                if (position==0){
                    presenter.setColors(4);
                }
                else if(position==1){
                    presenter.setColors(6);
                }
                else if (position==2){
                    presenter.setColors(8);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public int getSize() {
        Log.d("SIZE",Size.getSelectedItem().toString());
        return Integer.parseInt(Size.getSelectedItem().toString());
    }

    @Override
    public void setSize() {
        String[] size = new String[]{"4","6","8"};
        ArrayAdapter sizeAd = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,size);
        Size.setAdapter(sizeAd);
    }

    @Override
    public String getColor() {
        return Color.getSelectedItem().toString();
    }

    @Override
    public void setColor(String[] Colors) {
        ArrayAdapter colorAd = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,Colors);
        Color.setAdapter(colorAd);
    }


    @Override
    public void showSuccess() {
        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RegistrationStageTowActivity.this, RegistrationStageThreeActivity.class));
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startNextActivity() {
        intent.putExtra("Size",getSize());
        intent.putExtra("Color",getColor());
        startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
