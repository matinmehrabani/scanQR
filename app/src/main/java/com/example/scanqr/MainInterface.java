package com.example.scanqr;

import android.support.v4.app.Fragment;

public interface MainInterface {

    interface view{

        void init();
        void initListen();
        void replace(Fragment fragment);
    }
}
