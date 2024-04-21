package com.khaled.staff;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EditEmployeeActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView selectedImageView;
    TextInputEditText name, email, phone;
    AutoCompleteTextView gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);
        Intent intent = getIntent();
        if (intent != null) {
            String employeeId = intent.getStringExtra("employee_id");
            String employeeName = intent.getStringExtra("employee_name");
            String employeePhone = intent.getStringExtra("employee_phone");
            String employeeEmail = intent.getStringExtra("employee_email");
            String employeeGender = intent.getStringExtra("employee_gender");
            // Retrieve more extra data as needed
            // Use the employeeId to fetch the employee information from your data source
            name = findViewById(R.id.edit_name);
            email = findViewById(R.id.edit_email);
            phone = findViewById(R.id.edit_phone);
            gender = findViewById(R.id.edit_gender);

            name.setText(employeeName);
            email.setText(employeeEmail);
            phone.setText(employeePhone);
            gender.setText(employeeGender);

        }


        // Initialize ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0D7EF4")));
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Edit employee");
        }

        Button selectImageButton = findViewById(R.id.select_image_btn);
        selectedImageView = findViewById(R.id.selected_image_view);
        TextInputLayout genderLayout = findViewById(R.id.gender_layout);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) genderLayout.getEditText();

        String[] genderOptions = {"Male", "Female"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, genderOptions);

        assert autoCompleteTextView != null;
        autoCompleteTextView.setAdapter(adapter);
        selectImageButton.setOnClickListener(v -> {
            Intent pickImageIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickImageIntent, PICK_IMAGE_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();

            selectedImageView.setImageURI(imageUri);
        }
    }
}
