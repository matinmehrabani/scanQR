package com.example.scanqr.ui.CreateQR;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.scanqr.R;
import com.google.zxing.WriterException;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateQrFragment extends Fragment {

    ImageView imageView;
    EditText editText;
    Helper helper;
Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_create_qr, container, false);
        imageView = view.findViewById(R.id.image);
        editText = view.findViewById(R.id.edit);
        toolbar=view.findViewById(R.id.my_toolbar);
        helper = new Helper();
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Bitmap(editText.getText().toString());
            }
        });


        return view;

    }
    public void Bitmap(String text) {

        Bitmap bitmap = null;
        try {
            bitmap = helper.textToImage(text, 500, 500);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        imageView.setImageBitmap(bitmap);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }
}