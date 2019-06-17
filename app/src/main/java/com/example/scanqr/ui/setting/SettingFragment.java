package com.example.scanqr.ui.setting;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.scanqr.R;
import com.example.scanqr.model.Setting;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.EastAsianWidth.NEUTRAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment implements SettingInterface.ui {

    private RecyclerView mRecyclerView;
    private SettingAdapter mSettingAdapter;
    private List<Setting> mArrayList;
    private Toolbar mToolbar;
    private View mRoot;
    private AlertDialog mAlertDialog;
    private CharSequence[] mValues = {" 70 ثانیه ", " 50 ثانیه", " 40 ثانیه ", " 60 ثانیه "};
    private int mId;
    private int mCheckedItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_setting, container, false);

        dataSet();
        initUi();
        initializeSettingRecyclerView();
        toolBar();
        return mRoot;

    }

    private void dataSet() {

        mArrayList = new ArrayList<>();
        mArrayList.add(new Setting(R.string.setting_onetitle, Setting.ONE_TYPE, R.drawable.ic_access_alarm_black_24dp, R.string.setting_Sixtytime));
        mArrayList.add(new Setting(R.string.setting_twotitle, Setting.ONE_TYPE, R.drawable.ic_forward_10_black_24dp, R.string.setting_pattern));
        mArrayList.add(new Setting(R.string.setting_threetitle, Setting.Two_TYPE, R.drawable.ic_home_black_24dp, R.string.setting_returnempty));
        mArrayList.add(new Setting(R.string.setting_fourtitle, Setting.Two_TYPE, R.drawable.ic_call_black_24dp, R.string.setting_returnempty));

    }

    @Override
    public void changeText() {
        switch (mArrayList.get(1).getName()) {

            case R.string.setting_pattern:
                mArrayList.get(1).setName(R.string.setting_password);
                break;

            case R.string.setting_password:
                mArrayList.get(1).setName(R.string.setting_pattern);
                break;
        }

        mSettingAdapter.notifyDataSetChanged();
    }


    public void initUi() {
        mRecyclerView = mRoot.findViewById(R.id.RecyclerView);
        mToolbar = mRoot.findViewById(R.id.Toolbar_setting);

    }


    public void initListen(AlertDialog.Builder builder) {

        switch (mArrayList.get(0).getName()){

            case R.string.setting_seventytime:mCheckedItem=0;break;
            case R.string.setting_fiftytime:mCheckedItem=1;break;
            case R.string.setting_fourtytime:mCheckedItem=2;break;
            case R.string.setting_Sixtytime: mCheckedItem=3;break;
        }

        builder.setSingleChoiceItems(mValues,mCheckedItem, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item) {

                switch (item) {
                    case 0:
                        mId = 0;

                        break;
                    case 1:
                        mId = 1;

                        break;
                    case 2:

                        mId = 2;

                        break;
                    case 3:
                        mId = 3;
                }

            }
        });
    }


    public void initializeSettingRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSettingAdapter = new SettingAdapter(mArrayList, SettingFragment.this);
        mRecyclerView.setAdapter(mSettingAdapter);
    }


    public void toolBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.setting_textsettitle);
    }

    @Override
    public void alertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle(R.string.setting_titleindialog);
        builder.setPositiveButton(R.string.setting_positiveanswer, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (mId) {
                    case 0:
                        mArrayList.get(0).setName(R.string.setting_seventytime);
                        mSettingAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        mArrayList.get(0).setName(R.string.setting_fiftytime);
                        mSettingAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        mArrayList.get(0).setName(R.string.setting_fourtytime);
                        mSettingAdapter.notifyDataSetChanged();
                        break;
                    case 3:
                        mArrayList.get(0).setName(R.string.setting_Sixtytime);
                        mSettingAdapter.notifyDataSetChanged();

                }


            }
        });
        builder.setNegativeButton(R.string.setting_negativeresponse, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        initListen(builder);
        mAlertDialog = builder.create();
        mAlertDialog.show();

    }
}


