package com.example.scanqr.ui.scanQr;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.scanqr.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanFragment extends Fragment implements ZXingScannerView.ResultHandler, ScanInterface.view {

    private TextView mTextView;
    private ZXingScannerView mScannerView;
    private Toolbar mToolbar;
    private View mRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_scan, container, false);
        init();
        toolBar();
        return mRoot;
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {

        mTextView.setText(rawResult.getText());

        mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void init() {
        mTextView = mRoot.findViewById(R.id.textScan);
        mScannerView = mRoot.findViewById(R.id.zx);
        mToolbar = mRoot.findViewById(R.id.Toolbar_scan);
        mScannerView.setAspectTolerance(0.5f);
    }

    @Override
    public void toolBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("scan");
    }
}




