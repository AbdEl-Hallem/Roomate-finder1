package com.example.roommatefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;

public class profile_screen extends AppCompatActivity {
    String name;


    ArrayList<projectModel> recycleList;

    ImageView add_photo;
    TextView edit_text_last_name_fill_information , edit_text_gender_fill_information ,
    edit_text_phone_number_fill_information , edit_text_birth_date_fill_information , edit_text_national_id_fill_information ;
    Uri ImageUri;
    Button btn_upload_profiledata;
    private FirebaseDatabase database;
    private FirebaseStorage firebaseStorage;
    FirebaseDatabase firebaseDatabase ;
    EditText edit_text_first_name_fill_information;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);


        Button culture_button = findViewById(R.id.culture_button);
        culture_button.setOnClickListener(new View.OnClickListener() {

            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
//                    final StorageReference reference = firebaseStorage.getReference().child("profile data").child(System.currentTimeMillis() + "");
//
//                    reference.putFile(ImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                                @Override
//                                public void onSuccess(Uri uri) {
//                                    projectModel model = new projectModel();
//
//                                    // Set other model properties here
////                                    model.setCulture_button(culture_button.getText().toString());
//
//                                    database.getReference().child("profile data").push().setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                        @Override
//                                        public void onSuccess(Void unused) {
//                                            Toast.makeText(profile_screen.this, "data uploaded successfully", Toast.LENGTH_SHORT).show();
//                                        }
//                                    }).addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//
//                                        }
//                                        // Handle upload failure here
//                                    });
//                                }
//                            });
//                        }
//                    });

                    culture_button.setTextColor(Color.WHITE);
                    culture_button.setBackgroundResource(R.drawable.interests_button_after_bg);

                }
                else {
//                    projectModel model = new projectModel();
//
//                    model.setCulture_button(null);



                    culture_button.setTextColor(getResources().getColor(R.color.default_button));
                    culture_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });

        Button learning_button = findViewById(R.id.learning_button);
        learning_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    learning_button.setTextColor(Color.WHITE);
                    learning_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    learning_button.setTextColor(getResources().getColor(R.color.default_button));
                    learning_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });



        Button sports_button = findViewById(R.id.sports_button);
        sports_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    sports_button.setTextColor(Color.WHITE);
                    sports_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    sports_button.setTextColor(getResources().getColor(R.color.default_button));
                    sports_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button skating_button = findViewById(R.id.skating_button);
        skating_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    skating_button.setTextColor(Color.WHITE);
                    skating_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    skating_button.setTextColor(getResources().getColor(R.color.default_button));
                    skating_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button studying_button = findViewById(R.id.studying_button);
        studying_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    studying_button.setTextColor(Color.WHITE);
                    studying_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    studying_button.setTextColor(getResources().getColor(R.color.default_button));
                    studying_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button foodie_button = findViewById(R.id.foodie_button);
        foodie_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    foodie_button.setTextColor(Color.WHITE);
                    foodie_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    foodie_button.setTextColor(getResources().getColor(R.color.default_button));
                    foodie_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button cleaning_button = findViewById(R.id.cleaning_button);
        cleaning_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    cleaning_button.setTextColor(Color.WHITE);
                    cleaning_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    cleaning_button.setTextColor(getResources().getColor(R.color.default_button));
                    cleaning_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });



        Button it_button = findViewById(R.id.it_button);
        it_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    it_button.setTextColor(Color.WHITE);
                    it_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    it_button.setTextColor(getResources().getColor(R.color.default_button));
                    it_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button nightsout_button = findViewById(R.id.nightsout_button);
        nightsout_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    nightsout_button.setTextColor(Color.WHITE);
                    nightsout_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    nightsout_button.setTextColor(getResources().getColor(R.color.default_button));
                    nightsout_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });


        Button gardening_button = findViewById(R.id.gardening_button);
        gardening_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    gardening_button.setTextColor(Color.WHITE);
                    gardening_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    gardening_button.setTextColor(getResources().getColor(R.color.default_button));
                    gardening_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button smoking_button = findViewById(R.id.smoking_button);
        smoking_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    smoking_button.setTextColor(Color.WHITE);
                    smoking_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    smoking_button.setTextColor(getResources().getColor(R.color.default_button));
                    smoking_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button music_button = findViewById(R.id.music_button);
        music_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    music_button.setTextColor(Color.WHITE);
                    music_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    music_button.setTextColor(getResources().getColor(R.color.default_button));
                    music_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button cooking_button = findViewById(R.id.cooking_button);
        cooking_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    cooking_button.setTextColor(Color.WHITE);
                    cooking_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    cooking_button.setTextColor(getResources().getColor(R.color.default_button));
                    cooking_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button vegan_button = findViewById(R.id.vegan_button);
        vegan_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    vegan_button.setTextColor(Color.WHITE);
                    vegan_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    vegan_button.setTextColor(getResources().getColor(R.color.default_button));
                    vegan_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button art_button = findViewById(R.id.art_button);
        art_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    art_button.setTextColor(Color.WHITE);
                    art_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    art_button.setTextColor(getResources().getColor(R.color.default_button));
                    art_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button football_button = findViewById(R.id.football_button);
        football_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    football_button.setTextColor(Color.WHITE);
                    football_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    football_button.setTextColor(getResources().getColor(R.color.default_button));
                    football_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button chilling_button = findViewById(R.id.chilling_button);
        chilling_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    chilling_button.setTextColor(Color.WHITE);
                    chilling_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    chilling_button.setTextColor(getResources().getColor(R.color.default_button));
                    chilling_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button charity_button = findViewById(R.id.charity_button);
        charity_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    charity_button.setTextColor(Color.WHITE);
                    charity_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    charity_button.setTextColor(getResources().getColor(R.color.default_button));
                    charity_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button stayhome_button = findViewById(R.id.stayhome_button);
        stayhome_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    stayhome_button.setTextColor(Color.WHITE);
                    stayhome_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    stayhome_button.setTextColor(getResources().getColor(R.color.default_button));
                    stayhome_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button history_button = findViewById(R.id.history_button);
        history_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    history_button.setTextColor(Color.WHITE);
                    history_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    history_button.setTextColor(getResources().getColor(R.color.default_button));
                    history_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button fun_button = findViewById(R.id.fun_button);
        fun_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    fun_button.setTextColor(Color.WHITE);
                    fun_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    fun_button.setTextColor(getResources().getColor(R.color.default_button));
                    fun_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button party_button = findViewById(R.id.party_button);
        party_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    party_button.setTextColor(Color.WHITE);
                    party_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    party_button.setTextColor(getResources().getColor(R.color.default_button));
                    party_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button gamer_button = findViewById(R.id.gamer_button);
        gamer_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    gamer_button.setTextColor(Color.WHITE);
                    gamer_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    gamer_button.setTextColor(getResources().getColor(R.color.default_button));
                    gamer_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button petlover_button = findViewById(R.id.petlover_button);
        petlover_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    petlover_button.setTextColor(Color.WHITE);
                    petlover_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    petlover_button.setTextColor(getResources().getColor(R.color.default_button));
                    petlover_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button shopping_button = findViewById(R.id.shopping_button);
        shopping_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    shopping_button.setTextColor(Color.WHITE);
                    shopping_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    shopping_button.setTextColor(getResources().getColor(R.color.default_button));
                    shopping_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button reading_button = findViewById(R.id.reading_button);
        reading_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    reading_button.setTextColor(Color.WHITE);
                    reading_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    reading_button.setTextColor(getResources().getColor(R.color.default_button));
                    reading_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button fashion_button = findViewById(R.id.fashion_button);
        fashion_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    fashion_button.setTextColor(Color.WHITE);
                    fashion_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    fashion_button.setTextColor(getResources().getColor(R.color.default_button));
                    fashion_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button memes_button = findViewById(R.id.memes_button);
        memes_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    memes_button.setTextColor(Color.WHITE);
                    memes_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    memes_button.setTextColor(getResources().getColor(R.color.default_button));
                    memes_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button films_button = findViewById(R.id.films_button);
        films_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    films_button.setTextColor(Color.WHITE);
                    films_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    films_button.setTextColor(getResources().getColor(R.color.default_button));
                    films_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });
        Button faith_button = findViewById(R.id.faith_button);
        faith_button.setOnClickListener(new View.OnClickListener() {
            boolean isPressed = false;
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                if (isPressed) {
                    faith_button.setTextColor(Color.WHITE);
                    faith_button.setBackgroundResource(R.drawable.interests_button_after_bg);
                }
                else {

                    faith_button.setTextColor(getResources().getColor(R.color.default_button));
                    faith_button.setBackgroundResource(R.drawable.intersts_button_before_bg);

                }

            }
        });








































        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recycleList , getApplicationContext());

        add_photo = findViewById(R.id.add_photo);
        database = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        btn_upload_profiledata = findViewById(R.id.btn_upload_profiledata);
        edit_text_first_name_fill_information = findViewById(R.id.edit_text_first_name_fill_information);
        edit_text_last_name_fill_information = findViewById(R.id.edit_text_last_name_fill_information);
        edit_text_gender_fill_information = findViewById(R.id.edit_text_gender_fill_information);
        edit_text_phone_number_fill_information = findViewById(R.id.edit_text_phone_number_fill_information);
        edit_text_birth_date_fill_information = findViewById(R.id.edit_text_birth_date_fill_information);
        edit_text_national_id_fill_information = findViewById(R.id.edit_text_national_id_fill_information);






        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String firstName = edit_text_first_name_fill_information.getText().toString();
        editor.putString("first_name", firstName);
        editor.apply();


//
//        String first_name = edit_text_first_name_fill_information.getText().toString().trim();
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("profile data");
//
//        Query query = reference.orderByChild("edit_text_first_name_fill_information");
//
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                projectModel model = new projectModel();
////                String username = snapshot.child(first_name).child("edit_text_first_name_fill_information").getValue(String.class);
//                Intent intent = new Intent();
////                intent.putExtra("username", username);
//                                intent.putExtra("first_name" , model.getEdit_text_first_name_fill_information());
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//




//        firebaseDatabase.getReference().child("house").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//
//                    projectModel model = dataSnapshot.getValue(projectModel.class);
//
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });




        add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UploadImage();
            }
        });


        btn_upload_profiledata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile_screen.this , home_page.class );


//                name = edit_text_first_name_fill_information.getText().toString().trim();
//                intent.putExtra("key" , name);
//
                startActivity(intent);


//                edit_text_first_name_fill_information.setText(getIntent().getStringExtra("edit_text_first_name_fill_information"));








                recycleList = new ArrayList<>();








//                database.getReference().child("profile data").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            // Data exists in Firebase, retrieve it and display it in a TextView
//                            projectModel model = snapshot.getValue(projectModel.class);
//                         model.setEdit_text_first_name_fill_information(edit_text_first_name_fill_information.getText().toString());
//                        } else {
//                            // Data does not exist in Firebase, show an error message
//                            Toast.makeText(profile_screen.this, "Static data not found", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        Toast.makeText(profile_screen.this, "Error occurred: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//
//





















//                final StorageReference reference = firebaseStorage.getReference().child("house");
//
//                reference.putFile(ImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                projectModel model = new projectModel();
//                                model.setEdit_text_first_name_fill_information(edit_text_first_name_fill_information.getText().toString());
////                                 Set other fields as needed
//
//                                Query query = database.getReference().child("house")
//                                        .orderByChild("edit_text_first_name_fill_information")
//                                        .equalTo(edit_text_first_name_fill_information.getText().toString());
//
//                                query.addListenerForSingleValueEvent(new ValueEventListener() {
//                                    @Override
//                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                        if (snapshot.exists()) {
//                                            // Data already exists in Firebase, do not add new item to RecyclerView
//                                            Toast.makeText(profile_screen.this, "Data already exists", Toast.LENGTH_SHORT).show();
//                                        } else {
//                                            // Data does not exist in Firebase, add new item to RecyclerView
//                                            database.getReference().child("house").push().setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                                @Override
//                                                public void onSuccess(Void unused) {
//                                                    Toast.makeText(profile_screen.this, "Data added successfully", Toast.LENGTH_SHORT).show();
//                                                }
//                                            }).addOnFailureListener(new OnFailureListener() {
//                                                @Override
//                                                public void onFailure(@NonNull Exception e) {
//                                                    Toast.makeText(profile_screen.this, "Failed to add data", Toast.LENGTH_SHORT).show();
//                                                }
//                                            });
//                                        }
//                                    }
//
//                                    @Override
//                                    public void onCancelled(@NonNull DatabaseError error) {
//                                        Toast.makeText(profile_screen.this, "Error occurred: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                            }
//                        });
//                    }
//                });






                final StorageReference reference = firebaseStorage.getReference().child("profile data");

                reference.putFile(ImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                projectModel model = new projectModel();
                                model.setAdd_photo(uri.toString());
                                model.setEdit_text_first_name_fill_information(edit_text_first_name_fill_information.getText().toString());
                                model.setEdit_text_last_name_fill_information(edit_text_last_name_fill_information.getText().toString());
                                model.setEdit_text_gender_fill_information(edit_text_gender_fill_information.getText().toString());
                                model.setEdit_text_birth_date_fill_information(edit_text_birth_date_fill_information.getText().toString());
                                model.setEdit_text_phone_number_fill_information(edit_text_phone_number_fill_information.getText().toString());
                                model.setEdit_text_national_id_fill_information(edit_text_national_id_fill_information.getText().toString());
                                boolean isPressed = false;
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setCulture_button(culture_button.getText().toString());


                                }
                                else {

                                    model.setCulture_button(null);


                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setArt_button(art_button.getText().toString());


                                }
                                else {

                                    model.setArt_button(null);


                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setCharity_button(charity_button.getText().toString());


                                }
                                else {


                                    model.setCharity_button(null);

                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setLearning_button(learning_button.getText().toString());


                                }
                                else {


                                    model.setLearning_button(null);

                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setSports_button(sports_button.getText().toString());


                                }
                                else {

                                    model.setSports_button(null);


                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setSkating_button(skating_button.getText().toString());


                                }
                                else {
                                    model.setSkating_button(null);



                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setStudying_button(studying_button.getText().toString());


                                }
                                else {

                                    model.setStudying_button(null);


                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setFoodie_button(foodie_button.getText().toString());


                                }
                                else {

                                    model.setFoodie_button(null);


                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setCleaning_button(cleaning_button.getText().toString());


                                }
                                else {

                                    model.setCleaning_button(null);


                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setCooking_button(cooking_button.getText().toString());


                                }
                                else {

                                    model.setCooking_button(null);


                                }
                                isPressed = !isPressed;
                                if (isPressed) {
                                    model.setStayhome_button(stayhome_button.getText().toString());


                                }
                                else {

                                    model.setStayhome_button(null);


                                }


                                database.getReference().child("profile data").push().setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(profile_screen.this, "data upload successfully", Toast.LENGTH_SHORT).show();



                                    }

                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(profile_screen.this, "Error occurred", Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }
                        });
                    }
                });
            }


        });


    }

    private void UploadImage() {

        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent, "Select images"), 1);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                        Toast.makeText(profile_screen.this, "Permission Denied", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                        permissionToken.continuePermissionRequest();

                    }
                }).check();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            ImageUri = data.getData();
            add_photo.setImageURI(ImageUri
            );

        }
    }
}