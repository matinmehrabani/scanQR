package com.example.scanqr;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.scanqr.ui.CreateQR.CreateQrFragment;
import com.example.scanqr.ui.RecyclerViewmovie.RecyclerViewFragment;
import com.example.scanqr.ui.Settings.SettingsFragment;
import com.example.scanqr.ui.scanQR.ScanFragment;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    //TODO:(matin) remove additional codes
    //TODO:(matin) change activities to fragments
    //TODO:(matin) define initUiComponent and initUiListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
       disableShiftMode(bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new CreateQrFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint({"ResourceAsColor", "ResourceType"})
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_1:
                        CreateQrFragment createQrFragment = new CreateQrFragment();
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.frameLayout, createQrFragment);
                        ft.commit();

                        break;
                    case R.id.item_2:

                        ScanFragment scanFragment = new ScanFragment();
                        FragmentManager fm2 = getSupportFragmentManager();
                        FragmentTransaction ft2 = fm2.beginTransaction();
                        ft2.replace(R.id.frameLayout, scanFragment);
                        ft2.commit();
                        break;

                    case R.id.item_3:
                        SettingsFragment settingsFragment = new SettingsFragment();
                        FragmentManager fm3 = getSupportFragmentManager();
                        FragmentTransaction ft3 = fm3.beginTransaction();
                        ft3.replace(R.id.frameLayout, settingsFragment);
                        ft3.commit();
                        break;
                    case R.id.item_4:
                        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
                        FragmentManager fm4 = getSupportFragmentManager();
                        FragmentTransaction ft4 = fm4.beginTransaction();
                        ft4.replace(R.id.frameLayout, recyclerViewFragment);
                        ft4.commit();
                        break;
                }
                return false;
            }
        });
    }

        @SuppressLint("RestrictedApi")
        public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShifting(false);
             //   item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}
