package com.example.scanqr.ui.createQr;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

   private ImageView mImageView;
  private   EditText mEditText;
   private Helper mHelper;
 private   Toolbar mToolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.fragment_create_qr, container, false);
        mImageView = view.findViewById(R.id.image);
        mEditText = view.findViewById(R.id.edit);
        mToolbar=view.findViewById(R.id.my_toolbar);
        mHelper = new Helper();
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Bitmap(mEditText.getText().toString());
            }
        });


        return view;

    }
    public void Bitmap(String text) {

        Bitmap bitmap = null;
        try {
            bitmap = mHelper.textToImage(text, 500, 500);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        mImageView.setImageBitmap(bitmap);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }
}