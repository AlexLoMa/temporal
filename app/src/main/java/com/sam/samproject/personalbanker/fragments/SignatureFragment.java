package com.sam.samproject.personalbanker.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.sam.samproject.R;
import com.sam.samproject.base.BaseFragment;

import java.io.ByteArrayOutputStream;

public class SignatureFragment extends BaseFragment implements SignaturePad.OnSignedListener, View.OnClickListener {
    Bitmap bitmap = null;
    private SignaturePad mSignaturePad;

    @Override
    protected int layoutResource() {
        return R.layout.fragement_signature;
    }

    @Override
    protected void initViews(View v) {
        super.initViews(v);
        mSignaturePad = v.findViewById(R.id.signature_pad);
        v.findViewById(R.id.clear).setOnClickListener(this);
        v.findViewById(R.id.done).setOnClickListener(this);
        mSignaturePad.setOnSignedListener(this);
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
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, new Intent().putExtra("sign", byteArray));
                    getActivity().getSupportFragmentManager().popBackStack(SignatureFragment.class.getSimpleName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    getActivity().getSupportFragmentManager().beginTransaction().commit();
                }
                break;
        }
    }
}
