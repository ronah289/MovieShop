package com.example.movieshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView userDetails = findViewById(R.id.userdetails);

        Intent usernameIntent = getIntent();
        String username = usernameIntent.getStringExtra("username");
        userDetails.setText(String.format("Username: %s", username));
    }
}