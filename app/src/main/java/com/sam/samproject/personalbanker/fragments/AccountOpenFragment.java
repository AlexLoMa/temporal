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

import com.sam.samproject.R;
import com.sam.samproject.base.BaseFragment;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

public class AccountOpenFragment extends BaseFragment {
    private Bitmap bitmap;
    private ImageView imageView;


    @Override
    protected int layoutResource() {
        return R.layout.fragment_customer_form;
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        imageView = view.findViewById(R.id.imgSign);

        if (bitmap != null)
            imageView.setImageBitmap(bitmap);
        view.findViewById(R.id.relSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment signatureFragment = new SignatureFragment();
                ((SignatureFragment) signatureFragment).setAccountFragment(AccountOpenFragment.this);
                signatureFragment.show(getFragmentManager(), "");
            }
        });
    }

    void setBimap(Bitmap bimap) {
        bitmap = bimap;
        if (bitmap != null)
            imageView.setImageBitmap(bitmap);

    }

}
