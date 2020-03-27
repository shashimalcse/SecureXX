package com.example.securex.RegistartionStageThree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.securex.R;

public class RegistartionStageThreeConfirmationActivity extends AppCompatActivity implements RegistrationStageThreeActivityMVP.View {

    GridView gridView;
    Button Confirm;
    Button Remove;
    int Size;
    ImageAdapter imageAdapter;

    RegistrationStageThreeActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registartion_stage_three_confirmation);

        gridView = (GridView) findViewById(R.id.gridview2);
        Confirm = (Button) findViewById(R.id.fruitsconfirmbtn2);
        Remove = (Button) findViewById(R.id.fruitsremovebtn2);

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

                presenter.confirm2ButtonClicked();
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

    }

    @Override
    public void setColumns() {

        Size=4;

    }

    @Override
    public void setAdapter() {
        imageAdapter = new ImageAdapter(this,Size);
        gridView.setAdapter(imageAdapter);
        presenter.getFruitsArray(imageAdapter);
    }

}
