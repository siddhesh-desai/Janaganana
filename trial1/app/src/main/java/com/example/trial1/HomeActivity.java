package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button addmemberbtn1;
    private Button addmemberbtn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addmemberbtn1 = findViewById(R.id.box_add_btn);
        addmemberbtn2 = findViewById(R.id.add_btn);

        addmemberbtn1.setOnClickListener((v) -> {
            startActivity(new Intent(HomeActivity.this, PersonaldetailsActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        });

        addmemberbtn2.setOnClickListener((v) -> {
            startActivity(new Intent(HomeActivity.this, PersonaldetailsActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        });
    }
}