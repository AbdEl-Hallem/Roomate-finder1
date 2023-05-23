package com.example.roommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class detailActivity extends AppCompatActivity {

    TextView full_adress , size , baths , beds , roommates , description ,date,price , amenties;
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
        imageslider = findViewById(R.id.imageslider);

        Picasso.get().load(getIntent().getStringExtra("imageslider")).placeholder(R.drawable.a).into(imageslider);
        full_adress.setText(getIntent().getStringExtra("full_adress"));
        size.setText(getIntent().getStringExtra("size")+" size");
        baths.setText(getIntent().getStringExtra("baths")+" baths");
        beds.setText(getIntent().getStringExtra("beds")+" beds");
        roommates.setText(getIntent().getStringExtra("roommates")+" mates");
        description.setText(getIntent().getStringExtra("description"));
        date.setText("Available from : " + getIntent().getStringExtra("date"));
        price.setText("price : " + getIntent().getStringExtra("price"));
        amenties.setText( getIntent().getStringExtra("amenties"));

























//        ImageSlider imageSlider = findViewById(R.id.imageslider);
//        ArrayList<SlideModel>  slideModel  = new ArrayList<>();
//
//        slideModel.add(new SlideModel(R.drawable.a, ScaleTypes.FIT));
//        slideModel.add(new SlideModel(R.drawable.aa, ScaleTypes.FIT));
//        imageSlider.setImageList(slideModel , ScaleTypes.FIT);


    }
}