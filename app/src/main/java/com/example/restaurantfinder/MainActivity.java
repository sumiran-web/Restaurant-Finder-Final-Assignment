package com.example.restaurantfinder;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.restaurantfinder.Adapters.ViewpageAdapter;
import com.example.restaurantfinder.Fragments.Login;
import com.example.restaurantfinder.Fragments.Register;
import com.google.android.material.tabs.TabLayout;

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

