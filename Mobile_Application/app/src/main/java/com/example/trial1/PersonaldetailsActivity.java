package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PersonaldetailsActivity extends AppCompatActivity {
    private Spinner spinnerGender;
    private Spinner spinnerRelation;
    private Spinner spinnerMarital;
    private EditText dob;
    private int dob_year;
    private int dob_month;
    private int dob_day;
    private Button save_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldetails);

        spinnerGender = findViewById(R.id.spinnerGender);
        spinnerRelation = findViewById(R.id.spinnerRelation);
        spinnerMarital = findViewById(R.id.spinnerMarital);

        dob = findViewById(R.id.dob);

        save_btn = findViewById(R.id.saveBtn1);

        String[] genders = getResources().getStringArray(R.array.gender);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerGender.setAdapter(adapter);

        String[] relations = getResources().getStringArray(R.array.relation);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,relations);
        spinnerRelation.setAdapter(adapter1);

        String[] maritals = getResources().getStringArray(R.array.marital);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,maritals);
        spinnerMarital.setAdapter(adapter2);

        Calendar calendar = Calendar.getInstance();

        dob.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dob_year = calendar.get(Calendar.YEAR);
                dob_month = calendar.get(Calendar.MONTH);
                dob_day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(PersonaldetailsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dob.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                }, dob_year, dob_month, dob_day);
                datePickerDialog.show();
            }
        });

        save_btn.setOnClickListener((v) -> {
            startActivity(new Intent(PersonaldetailsActivity.this, AddressdetailsActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        });
    }
}