package com.example.securex.data;

public class User {

    private String Username;
    private String Email;
    private String Color;
    private int Pin;
    private String Password;
    private int PasswordSize;

    public User(String Username, String Email, String Color, int Pin, String Password, int PasswordSize) {
        this.Username=Username;
        this.Color=Color;
        this.Email=Email;
        this.Color=Color;
        this.Pin=Pin;
        this.Password=Password;
        this.PasswordSize=PasswordSize;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getColor() {
        return Color;
    }

    public int getPin() {
        return Pin;
    }

    public String getPassword() {
        return Password;
    }

    public int getPasswordSize() {
        return PasswordSize;
    }


}
