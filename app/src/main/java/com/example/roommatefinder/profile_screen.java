package com.example.roommatefinder;

import static androidx.activity.result.contract.ActivityResultContracts.*;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
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
    TextView edit_text_last_name_fill_information, edit_text_gender_fill_information,
            edit_text_phone_number_fill_information, edit_text_birth_date_fill_information, edit_text_national_id_fill_information;
    Uri ImageUri;
    Button btn_upload_profiledata;
    private FirebaseDatabase database;
    private FirebaseStorage firebaseStorage;
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    EditText edit_text_first_name_fill_information;

    ActivityResultLauncher<PickVisualMediaRequest> pickImage =
            registerForActivityResult(new PickVisualMedia(), uri -> {
                // Callback is invoked after the user selects a media item or closes the
                // photo picker.
                if (uri != null) {
                    add_photo.setImageURI(uri);
                    ImageUri = uri;
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        mAuth = FirebaseAuth.getInstance();

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recycleList, getApplicationContext());

        RecyclerView interestsRecyclerView = findViewById(R.id.interests_recycler_view);
        ArrayList<String> interestList = new ArrayList<>();
        InterestsAdapter interestsAdapter = new InterestsAdapter();
        interestsAdapter.setOnItemClickListener(item -> {
            if (interestList.contains(item)) {
                interestList.remove(item);
            } else {
                interestList.add(item);
            }
        });
        interestsRecyclerView.setAdapter(interestsAdapter);

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

        database.getReference().child("profile data")
                .child(mAuth.getCurrentUser()
                        .getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult().exists()) {
                                startActivity(new Intent(profile_screen.this, home_page.class));
                                finish();
                            }
                        }
                    }
                });


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
                Intent intent = new Intent(profile_screen.this, home_page.class);


//                name = edit_text_first_name_fill_information.getText().toString().trim();
//                intent.putExtra("key" , name);
//


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


                final StorageReference reference = firebaseStorage
                        .getReference()
                        .child("profile data");

                if (ImageUri != null) {
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
                                    model.setInterests(interestList);


                                    database.getReference().child("profile data").child(mAuth.getCurrentUser().getUid()).setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(profile_screen.this, "data upload successfully", Toast.LENGTH_SHORT).show();
                                            startActivity(intent);
                                            finish();
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
                } else {
                    Toast.makeText(profile_screen.this, "Please select an image", Toast.LENGTH_SHORT).show();
                }
            }


        });


    }

    private void UploadImage() {
        pickImage.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(PickVisualMedia.ImageOnly.INSTANCE)
                .build());
    }
}