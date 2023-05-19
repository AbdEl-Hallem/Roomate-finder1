package com.example.roommatefinder;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class posts extends AppCompatActivity {

    EditText edit_text_price_posts , edit_size , edit_text_no_beds , edit_text_no_baths ,
             edit_text_no_roommates , edit_text_full_address_posts , edit_text_area_posts ;
    Button btn_upload_post;
    ImageView add_photo_posts;
    Uri Imageuri;
    LinearLayout linearLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
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
                btn_upload_post.setVisibility(View.GONE);

            }
        });




    }

    private void UploadImage() {

        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent , 101);

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                        Toast.makeText(posts.this , "Permission Denied" , Toast.LENGTH_SHORT ).show();

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                        permissionToken.continuePermissionRequest();

                    }
                }).check();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK){
            Imageuri = data.getData();
            add_photo_posts.setImageURI(Imageuri);



        }

    }
}
