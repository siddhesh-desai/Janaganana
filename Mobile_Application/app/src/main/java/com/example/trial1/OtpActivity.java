package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtpActivity extends AppCompatActivity {

    private EditText otp;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        otp = findViewById(R.id.otp);
        login = findViewById(R.id.login);

        login.setOnClickListener((v) -> {
            String txt_otp = otp.getText().toString();

            if(TextUtils.isEmpty(txt_otp)){
                Toast.makeText(OtpActivity.this, "Enter the OTP", Toast.LENGTH_SHORT).show();
            }else if (txt_otp.length() == 4){
                startActivity(new Intent(OtpActivity.this, HomeActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            }else{
                Toast.makeText(OtpActivity.this, "Enter valid OTP", Toast.LENGTH_SHORT).show();
            }
        });
    }
}