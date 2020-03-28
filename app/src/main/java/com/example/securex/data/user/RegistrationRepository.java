package com.example.securex.data.user;

public interface RegistrationRepository {

    User getUser();
    void saveUser(User user);
}
