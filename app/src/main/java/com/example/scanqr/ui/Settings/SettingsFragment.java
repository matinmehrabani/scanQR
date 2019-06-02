package com.example.scanqr.ui.Settings;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.scanqr.R;
import com.example.scanqr.model.Settings;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    RecyclerView recyclerView;
    MyAdapter2 myAdapter2;
    List<Settings> arrayList;
    CharSequence[] values = {" First Item "," Second Item "," Third Item "};
    android.support.v7.app.AlertDialog alertDialog1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
             View view=inflater.inflate(R.layout.fragment_settings, container, false);

        dataset();
        recyclerView=view.findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter2=new MyAdapter2(arrayList);
        recyclerView.setAdapter(myAdapter2);
recyclerView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       if(arrayList.get(1).getTitle()=="بازه زمانی قفل صفحه"){
           Toast.makeText(recyclerView.getContext(), "fsfetret", Toast.LENGTH_SHORT).show();
       }
    }
});

             return view;

    }
    private void dataset(){

        arrayList=new ArrayList<>();
        arrayList.add(new Settings("بازه زمانی قفل صفحه",Settings.ONE_TYPE,R.drawable.ic_access_alarm_black_24dp,"60ثانیه"));
        arrayList.add(new Settings("روش احراز هویت",Settings.ONE_TYPE,R.drawable.ic_forward_10_black_24dp,"الگو"));
        arrayList.add(new Settings("راهنمای برنامه",Settings.Two_TYPE,R.drawable.ic_home_black_24dp,null));
        arrayList.add(new Settings("پشتیبانی بانک ها",Settings.Two_TYPE,R.drawable.ic_call_black_24dp,null));

    }


}
