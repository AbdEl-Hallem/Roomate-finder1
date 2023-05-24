package com.example.roommatefinder;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class signUp extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    FirebaseAuth mAuth;
    Button btnRegister;
    EditText Email ;
     EditText Password;
    CallbackManager callbackManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



















        mAuth = FirebaseAuth.getInstance();
         callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
                FirebaseAuth.getInstance().signInWithCredential(credential);
                        Toast.makeText(signUp.this,
                                "signed up successfuly", Toast.LENGTH_LONG).show();

                    }



            @Override
            public void onCancel() {
                // Handle login cancellation
            }

            @Override
            public void onError(FacebookException error) {
                // Handle login error
            }
        });




        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.password2);

        btnRegister = findViewById(R.id.Register1);

        btnRegister.setOnClickListener(view ->{

            createUser();
        });

        Button fb_btn = findViewById(R.id.login_button);
        fb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LoginManager.getInstance().logInWithReadPermissions(signUp.this, Arrays.asList("public_profile"));

            }
        });







    }
    private boolean isValidPassword(String password) {
        /*
         * Password must meet the following criteria:
         * - At least 8 characters long
         * - Contains at least one uppercase letter
         * - Contains at least one lowercase letter
         * - Contains at least one digit
         */
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        return password.matches(passwordPattern);
    }


    private void createUser(){
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if (!isValidPassword(password)) {
            Password.setError("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit.");
            return;
        }

        if (TextUtils.isEmpty(email)){
            Email.setError("Email cannot be empty");
            Email.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            Password.setError("Password cannot be empty");
            Password.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(signUp.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signUp.this, SignIn.class));
                    }else{
                        Toast.makeText(signUp.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
}






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }






}
