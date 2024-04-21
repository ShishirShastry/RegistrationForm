package com.example.registrationformassignment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText srnEditText, nameEditText, pincodeEditText, emailEditText, phoneEditText;
    private Spinner sexSpinner;
    private Button registerButton;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        // Initialize Views
        srnEditText = findViewById(R.id.srnEditText);
        nameEditText = findViewById(R.id.nameEditText);
        pincodeEditText = findViewById(R.id.pincodeEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        sexSpinner = findViewById(R.id.sexSpinner);
        registerButton = findViewById(R.id.registerButton);

        // Set up Sex Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sex_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexSpinner.setAdapter(adapter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerStudent();
            }
        });
    }

    private void registerStudent() {
        String srn = srnEditText.getText().toString().trim();
        String name = nameEditText.getText().toString().trim();
        String pincode = pincodeEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String sex = sexSpinner.getSelectedItem().toString();

        if (TextUtils.isEmpty(srn) || TextUtils.isEmpty(name) || TextUtils.isEmpty(pincode)
                || TextUtils.isEmpty(email) || TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;


        }

        // Validation for email and phone can be added similarly

        // Create Student object
        Student student = new Student(srn, name, sex, pincode, email, phone);

        // Save to Firebase
        databaseReference.child(srn).setValue(student);

        Toast.makeText(this, "Student registered successfully", Toast.LENGTH_SHORT).show();

        // Clear EditTexts
        srnEditText.setText("");
        nameEditText.setText("");
        pincodeEditText.setText("");
        emailEditText.setText("");
        phoneEditText.setText("");
    }
}
