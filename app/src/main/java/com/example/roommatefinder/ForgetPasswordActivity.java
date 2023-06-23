package com.example.roommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        EditText emailEditText = findViewById(R.id.Email);
        Button resetPasswordButton = findViewById(R.id.sendBtn);


        resetPasswordButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            if (email.isEmpty()) {
                emailEditText.setError("Email is required!");
            }else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(
                        email
                ).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(ForgetPasswordActivity.this, "Check your email to reset your password!", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(ForgetPasswordActivity.this, "Try again! Something wrong happened!", Toast.LENGTH_LONG).show();
                    }
                    finish();
                }
                );
            }
        });


    }
}