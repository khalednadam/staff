package com.khaled.staff;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeInfoActivity extends AppCompatActivity {
    TextView name, email, phone, title, gender;
    Button edit_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0D7EF4")));
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Employee Info");
        }

        // Initialize views
        name = findViewById(R.id.text_name);
        email = findViewById(R.id.text_email);
        phone = findViewById(R.id.text_phone);
        gender = findViewById(R.id.text_gender);
        title = findViewById(R.id.text_title);
        edit_btn = findViewById(R.id.edit_btn);

        // Set OnClickListener for edit button
        edit_btn.setOnClickListener(v -> {
            // Create intent to start the edit page
            Intent intent = new Intent(EmployeeInfoActivity.this, EditEmployeeActivity.class);
            // Put employee information as extras
            intent.putExtra("employee_name", name.getText().toString());
            intent.putExtra("employee_email", email.getText().toString());
            intent.putExtra("employee_phone", phone.getText().toString());
            intent.putExtra("employee_gender", gender.getText().toString());
            intent.putExtra("employee_title", title.getText().toString());
            // Start the edit page activity
            startActivity(intent);
        });

        // Retrieve employee information from Intent
        Intent intent = getIntent();
        if (intent != null) {
            String employeeName = intent.getStringExtra("employee_name");
            String employeePhone = intent.getStringExtra("employee_phone");
            String employeeEmail = intent.getStringExtra("employee_email");
            String employeeGender = intent.getStringExtra("employee_gender");
            String employeeTitle = intent.getStringExtra("employee_title");

            // Set employee information to TextViews
            name.setText(employeeName);
            email.setText(employeeEmail);
            phone.setText(employeePhone);
            gender.setText(employeeGender);
            title.setText(employeeTitle);
        }
    }
}
