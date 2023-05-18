package com.example.roommatefinder;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class posts extends AppCompatActivity {

    EditText edit_text_price_posts , size , beds , baths , roommates , edit_text_full_address_posts , edit_text_area_posts ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        edit_text_price_posts = findViewById(R.id.edit_text_price_posts);

    }
}
