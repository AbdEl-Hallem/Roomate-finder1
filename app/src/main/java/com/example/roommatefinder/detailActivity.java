package com.example.roommatefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class detailActivity extends AppCompatActivity {
    public static final String NAME = "NAME";
    private String name;

    TextView full_adress , size , baths , beds , roommates , description ,date, price ,
            amenties, apartment_textview ,villa_textview, other_property_textview,
            garage_textview ,parking_textview, internet_textview,balacony_textview,garden_textview,workingout_textview
            , security_textview , pets_textview
            ,furnishing_textview , notfurnishing_textview
            ,washingmachine_textview,tv_textview,airconditioner_textview,otherappliance_textview;
ImageView profile_detail;
TextView first_name;
    Uri ImageUri;

    RecyclerView recyclerView ;
    ArrayList<projectModel> recycleList;
    FirebaseDatabase firebaseDatabase ;
    private FirebaseDatabase database;
    private DatabaseReference refrence;
    private FirebaseStorage firebaseStorage;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(this, home_page.class);
        startActivity(intent);
    }






    ImageView imageslider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);





        full_adress = findViewById(R.id.full_adress);
        size = findViewById(R.id.size);
        baths = findViewById(R.id.baths);
        beds = findViewById(R.id.beds);
        roommates = findViewById(R.id.roommates);
        description = findViewById(R.id.description);
        date = findViewById(R.id.date);
        price = findViewById(R.id.price);



        amenties = findViewById(R.id.amenties);
        apartment_textview = findViewById(R.id.apartment_textview);
        villa_textview = findViewById(R.id.villa_textview);
        other_property_textview = findViewById(R.id.other_property_textview);

        garage_textview = findViewById(R.id.garage_textview);
        internet_textview = findViewById(R.id.internet_textview);
        parking_textview = findViewById(R.id.parking_textview);
        balacony_textview = findViewById(R.id.balacony_textview);
        garden_textview = findViewById(R.id.garden_textview);
        workingout_textview = findViewById(R.id.workingout_textview);
        security_textview = findViewById(R.id.security_textview);
        pets_textview = findViewById(R.id.pets_textview);

        furnishing_textview = findViewById(R.id.furnishing_textview);
        notfurnishing_textview = findViewById(R.id.notfurnishing_textview);

        washingmachine_textview = findViewById(R.id.washingmachine_textview);
        tv_textview = findViewById(R.id.tv_textview);
        airconditioner_textview = findViewById(R.id.airconditioner_textview);
        otherappliance_textview = findViewById(R.id.otherappliance_textview);




        profile_detail = findViewById(R.id.profile_detail);
        first_name = findViewById(R.id.first_name);


        imageslider = findViewById(R.id.imageslider);


        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String firstName = preferences.getString("first_name", "");
        first_name.setText(firstName);


//        Intent intent = getIntent();
//        name = intent.getStringExtra("first_name");
//        first_name.setText(name);




//
//
//                refrence = FirebaseDatabase.getInstance().getReference("profile data");
////
//                refrence.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                         String name = snapshot.child("first_name").getValue().toString();
//                         System.out.println(name + "hhhh");
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//




















//        Intent intent = getIntent();
//
//        String username = intent.getStringExtra("edit_text_first_name_fill_information");
//         first_name.setText(username);
//
//
//        String userName = first_name.getText().toString().trim();
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("profile data").child("edit_text_first_name_fill_information");
//        Query checkUserDatabase = reference.orderByValue().equalTo(userName);
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()){
//                    String usernameFromDB = snapshot.getValue(String.class);
//                    Intent intent = new Intent();
//                    intent.putExtra("username", usernameFromDB);
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//        });


        projectModel model = new projectModel();
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
//        final StorageReference reference = firebaseStorage.getReference().child("house");
//
//        reference.putFile(ImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                    @Override
//                    public void onSuccess(Uri uri) {
//                        projectModel model = new projectModel();
//                        model.setAdd_photo(uri.toString());
//
//                        // Set other fields as needed
//
//                        Query query = database.getReference().child("house")
//                                .orderByChild("edit_text_first_name_fill_information")
//                                .equalTo(first_name.getText().toString());
//
//                        query.addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                if (snapshot.exists()) {
//                                    // Data already exists in Firebase, do not add new item to RecyclerView
//                                } else {
//                                    // Data does not exist in Firebase, add new item to RecyclerView
//                                    database.getReference().child("house").push().setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                        @Override
//                                        public void onSuccess(Void unused) {
//                                        }
//                                    }).addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                        }
//                                    });
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//                            }
//                        });
//                    }
//                });
//            }
//        });














//
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recycleList , getApplicationContext());
//
//
//        firebaseDatabase.getReference().child("house").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//
//                    projectModel model = dataSnapshot.getValue(projectModel.class);
//                    model.setEdit_text_first_name_fill_information(model.getEdit_text_first_name_fill_information());
//                }
//
//                recyclerAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });






        Picasso.get().load(getIntent().getStringExtra("imageslider")).placeholder(R.drawable.a).fit().into(imageslider);



        full_adress.setText(getIntent().getStringExtra("full_adress"));
        size.setText(getIntent().getStringExtra("size")+" size");
        baths.setText(getIntent().getStringExtra("baths")+" baths");
        beds.setText(getIntent().getStringExtra("beds")+" beds");
        roommates.setText(getIntent().getStringExtra("roommates")+" mates");
        description.setText(getIntent().getStringExtra("description"));
        date.setText("Available from : " + getIntent().getStringExtra("date"));
        price.setText("price : " + getIntent().getStringExtra("price"));
//        first_name.setText(getIntent().getStringExtra("first_name"));
        String amentiesValue = getIntent().getStringExtra("amenties");
        String apartmentValue = getIntent().getStringExtra("apartment_textview");
        String villaValue = getIntent().getStringExtra("villa_textview");
        String otherPropertyValue = getIntent().getStringExtra("other_property_textview");

        if (amentiesValue != null && !amentiesValue.isEmpty()) { // Check if amentiesValue is not null and not empty
            amenties.setText(amentiesValue);

            if (apartmentValue != null && !apartmentValue.isEmpty()) { // Check if apartmentValue is not null and not empty
                apartment_textview.setText(apartmentValue);
                villa_textview.setVisibility(View.GONE);
                other_property_textview.setVisibility(View.GONE);
                amenties.setVisibility(View.GONE);
            } else if (villaValue != null && !villaValue.isEmpty()) { // Check if villaValue is not null and not empty
                villa_textview.setText(villaValue);
                apartment_textview.setVisibility(View.GONE);
                other_property_textview.setVisibility(View.GONE);
                amenties.setVisibility(View.GONE);

            } else if (otherPropertyValue != null && !otherPropertyValue.isEmpty()) { // Check if otherPropertyValue is not null and not empty
                other_property_textview.setText(otherPropertyValue);
                apartment_textview.setVisibility(View.GONE);
                villa_textview.setVisibility(View.GONE);
                amenties.setVisibility(View.GONE);

            } else {
                apartment_textview.setVisibility(View.GONE);
                villa_textview.setVisibility(View.GONE);
                other_property_textview.setVisibility(View.GONE);
            }
        } else {
            // amentiesValue is null or empty, do not display any data in the text views
            amenties.setVisibility(View.GONE);
            apartment_textview.setVisibility(View.GONE);
            villa_textview.setVisibility(View.GONE);
            other_property_textview.setVisibility(View.GONE);
        }
        String furnishingValue = getIntent().getStringExtra("furnishing_textview");
        String notFurnishingValue = getIntent().getStringExtra("notfurnishing_textview");

        if (furnishingValue != null && !furnishingValue.isEmpty()) { // Check if furnishingValue is not null and not empty
            furnishing_textview.setText(furnishingValue);
            notfurnishing_textview.setVisibility(View.GONE);
        } else if (notFurnishingValue != null && !notFurnishingValue.isEmpty()) { // Check if notFurnishingValue is not null and not empty
            notfurnishing_textview.setText(notFurnishingValue);
            furnishing_textview.setVisibility(View.GONE);
        } else {
            // Neither furnishingValue nor notFurnishingValue is selected, hide both text views
            furnishing_textview.setVisibility(View.GONE);
            notfurnishing_textview.setVisibility(View.GONE);
        }



        String garage = getIntent().getStringExtra("garage_textview");
        if (garage != null && !garage.isEmpty()) {
            garage_textview.setText(garage);
        } else {
            garage_textview.setVisibility(View.GONE);
        }

        String internet = getIntent().getStringExtra("internet_textview");
        if (internet != null && !internet.isEmpty()) {
            internet_textview.setText(internet);
        } else {
            internet_textview.setVisibility(View.GONE);
        }

        String parking = getIntent().getStringExtra("parking_textview");
        if (parking != null && !parking.isEmpty()) {
            parking_textview.setText(parking);
        } else {
            parking_textview.setVisibility(View.GONE);
        }

        String balcony = getIntent().getStringExtra("balacony_textview");
        if (balcony != null && !balcony.isEmpty()) {
            balacony_textview.setText(balcony);
        } else {
            balacony_textview.setVisibility(View.GONE);
        }

        String garden = getIntent().getStringExtra("garden_textview");
        if (garden != null && !garden.isEmpty()) {
            garden_textview.setText(garden);
        } else {
            garden_textview.setVisibility(View.GONE);
        }

        String workout = getIntent().getStringExtra("workingout_textview");
        if (workout != null && !workout.isEmpty()) {
            workingout_textview.setText(workout);
        } else {

            workingout_textview.setVisibility(View.GONE);
        }

        String security = getIntent().getStringExtra("security_textview");
        if (security != null && !security.isEmpty()) {
            security_textview.setText(security);
        } else {
            security_textview.setVisibility(View.GONE);
        }

        String pets = getIntent().getStringExtra("pets_textview");
        if (pets != null && !pets.isEmpty()) {
            pets_textview.setText(pets);
        } else {
            pets_textview.setVisibility(View.GONE);
        }

        String washingMachine = getIntent().getStringExtra("washingmachine_textview");
        if (washingMachine != null && !washingMachine.isEmpty()) {
            washingmachine_textview.setText(washingMachine);
        } else {
            washingmachine_textview.setVisibility(View.GONE);
        }

        String tv = getIntent().getStringExtra("tv_textview");
        if (tv != null && !tv.isEmpty()) {
            tv_textview.setText(tv);
        } else {
            tv_textview.setVisibility(View.GONE);
        }

        String airConditioner = getIntent().getStringExtra("airconditioner_textview");
        if (airConditioner != null && !airConditioner.isEmpty()) {
            airconditioner_textview.setText(airConditioner);
        } else {
            airconditioner_textview.setVisibility(View.GONE);
        }

        String otherAppliance = getIntent().getStringExtra("otherappliance_textview");
        if (otherAppliance != null && !otherAppliance.isEmpty()) {
            otherappliance_textview.setText(otherAppliance);
        } else {
            otherappliance_textview.setVisibility(View.GONE);
        }


//
//        amenties.setText( getIntent().getStringExtra("amenties"));
//        apartment_textview.setText( getIntent().getStringExtra("apartment_textview"));
//        villa_textview.setText( getIntent().getStringExtra("villa_textview"));
//        other_property_textview.setText( getIntent().getStringExtra("other_property_textview"));

//        garage_textview.setText( getIntent().getStringExtra("garage_textview"));
//        internet_textview.setText( getIntent().getStringExtra("internet_textview"));
//        parking_textview.setText( getIntent().getStringExtra("parking_textview"));
//        balacony_textview.setText( getIntent().getStringExtra("balacony_textview"));
//        garden_textview.setText( getIntent().getStringExtra("garden_textview"));
//        workingout_textview.setText( getIntent().getStringExtra("workingout_textview"));
//        security_textview.setText( getIntent().getStringExtra("security_textview"));
//        pets_textview.setText( getIntent().getStringExtra("pets_textview"));
//        washingmachine_textview.setText( getIntent().getStringExtra("washingmachine_textview"));
//        tv_textview.setText( getIntent().getStringExtra("tv_textview"));
//        airconditioner_textview.setText( getIntent().getStringExtra("airconditioner_textview"));
//        otherappliance_textview.setText( getIntent().getStringExtra("otherappliance_textview"));

//        furnishing_textview.setText( getIntent().getStringExtra("furnishing_textview"));
//        notfurnishing_textview.setText( getIntent().getStringExtra("notfurnishing_textview"));





























//        ImageSlider imageSlider = findViewById(R.id.imageslider);
//        ArrayList<SlideModel>  slideModel  = new ArrayList<>();
//
//        slideModel.add(new SlideModel(R.drawable.a, ScaleTypes.FIT));
//        slideModel.add(new SlideModel(R.drawable.aa, ScaleTypes.FIT));
//        imageSlider.setImageList(slideModel , ScaleTypes.FIT);


    }
}