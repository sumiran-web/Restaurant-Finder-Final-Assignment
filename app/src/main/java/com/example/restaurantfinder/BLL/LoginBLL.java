package com.example.restaurantfinder.BLL;

import java.io.IOException;

import retrofit2.Response;

public class LoginBLL {
    private String username;
    private String password;
    private Token_Generate token_generate;
    boolean isSuccess = false;

    public LoginBLL(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public boolean checkUser() {
        try {
            StrictMode();
            Response<Token_Generate> response = API.createinstance().create(User_API.class).login(username, password).execute();
            if (response.isSuccessful()) {
                this.token_generate = response.body();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

}
