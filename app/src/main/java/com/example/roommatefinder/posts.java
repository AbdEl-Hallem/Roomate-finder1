package com.example.roommatefinder;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class posts extends AppCompatActivity {

    EditText edit_text_price_posts, edit_size, edit_text_no_beds, edit_text_no_baths,
            edit_text_no_roommates, edit_text_full_address_posts, edit_text_area_posts;
    Button btn_upload_post;
    ImageView add_photo_posts;
    Uri ImageUri;
    LinearLayout linearLayout;
    private FirebaseDatabase database;
    private FirebaseStorage firebaseStorage;
    ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        database = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);
        dialog.setTitle("house information upload ");
        dialog.setCanceledOnTouchOutside(false);


        edit_text_price_posts = findViewById(R.id.edit_text_price_posts);
        edit_size = findViewById(R.id.edit_size);
        edit_text_no_beds = findViewById(R.id.edit_text_no_beds);
        edit_text_no_baths = findViewById(R.id.edit_text_no_baths);
        edit_text_no_roommates = findViewById(R.id.edit_text_no_roommates);
        edit_text_full_address_posts = findViewById(R.id.edit_text_full_address_posts);
        edit_text_area_posts = findViewById(R.id.edit_text_area_posts);
        btn_upload_post = findViewById(R.id.btn_upload_post);
        add_photo_posts = findViewById(R.id.add_photo_posts);
        linearLayout = findViewById(R.id.linearLayout_posts);


        add_photo_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UploadImage();
                linearLayout.setVisibility(View.VISIBLE);

            }
        });

        btn_upload_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();

                final StorageReference reference = firebaseStorage.getReference().child("house").child(System.currentTimeMillis() + "");

                reference.putFile(ImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                projectModel model = new projectModel();
                                model.setAdd_photo_posts(uri.toString());
                                model.setEdit_text_full_address_posts(edit_text_full_address_posts.getText().toString());

                                model.setEdit_text_no_baths(edit_text_no_baths.getText().toString());

                                model.setEdit_text_area_posts(edit_text_area_posts.getText().toString());

                                model.setEdit_text_price_posts(edit_text_price_posts.getText().toString());

                                model.setEdit_text_no_beds(edit_text_no_beds.getText().toString());

                                model.setEdit_text_no_roommates(edit_text_no_roommates.getText().toString());

                                model.setEdit_size(edit_size.getText().toString());

                                database.getReference().child("house").push().setValue(model)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {

                                                Toast.makeText(posts.this, "House img upload successfully", Toast.LENGTH_SHORT).show();
                                                dialog.dismiss();

                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                dialog.dismiss();

                                                Toast.makeText(posts.this, "Error occurred", Toast.LENGTH_SHORT).show();

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

                        Toast.makeText(posts.this, "Permission Denied", Toast.LENGTH_SHORT).show();

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
            add_photo_posts.setImageURI(ImageUri
            );

        }

    }
}
