package com.example.restaurantfinder.API;

import com.example.restaurantfinder.Models.Restaurants;
import com.example.restaurantfinder.Models.Reviews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface Restaurant_API {

    @GET("restaurants/showrestaurent")
    Call<List<Restaurants>> getRestaurant(@Header("Authorization")String token);

    @GET("restaurants/comment/{id}")
    Call<List<Reviews>> getReview(@Path("id")String id);

}
