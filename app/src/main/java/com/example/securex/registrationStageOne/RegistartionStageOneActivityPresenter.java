package com.example.securex.registrationStageOne;

import android.util.Patterns;

public class RegistartionStageOneActivityPresenter implements RegistrationStageOneActivityMVP.Presenter {

    private RegistrationStageOneActivityMVP.View view;

    private final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";


    @Override
    public void setView(RegistrationStageOneActivityMVP.View view) {
        this.view=view;
    }

    @Override
    public void submitButtonClicked() {

        if(view!=null){
            String Username = view.getUsername();
            String Email = view.getEmail();
            String Validation = Validation(Username,Email);

            if(Validation.equals("valid")){
                view.showSuccess();
            }
            else if(Validation.equals("not valid")){
                view.showEmailError();
                view.showUsernameError();
            }
            else if (Validation.equals("Username not valid")){
                view.showUsernameError();
            }
            else if (Validation.equals("Email not valid")){
                view.showEmailError();
            }
            else {
                view.showEmailError();
                view.showUsernameError();
            }
        }


    }


    @Override
    public String Validation(String Username, String Email) {
        String validateState;

        if (isValidEmail(Email) && isValidUsername(Username)) {
            validateState="valid";
        }

        else if (!isValidUsername(Username) && !isValidEmail(Email)) {
            validateState="not valid";
        }
        else if(!isValidUsername(Username)){
            validateState="Username not valid";
        }
        else if(!isValidEmail(Email)){
            validateState="Email not valid";
        }
        else {
            validateState="not valid";
        }

        return validateState;
    }



    public boolean isValidEmail(String email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.length()>0);
    }
    public boolean isValidUsername(String username){
        return (username.matches(USERNAME_PATTERN) && username.length()>=6);
    }

}
