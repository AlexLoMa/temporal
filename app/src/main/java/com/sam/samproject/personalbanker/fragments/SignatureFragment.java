package com.sam.samproject.personalbanker.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.sam.samproject.R;

public class SignatureFragment extends DialogFragment implements SignaturePad.OnSignedListener, View.OnClickListener {
    Bitmap bitmap = null;
    AccountOpenFragment accountOpenFragment;
    private SignaturePad mSignaturePad;

    public void setAccountFragment(AccountOpenFragment accountOpenFragment) {
        this.accountOpenFragment = accountOpenFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragement_signature, container, false);
        mSignaturePad = v.findViewById(R.id.signature_pad);
        v.findViewById(R.id.clear).setOnClickListener(this);
        v.findViewById(R.id.done).setOnClickListener(this);
        mSignaturePad.setOnSignedListener(this);
        return v;
    }

    @Override
    public void onStartSigning() {
        Log.w("Sign", "Signing Started");
    }

    @Override
    public void onSigned() {
        Log.w("Signed", "Signed");
    }

    @Override
    public void onClear() {
        Log.w("Sign", "Signing Cleared");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear:
                mSignaturePad.clear();
                break;
            case R.id.done:
                bitmap = mSignaturePad.getTransparentSignatureBitmap(true);

                if (bitmap != null) {
                    accountOpenFragment.setBimap(bitmap);
                    dismiss();
                }
                break;
        }
    }
}
