package com.example.securex.RegistartionStageThree;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.securex.R;

import java.util.ArrayList;


public class RegistrationStageThreeActivityPresenter implements RegistrationStageThreeActivityMVP.Presenter {

    private RegistrationStageThreeActivityMVP.View view;
    ImageAdapter imageAdapter;
    ArrayList<Integer> FruitsArray;
    ArrayList<Integer> SelectedPositions;
    int Size;
    String SelectedColor;
    private String Password;
    Context context;
    GridView gridView;
    private String ConfirmPassword;

    public RegistrationStageThreeActivityPresenter(Context context,GridView gridView) {
        SelectedPositions = new ArrayList<>();
        this.context=context;
        this.gridView= gridView;


    }

    @Override
    public void setView(RegistrationStageThreeActivityMVP.View view) {
        this.view=view;

    }

    @Override
    public void confirmButtonClicked() {

        Password = "";
        int PasswordSize = SelectedPositions.size();
        for(int i=0;i<SelectedPositions.size();i++){

            Password+=context.getResources().getResourceEntryName(FruitsArray.get(SelectedPositions.get(i)));

        }
        if (!Password.equals("")){
            view.showSuccess();
            view.startNextActivity(Password);
            Log.d("ACTIVITY","Done");
        }




    }

    @Override
    public void removeButtonClicked() {

        if(SelectedPositions.size()>0) {
            int end = SelectedPositions.size() - 1;
            View v = gridView.getChildAt(SelectedPositions.get(SelectedPositions.size()-1));
            SelectedPositions.remove(SelectedPositions.get(SelectedPositions.size() - 1));

            Log.d("s", SelectedPositions.toString());


            v.setBackgroundColor(Color.WHITE);

            Log.d("s", SelectedPositions.toString());
        }

    }


    @Override
    public void gridViewListener(View view, int position) {
        try {
            if(!SelectedPositions.contains(position)){
                view.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));
                Log.d("s",Integer.toString(position));
                SelectedPositions.add(position);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void getFruitsArray(ImageAdapter imageAdapter) {
        FruitsArray = imageAdapter.getImageID();
    }

    @Override
    public void confirm2ButtonClicked() {

        ConfirmPassword = "";
        int PasswordSize = SelectedPositions.size();
        for(int i=0;i<SelectedPositions.size();i++){

            ConfirmPassword+=context.getResources().getResourceEntryName(FruitsArray.get(SelectedPositions.get(i)));

        }
        if(!ConfirmPassword.equals("")){
            if(ConfirmPassword.equals(view.getPassword())){
                view.showSuccess();
                view.startNextActivity(ConfirmPassword);
            }
            else {
                view.showError();;
            }
        }
        else view.showError();

    }

}

