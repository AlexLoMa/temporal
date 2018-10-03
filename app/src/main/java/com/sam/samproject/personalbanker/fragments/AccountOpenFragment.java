package com.sam.samproject.personalbanker.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseFragment;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

public class AccountOpenFragment extends BaseFragment implements View.OnClickListener, View.OnFocusChangeListener {
    private Bitmap bitmap;
    private ImageView imageView;
    private EditText firstName;
    private EditText lastName;
    private EditText dob;
    private EditText cellNum;
    private EditText emailAdd;
    private EditText zipCode;
    private EditText lifeInsurance;
    private TextInputLayout textInputLayout;
    private View rootView;

    @Override
    protected int layoutResource() {
        return R.layout.fragment_customer_form;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

        firstName.setOnClickListener(this);
        lastName.setOnClickListener(this);
        dob.setOnClickListener(this);
        cellNum.setOnClickListener(this);
        zipCode.setOnClickListener(this);
        lifeInsurance.setOnClickListener(this);
        view.findViewById(R.id.submit).setOnClickListener(this);
        rootView = view;
    }

    void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        if (this.bitmap != null)
            imageView.setImageBitmap(this.bitmap);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_name:
            case R.id.last_name:
            case R.id.birth_date:
            case R.id.cellno:
            case R.id.emailadd:
            case R.id.life_insurance:
                textInputLayout.setError(null);
                break;
            case R.id.submit:
                rootView.findViewById(R.id.submit).setFocusable(true);
                rootView.findViewById(R.id.submit).requestFocus();
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
        if (firstName.getText().toString().isEmpty()) {
            textInputLayout = rootView.findViewById(R.id.firstname);
            textInputLayout.setError("FirstName is Required");
            firstName.setOnFocusChangeListener(this);
            return false;
        } else if (lastName.getText().toString().isEmpty()) {
            textInputLayout = rootView.findViewById(R.id.lastname);
            textInputLayout.setError("LastName is Required");
            lastName.setOnFocusChangeListener(this);
            return false;
        } else if (dob.getText().toString().isEmpty()) {
            textInputLayout = rootView.findViewById(R.id.birthdate);
            textInputLayout.setError("Date Of Birth is Required");
            dob.setOnFocusChangeListener(this);
            return false;
        } else if (cellNum.getText().toString().isEmpty()) {
            textInputLayout = rootView.findViewById(R.id.cell_num);
            textInputLayout.setError("CellNumber is Required");
            cellNum.setOnFocusChangeListener(this);
            return false;
        } else if (emailAdd.getText().toString().isEmpty()) {
            textInputLayout = rootView.findViewById(R.id.email_address);
            textInputLayout.setError("EmailAddress is Required");
            emailAdd.setOnFocusChangeListener(this);
            return false;
        } else if (zipCode.getText().toString().isEmpty()) {
            textInputLayout = rootView.findViewById(R.id.zip_code);
            textInputLayout.setError("ZipCode is Required");
            zipCode.setOnFocusChangeListener(this);
            return false;
        } else if (lifeInsurance.getText().toString().isEmpty()) {
            textInputLayout = rootView.findViewById(R.id.life_insurance);
            textInputLayout.setError("Insurance Number is Required");
            lifeInsurance.setOnFocusChangeListener(this);
            return false;
        }
        textInputLayout = null;
        return true;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b)
            textInputLayout.setError(null);
    }
}
