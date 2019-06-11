package com.example.scanqr.ui.taKhtGaz;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.scanqr.R;

public class TaKhtGazActivity extends AppCompatActivity {
   private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie1);
        mFrameLayout = findViewById(R.id.frame);
        TaKhtGazFragment movie1Fragment = new TaKhtGazFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, movie1Fragment);
        ft.commit();
    }
}


