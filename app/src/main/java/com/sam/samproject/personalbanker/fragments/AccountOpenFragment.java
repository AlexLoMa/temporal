package com.sam.samproject.personalbanker.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseFragment;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

public class AccountOpenFragment extends BaseFragment implements View.OnClickListener {
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
        view.findViewById(R.id.txtSign).setOnClickListener(this);
        view.findViewById(R.id.submit).setOnClickListener(this);
        if (bitmap != null)
            imageView.setImageBitmap(bitmap);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK && requestCode == 202) {
            byte[] byteArray = data.getExtras().getByteArray("sign");
            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            if (bitmap != null)
                imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txtSign:
                    SignatureFragment signatureFragment = new SignatureFragment();
                    signatureFragment.setTargetFragment(AccountOpenFragment.this, 202);
                    ((PersonalBankerActivity) getActivity()).getSupportFragmentManager().beginTransaction()
                            .addToBackStack(SignatureFragment.class.getSimpleName())
                            .replace(R.id.activity_root, signatureFragment).commit();
                break;

            case R.id.submit:
                FormResponseFragment formResponseFragment = new FormResponseFragment();
                ((PersonalBankerActivity) getActivity()).getSupportFragmentManager().beginTransaction()
                        .addToBackStack(FormResponseFragment.class.getSimpleName())
                        .replace(R.id.activity_root,formResponseFragment).commit();
                break;
        }

    }
}
