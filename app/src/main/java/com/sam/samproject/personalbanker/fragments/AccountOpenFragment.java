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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseFragment;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

public class AccountOpenFragment extends BaseFragment implements View.OnClickListener {
    private Bitmap bitmap;
    private ImageView imageView;
    private EditText firstName;
    private EditText lastName;
    private EditText dob;
    private EditText cellNum;
    private EditText emailAdd;
    private EditText zipCode;
    private EditText lifeInsurance;

    @Override
    protected int layoutResource() {
        return R.layout.fragment_customer_form;
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        imageView = view.findViewById(R.id.imgSign);
        firstName = view.findViewById(R.id.first_name);
        lastName = view.findViewById(R.id.last_name);
        dob = view.findViewById(R.id.birth_date);
        cellNum = view.findViewById(R.id.cellno);
        emailAdd = view.findViewById(R.id.emailadd);
        zipCode = view.findViewById(R.id.zip_code);
        lifeInsurance = view.findViewById(R.id.life_insurance);

        if (bitmap != null)
            imageView.setImageBitmap(bitmap);

        view.findViewById(R.id.txtSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment signatureFragment = new SignatureFragment();
                ((SignatureFragment) signatureFragment).setAccountFragment(AccountOpenFragment.this);
                signatureFragment.show(getFragmentManager(), "");
            }
        });

        view.findViewById(R.id.submit).setOnClickListener(this);
    }

    void setBimap(Bitmap bimap) {
        bitmap = bimap;
        if (bitmap != null)
            imageView.setImageBitmap(bitmap);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                if (validationSuccess()) {
                    FormResponseFragment formResponseFragment = new FormResponseFragment();
                    ((PersonalBankerActivity) getActivity()).getSupportFragmentManager().beginTransaction()
                            .addToBackStack(FormResponseFragment.class.getSimpleName())
                            .replace(R.id.activity_root, formResponseFragment).commit();
                    break;
                }
        }
    }

    private Boolean validationSuccess() {
        if (firstName.getText().toString().equalsIgnoreCase("")) {
            firstName.setError("Field cannot be empty");
            firstName.requestFocus();
            Toast.makeText(getContext().getApplicationContext(), "Please enter firstName", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (lastName.getText().toString().equalsIgnoreCase("")) {
                 lastName.setError("Field cannot be empty");
                 lastName.requestFocus();
                 Toast.makeText(getContext().getApplicationContext(), "Please enter lastName", Toast.LENGTH_SHORT).show();
                 return false;
        }
                else if (dob.getText().toString().equalsIgnoreCase("")){
                         dob.setError("Field cannot be empty");
                         dob.requestFocus();
                         Toast.makeText(getContext().getApplicationContext(),"Please enter date of birth",Toast.LENGTH_SHORT).show();
                         return false;
        }
                else if(cellNum.getText().toString().equalsIgnoreCase("")){
                        cellNum.setError("Field cannot be empty");
                        cellNum.requestFocus();
                        Toast.makeText(getContext().getApplicationContext(),"Please enter cell number",Toast.LENGTH_SHORT).show();
                        return  false;
        }
                else if(emailAdd.getText().toString().equalsIgnoreCase("")) {
                        emailAdd.setError("Field cannot be empty");
                        emailAdd.requestFocus();
                        Toast.makeText(getContext().getApplicationContext(), "Please enter email address", Toast.LENGTH_SHORT).show();
                        return false;
        }
                else if(zipCode.getText().toString().equalsIgnoreCase("")) {
                        zipCode.setError("Field cannot be empty");
                        zipCode.requestFocus();
                        Toast.makeText(getContext().getApplicationContext(), "Please enter Zipcode", Toast.LENGTH_SHORT).show();
                        return false;
        }
                else if(lifeInsurance.getText().toString().equalsIgnoreCase("")){
                        lifeInsurance.setError("Field cannot be empty");
                        lifeInsurance.requestFocus();
                        Toast.makeText(getContext().getApplicationContext(),"Please enter lifeinsurance details",Toast.LENGTH_SHORT).show();
                        return false;
        }

        return true;
    }

}
