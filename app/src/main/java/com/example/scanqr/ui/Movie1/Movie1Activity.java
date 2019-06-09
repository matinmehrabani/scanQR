package com.example.scanqr.ui.Movie1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.scanqr.R;

public class Movie1Activity extends AppCompatActivity {
    FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie1);
        mFrameLayout = findViewById(R.id.frame);
        Movie1Fragment movie1Fragment = new Movie1Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, movie1Fragment);
        ft.commit();
    }
}


