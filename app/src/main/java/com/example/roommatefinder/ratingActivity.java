package com.example.roommatefinder;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ratingActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);
        String text = "How likely would you recommend Roommate Finder to your friends?";
        SpannableString spannableString = new SpannableString(text);
        int startIndex = text.indexOf("Roommate");
        int endIndex = startIndex + "Roommate".length();
        ForegroundColorSpan foregroundSpan = new ForegroundColorSpan(Color.parseColor("#9747FF"));
        spannableString.setSpan(foregroundSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView textView = findViewById(R.id.my_textview);
        textView.setText(spannableString);
        RatingBar ratingBar = findViewById(R.id.rating_bar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });




    }
}
