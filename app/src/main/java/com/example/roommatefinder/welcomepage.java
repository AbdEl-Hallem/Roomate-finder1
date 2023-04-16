package com.example.roommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcomepage extends AppCompatActivity {
    private Button SignUp;
    private Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        SignUp = findViewById(R.id.btnSignUp);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(welcomepage.this , signUp.class);
                startActivity(intent);

            }
        });

       logIn = findViewById(R.id.Login);
       logIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               Intent intent = new Intent(welcomepage.this , SignIn.class);
               startActivity(intent);

           }
       });



    }
}