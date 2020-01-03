package com.example.restaurantfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.restaurantfinder.Fragments.LoginFragment;
import com.example.restaurantfinder.Fragments.Register;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        tabLayout=findViewById(R.id.Tablayout);
        viewPager=findViewById(R.id.Viewpager);

        ViewpageAdapter adapter = new ViewpageAdapter(getSupportFragmentManager());

        adapter.addFragment(new Login(),"Login");
     adapter.addFragment(new Register(),"Register");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

