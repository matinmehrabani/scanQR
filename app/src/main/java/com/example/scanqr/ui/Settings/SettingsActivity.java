package com.example.scanqr.ui.Settings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.scanqr.R;
import com.example.scanqr.model.Settings;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {
RecyclerView recyclerView;
MyAdapter2 myAdapter2;
    List<Settings> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        dataset();
        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter2=new MyAdapter2(arrayList);
        recyclerView.setAdapter(myAdapter2);


    }

    private void dataset(){

        arrayList=new ArrayList<>();
        arrayList.add(new Settings("بازه زمانی قفل صفحه",Settings.ONE_TYPE,R.drawable.ic_access_alarm_black_24dp,"60ثانیه"));
        arrayList.add(new Settings("روش احراز هویت",Settings.ONE_TYPE,R.drawable.ic_forward_10_black_24dp,"الگو"));
        arrayList.add(new Settings("راهنمای برنامه",Settings.Two_TYPE,R.drawable.ic_home_black_24dp,null));
        arrayList.add(new Settings("پشتیبانی بانک ها",Settings.Two_TYPE,R.drawable.ic_call_black_24dp,null));

    }
}
