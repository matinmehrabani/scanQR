package com.example.scanqr.ui.setting;

import android.widget.RadioGroup;

import com.example.scanqr.model.Setting;

import java.util.List;

public interface SettingInterface {

    interface ui {

        void alert(List<Setting> list);

        void change();

        void init();

        void initListen(RadioGroup radioGroup);

        void recyclerView();

        void toolBar();
    }
}
