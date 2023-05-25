package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Explode;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button login_btn;
    private EditText aadhar_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        aadhar_no = findViewById(R.id.aadhar);
        login_btn = findViewById(R.id.login);
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//        getWindow().setExitTransition(new Explode());

        login_btn.setOnClickListener((v) -> {
            String txt_aadhar = aadhar_no.getText().toString();

            if (TextUtils.isEmpty(txt_aadhar)){
                Toast.makeText(LoginActivity.this, "Enter Aadhar Number", Toast.LENGTH_SHORT).show();
            } else if (txt_aadhar.length() == 12){
                Toast.makeText(LoginActivity.this, "Enter Valid Aadhar Number", Toast.LENGTH_SHORT).show();
            } else{
                startActivity(new Intent(LoginActivity.this, OtpActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                finish();
            }
        }
        );

    }
}