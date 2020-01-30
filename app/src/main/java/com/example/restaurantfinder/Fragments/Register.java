package com.example.restaurantfinder.Fragments;

import android.app.Notification;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.restaurantfinder.API.User_API;
import com.example.restaurantfinder.Models.Users;
import com.example.restaurantfinder.Notification.Notification_Channel;
import com.example.restaurantfinder.R;
import com.example.restaurantfinder.Retro_API.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment implements View.OnClickListener {
    private NotificationManagerCompat notificationManagerCompat;

    EditText et_Fname, et_Lname, et_Email, et_Username, et_Password, et_Address, et_Age;
    Button btn_reg;
    User_API user_api;

    public Register() {
        // Required empty public constructor
    }

    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder(getActivity(), Notification_Channel.Channel_1)
                .setSmallIcon(R.drawable.ic_action_user)
                .setContentTitle("Register Successful")
                .setContentText("Registration Successful")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1, notification);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        notificationManagerCompat = NotificationManagerCompat.from(getActivity());
        Notification_Channel channel = new Notification_Channel(getActivity());
        channel.notificationChannel();


        View view = inflater.inflate(R.layout.fragment_register, container, false);
        et_Fname = view.findViewById(R.id.etFirstname);
        et_Lname = view.findViewById(R.id.etLastname);
        et_Email = view.findViewById(R.id.etEmail);
        et_Username = view.findViewById(R.id.etUser);
        et_Password = view.findViewById(R.id.etPass);
        et_Address = view.findViewById(R.id.etAddress);
        et_Age = view.findViewById(R.id.etAge);
        btn_reg = view.findViewById(R.id.btnRegister);
        btn_reg.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegister) {
//            Gson gson = new GsonBuilder()
//                    .setLenient().create();
//            Retrofit retrofit=new Retrofit.Builder()
//                    .baseUrl("http://10.0.2.2:3100/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//            user_api=retrofit.create(User_API.class);

            User_API user_api = API.createinstance().create(User_API.class);

            String fname = et_Fname.getText().toString();
            String lname = et_Lname.getText().toString();
            String email = et_Email.getText().toString();
            String username = et_Fname.getText().toString();
            String password = et_Password.getText().toString();
            String address = et_Address.getText().toString();
            String age = et_Age.getText().toString();

            Users users = new Users(fname, lname, email, username, password, address, age, "User");

            Call<String> register = user_api.register(users);
            register.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_LONG).show();
                    DisplayNotification();

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(getActivity(), "Error" + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
