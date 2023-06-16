package com.example.roommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        TextView saved = findViewById(R.id.save);
        TextView rating = findViewById(R.id.rateing);
        TextView logout = findViewById(R.id.logout);

        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this , FavoriteActivity.class);

                startActivity(intent);

            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this , ratingActivity.class);

                startActivity(intent);

            }
        });




        Switch generalnotification_switchbutton = findViewById(R.id.generalnotification_switchbutton);
        Switch msgnotification_switchbutton = findViewById(R.id.msgnotification_switchbutton);

        int[][] states = new int[][] {
                new int[] { android.R.attr.state_checked },
                new int[] { -android.R.attr.state_checked }
        };
        int[] trackColors = new int[]{
                Color.parseColor("#B064F4"), // Custom color for switch when it is on
                Color.parseColor("#D9D9D9")  // Custom color for switch when it is off
        };

        int[] thumbColors = new int[] {
                Color.parseColor("#B064F4"), // Custom color for switch whenit is on
                Color.parseColor("#D9D9D9")  // White color for switch when it is off
        };

        ColorStateList trackColorStateList = new ColorStateList(states, trackColors);
        ColorStateList thumbColorStateList = new ColorStateList(states, thumbColors);
        generalnotification_switchbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    generalnotification_switchbutton.setTrackTintList(trackColorStateList);
                    generalnotification_switchbutton.setThumbTintList(thumbColorStateList);

                } else {
                    generalnotification_switchbutton.setTrackTintList(trackColorStateList);
                    generalnotification_switchbutton.setThumbTintList(thumbColorStateList);
                }
            }
        });
        msgnotification_switchbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    msgnotification_switchbutton.setTrackTintList(trackColorStateList);
                    msgnotification_switchbutton.setThumbTintList(thumbColorStateList);
                } else {
                    msgnotification_switchbutton.setTrackTintList(trackColorStateList);

                    msgnotification_switchbutton.setThumbTintList(thumbColorStateList);
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Setting.this, ratingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                Setting.this.finish();
            }
        });







    }
}