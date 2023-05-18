package com.example.roommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageSlider imageSlider = findViewById(R.id.imageslider);
        ArrayList<SlideModel>  slideModel  = new ArrayList<>();

        slideModel.add(new SlideModel(R.drawable.a, ScaleTypes.FIT));
        slideModel.add(new SlideModel(R.drawable.aa, ScaleTypes.FIT));
        imageSlider.setImageList(slideModel , ScaleTypes.FIT);


    }
}