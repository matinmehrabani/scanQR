package com.example.scanqr.ui.Settings;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.scanqr.R;
import com.example.scanqr.model.Settings;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements settings.ui {

    RecyclerView recyclerView;
    MyAdapter2 myAdapter2;
    List<Settings> arrayList;
    CharSequence[] values = {" First Item ", " Second Item ", " Third Item "};
    android.support.v7.app.AlertDialog alertDialog1;
Settings settings;
String name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        dataset();
        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter2 = new MyAdapter2(arrayList,SettingsFragment.this);
        recyclerView.setAdapter(myAdapter2);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.get(1).getTitle() == "بازه زمانی قفل صفحه") {
                    Toast.makeText(recyclerView.getContext(), "fsfetret", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;

    }

    private void dataset() {

        arrayList = new ArrayList<>();
        arrayList.add(new Settings("بازه زمانی قفل صفحه", Settings.ONE_TYPE, R.drawable.ic_access_alarm_black_24dp,"60ثانیه"));
        arrayList.add(new Settings("روش احراز هویت", Settings.ONE_TYPE, R.drawable.ic_forward_10_black_24dp, "الگو"));
        arrayList.add(new Settings("راهنمای برنامه", Settings.Two_TYPE, R.drawable.ic_home_black_24dp, null));
        arrayList.add(new Settings("پشتیبانی بانک ها", Settings.Two_TYPE, R.drawable.ic_call_black_24dp, null));

    }

    @Override
    public void alert(List<Settings> list) {
//                                new AlertDialog.Builder(getContext())
//                                .setTitle("Delete entry")
//                                .setMessage("Are you sure you want to delete this entry?")
//
//                                // Specifying a listener allows you to take an action before dismissing the dialog.
//                                // The dialog is automatically dismissed when a dialog button is clicked.
//                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        // Continue with delete operation
//                                    }
//                                })
//
//                                // A null listener allows the button to dismiss the dialog and take no further action.
//                                .setNegativeButton(android.R.string.no, null)
//                                .setIcon(android.R.drawable.ic_dialog_alert)
//                                .show();

        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.radio_button);
        List<String> stringList=new ArrayList<>();  // here is list
        //for(int i=0;i<5;i++) {
        stringList.add("ثانیه" + (40));
        stringList.add("ثانیه" + (50));
        stringList.add("ثانیه" + (30));
        stringList.add("ثانیه" + (35));
        //}
        RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radio_group);

        for(int i=0;i<stringList.size();i++){
            RadioButton rb=new RadioButton(getContext()); // dynamically creating RadioButton and adding to RadioGroup.
            rb.setText(stringList.get(i));
            rg.addView(rb);
        }

        dialog.show();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);
                    if (btn.getId() == checkedId) {
                       // btn.getText().toString()
                        Toast.makeText(getContext(), btn.getText().toString(), Toast.LENGTH_SHORT).show();
      arrayList.get(0).setName(btn.getText().toString());
                        myAdapter2.notifyDataSetChanged();
                    }
                }
            }
        });


    }

    @Override
    public void change() {
        arrayList.get(1).setName("password");
        myAdapter2.notifyDataSetChanged();
    }

}
