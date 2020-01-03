package com.example.restaurantfinder.User_Activities;

import android.os.Bundle;

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