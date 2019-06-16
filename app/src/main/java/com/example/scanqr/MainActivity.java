package com.example.scanqr;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.scanqr.ui.createQr.CreateQrFragment;
import com.example.scanqr.ui.listMovie.ListMovieFragment;
import com.example.scanqr.ui.scanQr.ScanFragment;
import com.example.scanqr.ui.setting.SettingFragment;

public class MainActivity extends AppCompatActivity  {

    private TabLayout mTabLayout;

    //TODO:(matin) remove additional codes
    //TODO:(matin) change activities to fragments
    //TODO:(matin) define initUiComponent and initUiListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        initListen();
    }



    public void initUi() {

        mTabLayout = findViewById(R.id.tab_layout);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_main_replaceFragments, new CreateQrFragment()).commit();
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.createqr_textsettitle).setIcon(R.drawable.ic_create_black_24dp));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.scan_textsettitle).setIcon(R.drawable.ic_settings_overscan_black_24dp));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.setting_textsettitle).setIcon(R.drawable.ic_settings_black_24dp));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.listmovie_textsettitle).setIcon(R.drawable.ic_local_movies_black_24dp));
    }


    public void initListen() {

        mTabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 0:
                        CreateQrFragment createQrFragment = new CreateQrFragment();
                        replace(createQrFragment);
                        break;
                    case 1:
                        ScanFragment scanFragment = new ScanFragment();
                        replace(scanFragment);
                        break;
                    case 2: SettingFragment settingsFragment = new SettingFragment();
                        replace(settingsFragment);
                        break;
                    case 3:
                        ListMovieFragment recyclerViewFragment = new ListMovieFragment();
                        replace(recyclerViewFragment);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }



    public void replace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_main_replaceFragments, fragment);
        fragmentTransaction.commit();
    }
}
