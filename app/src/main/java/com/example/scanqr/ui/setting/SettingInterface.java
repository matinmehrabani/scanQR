package com.example.scanqr.ui.setting;

import android.support.v7.app.AlertDialog;
import android.widget.RadioGroup;

import com.example.scanqr.model.Setting;

import java.util.List;

public interface SettingInterface {

    interface ui {

        void change();

        void init();

        void initListen(AlertDialog.Builder builder);

        void recyclerView();

        void toolBar();

        void alertDialog();
    }
}
