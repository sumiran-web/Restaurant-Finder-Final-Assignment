package com.example.restaurantfinder.User_Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantfinder.Adapters.Restaurant_List_Adapter;
import com.example.restaurantfinder.BLL.RestaurantBLL;
import com.example.restaurantfinder.R;

public class Restaurant_list extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        recyclerView= findViewById(R.id.restaurant_recycler_view);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        getRestaurants();
    }

    private void getRestaurants() {
        RestaurantBLL bll = new RestaurantBLL();
        bll.setToken(getSharedPreferences("storetoken", 0).getString("token", ""));
        Restaurant_List_Adapter adapter = new Restaurant_List_Adapter(Restaurant_list.this, bll.getRestaurant());
        recyclerView.setAdapter(adapter);
    }
}