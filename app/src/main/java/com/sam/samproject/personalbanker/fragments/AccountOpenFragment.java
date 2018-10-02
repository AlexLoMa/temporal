package com.sam.samproject.personalbanker.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.sam.samproject.R;
import com.sam.samproject.base.BaseFragment;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

public class AccountOpenFragment extends BaseFragment implements View.OnClickListener {
    private SignaturePad mSignaturePad;

    @Override
    protected int layoutResource() {
        return R.layout.fragment_customer_form;
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        mSignaturePad = view.findViewById(R.id.signature_pad);

        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.clear).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                Bitmap bitmap = mSignaturePad.getTransparentSignatureBitmap(true);

                FormResponseFragment formResponseFragment = new FormResponseFragment();
                ((PersonalBankerActivity) getActivity()).getSupportFragmentManager().beginTransaction()
                        .addToBackStack(FormResponseFragment.class.getSimpleName())
                        .replace(R.id.activity_root,formResponseFragment).commit();
                break;
            case R.id.clear:
                mSignaturePad.clear();
                break;
        }
    }

}
