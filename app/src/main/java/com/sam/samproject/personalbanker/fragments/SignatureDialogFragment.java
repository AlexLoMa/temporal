package com.sam.samproject.personalbanker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.sam.samproject.R;

public class SignatureDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button clearButton;
    private SignaturePad mSignaturePad;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.signature_layout,container,false);
        clearButton = view.findViewById(R.id.clear_button);
        mSignaturePad = view.findViewById(R.id.signature_pad);
        clearButton.setOnClickListener(this);
        return view;

    }

    @Override
    public void onStart() {
        getDialog().getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes(params);
        super.onStart();
    }

    @Override
    public void onClick(View view) {

        mSignaturePad.clear();
    }
}
