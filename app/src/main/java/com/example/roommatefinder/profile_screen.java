package com.example.roommatefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

    ImageView add_photo;
    TextView edit_text_first_name_fill_information , edit_text_last_name_fill_information , edit_text_gender_fill_information ,
    edit_text_phone_number_fill_information , edit_text_birth_date_fill_information , edit_text_national_id_fill_information ;
    Uri ImageUri;
    Button btn_upload_profiledata;
    private FirebaseDatabase database;
    private FirebaseStorage firebaseStorage;
    FirebaseDatabase firebaseDatabase ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
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


        firebaseDatabase = FirebaseDatabase.getInstance();


        firebaseDatabase.getReference().child("profile data").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    projectModel projectmodel = dataSnapshot.getValue(projectModel.class);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




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
                startActivity(intent);



                final StorageReference reference = firebaseStorage.getReference().child("profile data").child(System.currentTimeMillis() + "");

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