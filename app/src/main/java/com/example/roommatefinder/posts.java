package com.example.roommatefinder;

import static androidx.activity.result.contract.ActivityResultContracts.*;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.github.fajaragungpramana.dotsindicator.DotsIndicator;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class posts extends AppCompatActivity {

    EditText edit_text_price_posts, edit_size, edit_text_no_beds, edit_text_no_baths,
            edit_text_no_roommates, edit_text_full_address_posts, edit_text_area_posts;
    Button btn_upload_post;
    ImageView add_photo_posts;
    List<Uri> imageUris = new ArrayList<>();
    List<Uri> imageUrls = new ArrayList<>();
    LinearLayout linearLayout;
    private FirebaseDatabase database;
    private FirebaseStorage firebaseStorage;
    ProgressDialog dialog;
    int uploadCount = 0;

    ViewPager imageslider;
    DotsIndicator dotsIndicator;

    ActivityResultLauncher<PickVisualMediaRequest> pickMultipleImages =
            registerForActivityResult(new PickMultipleVisualMedia(), uris -> {
                if (!uris.isEmpty()) {
                    imageslider.setVisibility(View.VISIBLE);
                    add_photo_posts.setVisibility(View.GONE);
                    imageUris = uris;
                    ImagesAdapter imagesAdapter = new ImagesAdapter(this,
                            uris.stream()
                                    .map(Uri::toString)
                                    .collect(Collectors.toList())
                    );
                    imageslider.setAdapter(imagesAdapter);
                    dotsIndicator.setViewPager(imageslider);
                    if (uris.size() < 2)
                        dotsIndicator.setVisibility(View.GONE);
                    else
                        dotsIndicator.setVisibility(View.VISIBLE);
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        imageslider = findViewById(R.id.imageSlider);
        dotsIndicator = findViewById(R.id.dotsIndicator);
       EditText adtitle = findViewById(R.id.edit_text_ad_title_posts);
       EditText addesc = findViewById(R.id.edit_text_ad_desc_posts);
       EditText date_edittext = findViewById(R.id.edit_text_available_from_posts);

        TextView house_textview = findViewById(R.id.house_textview);
        TextView apartment_textview = findViewById(R.id.apartment_textview);
        TextView villa_textview = findViewById(R.id.villa_textview);
        TextView other_textview = findViewById(R.id.other_property_textview);



        TextView garage_textview = findViewById(R.id.garage_textview);
        TextView parking_textview = findViewById(R.id.parking_textview);
        TextView internet_textview = findViewById(R.id.internet_textview);
        TextView balacony_textview = findViewById(R.id.balacony_textview);
        TextView garden_textview = findViewById(R.id.garden_textview);
        TextView workingout_textview = findViewById(R.id.workingout_textview);
        TextView securities_textview = findViewById(R.id.security_textview);
        TextView pets_textview = findViewById(R.id.pets_textview);

        TextView washingmachine_textview = findViewById(R.id.washingmachine_textview);
        TextView tv_textview = findViewById(R.id.tv_textview);
        TextView airconditioner_textview = findViewById(R.id.airconditioner_textview);
        TextView otherappliance_textview = findViewById(R.id.otherappliance_textview);




        CheckBox garage_checkbox = findViewById(R.id.garage_checkbox);
        CheckBox parking_checkbox = findViewById(R.id.parking_checkbox);
        CheckBox internet_checkbox = findViewById(R.id.internet_checkbox);
        CheckBox balacony_checkbox = findViewById(R.id.balacony_checkbox);
        CheckBox garden_checkbox = findViewById(R.id.garden_checkbox);
        CheckBox workingout_checkbox = findViewById(R.id.workingout_checkbox);
        CheckBox securities_checkbox = findViewById(R.id.securities_checkbox);
        CheckBox pets_checkbox = findViewById(R.id.pets_checkbox);

        CheckBox washingmachine_checkbox = findViewById(R.id.washingmachine_checkbox);
        CheckBox tv_checkbox = findViewById(R.id.tv_checkbox);
        CheckBox airconditioner_checkbox = findViewById(R.id.airconditioner_checkbox);
        CheckBox other_checkbox = findViewById(R.id.other_checkbox);

        washingmachine_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        tv_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        airconditioner_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        other_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });



        garage_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        parking_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        internet_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        balacony_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        garden_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        workingout_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        securities_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        pets_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                }
            }
        });


        RadioButton house_radiobutton = findViewById(R.id.house_radiobutton);
        RadioButton apartment_radiobutton = findViewById(R.id.apartment_radiobutton);
        RadioButton villa_radiobutton = findViewById(R.id.villa_radiobutton);
        RadioButton other_radiobutton = findViewById(R.id.other_amenities_radiobutton);
        RadioGroup property_type_radiogroup = findViewById(R.id.property_type_radiogroup);


        RadioButton furnished_radiobutton = findViewById(R.id.furnished_radiobutton);
        RadioButton notfurnished_radiobutton = findViewById(R.id.notfurnished_radiobutton);

        RadioGroup furnishing_radiogroup = findViewById(R.id.furnishing_radiogroup);
        TextView furnishing_textview = findViewById(R.id.furnishing_textview);
        TextView notfurnishing_textview = findViewById(R.id.notfurnishing_textview);
        furnishing_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (furnished_radiobutton.isChecked()) {
                    String furnished_string = furnishing_textview.getText().toString();
                }
                if (notfurnished_radiobutton.isChecked()) {
                    String notfurnished_string = notfurnishing_textview.getText().toString();
                }

            }
        });



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
        add_photo_posts = findViewById(R.id.add_photo_posts);
        btn_upload_post = findViewById(R.id.btn_upload_post);


        add_photo_posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UploadImage();

            }
        });

        btn_upload_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();


                if (!imageUris.isEmpty()) {
                    uploadData(new OnUploadListener() {
                        @Override
                        public void onUpload() {
                            projectModel model = new projectModel();

                            model.setUid(FirebaseAuth.getInstance().getCurrentUser().getUid());

                            if (house_radiobutton.isChecked()) {
                                model.setPropertytype(house_textview.getText().toString());

                            }
                            if (apartment_radiobutton.isChecked()) {
                                model.setPropertytype(apartment_textview.getText().toString());

                            }
                            if (villa_radiobutton.isChecked()) {
                                model.setPropertytype(villa_textview.getText().toString());

                            }
                            if (other_radiobutton.isChecked()) {
                                model.setPropertytype(other_textview.getText().toString());

                            }
                            if (furnished_radiobutton.isChecked()) {
                                model.setFurinture(furnishing_textview.getText().toString());

                            }
                            if (notfurnished_radiobutton.isChecked()) {
                                model.setFurinture(notfurnishing_textview.getText().toString());

                            }


                            if (garage_checkbox.isChecked()) {

                                model.setGarage(garage_textview.getText().toString());

                            }
                            if (parking_checkbox.isChecked()) {
                                model.setParking(parking_textview.getText().toString());

                            }
                            if (internet_checkbox.isChecked()) {
                                model.setInternet(internet_textview.getText().toString());

                            }
                            if (balacony_checkbox.isChecked()) {
                                model.setBalacony(balacony_textview.getText().toString());

                            }
                            if (garden_checkbox.isChecked()) {
                                model.setGarden(garden_textview.getText().toString());

                            }

                            if (workingout_checkbox.isChecked()) {
                                model.setWorkout(workingout_textview.getText().toString());

                            }
                            if (securities_checkbox.isChecked()) {
                                model.setSecurity(securities_textview.getText().toString());

                            }

                            if (pets_checkbox.isChecked()) {
                                model.setPets(pets_textview.getText().toString());

                            }
                            if (washingmachine_checkbox.isChecked()) {
                                model.setWashingmachines(washingmachine_textview.getText().toString());

                            }
                            if (tv_checkbox.isChecked()) {
                                model.setTv(tv_textview.getText().toString());

                            }
                            if (airconditioner_checkbox.isChecked()) {
                                model.setAirconditioner(airconditioner_textview.getText().toString());

                            }
                            if (other_checkbox.isChecked()) {
                                model.setOther(otherappliance_textview.getText().toString());

                            }


                            model.setPost_images(imageUrls.stream()
                                    .map(Uri::toString)
                                    .collect(Collectors.toList()
                                    ));
                            model.setAdtitle(adtitle.getText().toString());
                            model.setAddesc(addesc.getText().toString());
                            model.setDate(date_edittext.getText().toString());


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
                                            finish();

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
                } else {
                    Toast.makeText(posts.this, "Please select image", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }

            }
        });


    }

    private void UploadImage() {
        pickMultipleImages.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(PickVisualMedia.ImageOnly.INSTANCE)
                .build());
    }

    private void uploadData(OnUploadListener listener) {
        final StorageReference reference = firebaseStorage.getReference().child("house").child(System.currentTimeMillis() + "");
        Uri ImageUri = imageUris.get(uploadCount);
        reference.putFile(ImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        imageUrls.add(uri);
                        if (++uploadCount < imageUris.size()) {
                            uploadData(listener);
                        } else {
                            listener.onUpload();
                        }
                    }
                });
            }
        });
    }

    private interface OnUploadListener {
        void onUpload();
    }
}
