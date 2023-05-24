package com.example.roommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class filter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);





        EditText minprice_edittext = findViewById(R.id.minprice_edittext);
        EditText maxprice_edittext = findViewById(R.id.maxprice_edittext);
        EditText minarea_edittext = findViewById(R.id.minarea_edittext);
        EditText maxarea_edittext = findViewById(R.id.maxarea_edittext);
        EditText bedssss_edittext = findViewById(R.id.bedssss_edittext);
        EditText bathssss_edittext = findViewById(R.id.bathssss_edittext);
        EditText matessss_edittext = findViewById(R.id.matessss_edittext);

        minprice_edittext.setGravity(Gravity.CENTER);
        maxprice_edittext.setGravity(Gravity.CENTER);
        minarea_edittext.setGravity(Gravity.CENTER);
        maxarea_edittext.setGravity(Gravity.CENTER);

        RadioButton furnishedddd_radiobutton = findViewById(R.id.furnishedddd_radiobutton);
        RadioButton notfurnishedddd_radiobutton = findViewById(R.id.notfurnished_radiobutton);
        RadioGroup furnishing_radiogroup = findViewById(R.id.furnishingggg_radiogroup);
        furnishing_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }



        });
        TextView clear_button = findViewById(R.id.clear_button);
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                furnishedddd_radiobutton.setChecked(false);
                notfurnishedddd_radiobutton.setChecked(false);

                minprice_edittext.setText("");
                maxprice_edittext.setText("");
                minarea_edittext.setText("");
                maxarea_edittext.setText("");
                bedssss_edittext.setText("");
                bathssss_edittext.setText("");
                matessss_edittext.setText("");


            }
        });


    }
}