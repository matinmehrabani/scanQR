package com.example.scanqr;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;

import com.example.scanqr.ui.createQr.CreateQrFragment;
import com.example.scanqr.ui.recyclerViewMovie.RecyclerViewMovieFragment;
import com.example.scanqr.ui.scanQr.ScanFragment;
import com.example.scanqr.ui.setting.SettingFragment;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity implements MainInterface.view {
    private BottomNavigationView mBottomNavigationView;

    //TODO:(matin) remove additional codes
    //TODO:(matin) change activities to fragments
    //TODO:(matin) define initUiComponent and initUiListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListen();
    }


    @Override
    public void init() {
        mBottomNavigationView = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new CreateQrFragment()).commit();
    }

    @Override
    public void initListen() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint({"ResourceAsColor", "ResourceType"})
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_1:
                        CreateQrFragment createQrFragment = new CreateQrFragment();
                        replace(createQrFragment);
                        break;
                    case R.id.item_2:

                        ScanFragment scanFragment = new ScanFragment();
                       replace(scanFragment);
                        break;

                    case R.id.item_3:
                        SettingFragment settingsFragment = new SettingFragment();
                       replace(settingsFragment);
                        break;
                    case R.id.item_4:
                        RecyclerViewMovieFragment recyclerViewFragment = new RecyclerViewMovieFragment();
                        replace(recyclerViewFragment);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void replace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
