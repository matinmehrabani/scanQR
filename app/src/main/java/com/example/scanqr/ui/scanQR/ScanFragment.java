package com.example.scanqr.ui.scanQR;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scanqr.MainActivity;
import com.example.scanqr.R;
import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanFragment extends Fragment implements ZXingScannerView.ResultHandler{

   private TextView mTextView;
    private ZXingScannerView mScannerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scan, container, false);

        mTextView=view.findViewById(R.id.textScan);
        mScannerView = (ZXingScannerView) view.findViewById(R.id.zx);

        mScannerView.setAspectTolerance(0.5f);

        return view;
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
        Log.v("djierue", rawResult.getBarcodeFormat().toString());


        mScannerView.resumeCameraPreview(this);
    }
}




