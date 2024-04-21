package com.example.registrationformassignment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.registrationformassignment.Student;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RetrieveActivity extends AppCompatActivity {

    private TextView txtDetails;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        txtDetails = findViewById(R.id.txtDetails);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        String srn = getIntent().getStringExtra("srn");

        databaseReference.child(srn).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Student student = snapshot.getValue(Student.class);
                    if (student != null) {
                        String details = "SRN: " + student.getSrn() + "\n"
                                + "Name: " + student.getName() + "\n"
                                + "Sex: " + student.getSex() + "\n"
                                + "Pincode: " + student.getPincode() + "\n"
                                + "Email: " + student.getEmail() + "\n"
                                + "Phone: " + student.getPhone();

                        txtDetails.setText(details);
                    }
                } else {
                    txtDetails.setText("No student found with this SRN");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                txtDetails.setText("Error retrieving data");
            }
        });
    }
}
