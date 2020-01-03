package com.example.restaurantfinder.User_Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;




public class Restaurant_info extends AppCompatActivity  {
    TextView textView_rest_name,textView_rest_contact,textView_rest_type,textView_rest_desc,textView_latitude,textView_longitude;
    ImageView iv_logo;
    SharedPreferences preferences;
    public MapView mapView;
    private RecyclerView recyclerView;
    private List<Reviews> commentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.eyJ1IjoiYmluYXkwMDEyMyIsImEiOiJjanh3dW5oMWMwNG4xM25tdXBhZ2oyczRuIn0.tVXWbvSvD7WoEBgICQZFtA");
        setContentView(R.layout.activity_restaurant_info);

        recyclerView = findViewById(R.id.comment_recycler);

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                float   longtitude= Float.parseFloat( Restaurant_List_Adapter.Log);
                float latitude= Float.parseFloat( Restaurant_List_Adapter.Lat);
//                latitude= Restaurant_List_Adapter.Lat;
                MarkerOptions options = new MarkerOptions();
                options.title("Restaurant Location");
                options.position(new LatLng(latitude,longtitude));
                mapboxMap.addMarker(options);
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                    }

                });
            }
        }) ;



        textView_rest_name = findViewById(R.id.tv_restaurant_name);
        textView_rest_contact=findViewById(R.id.tv_number);
        textView_rest_type=findViewById(R.id.tv_restaurant_type);
        textView_rest_desc=findViewById(R.id.tv_description);
        textView_latitude=findViewById(R.id.tv_latitude);
        textView_longitude=findViewById(R.id.tv_longitude);
        iv_logo=findViewById(R.id.img_logo);

        preferences = getApplicationContext().getSharedPreferences("Restaurant_info", Context.MODE_PRIVATE);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String image = API.BASE_URL+"logo/"+ bundle.getString("Restaurantlogo");
            Picasso.get().load(image).into(iv_logo);
            textView_rest_name.setText("Restaurant Name: " +bundle.getString("Restaurantname"));
            textView_rest_type.setText("Restaurant Type: " +bundle.getString("Restauranttype"));
            textView_rest_contact.setText("Restaurant Contact: " +bundle.getString("Restaurantcontact"));
            textView_rest_desc.setText("Restaurant Description: " +bundle.getString("Restaurantdesc"));
            textView_latitude.setText("Latitude: " +bundle.getString("Latitude"));
            textView_longitude.setText("Longitude: " +bundle.getString("Longitude"));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getComment();
    } {
}