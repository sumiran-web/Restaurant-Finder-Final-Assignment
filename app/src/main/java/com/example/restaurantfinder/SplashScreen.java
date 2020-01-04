package com.example.restaurantfinder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenpublic extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Intent intent = new Intent(SplashScreen.this, MainActivity.class );
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
 {
}
