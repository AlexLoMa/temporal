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
    private TextInputLayout textFirstNameInputLayout;
    private TextInputLayout textLastNameInputLayout;
    private TextInputLayout textDoBInputLayout;
    private TextInputLayout textEmailInputLayout;
    private TextInputLayout textCellNumberInputLayout;
    private TextInputLayout textInsuranceInputLayout;
    private TextInputLayout textZipcodeInputLayout;
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
        boolean validationSuccess = true;
        if (firstName.getText().toString().isEmpty()) {
            textFirstNameInputLayout = rootView.findViewById(R.id.firstname);
            textFirstNameInputLayout.setError("Required");
            firstName.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (lastName.getText().toString().isEmpty()) {
            textLastNameInputLayout = rootView.findViewById(R.id.lastname);
            textLastNameInputLayout.setError("Required");
            lastName.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (dob.getText().toString().isEmpty()) {
            textDoBInputLayout = rootView.findViewById(R.id.birthdate);
            textDoBInputLayout.setError("Required");
            dob.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (cellNum.getText().toString().isEmpty()) {
            textCellNumberInputLayout = rootView.findViewById(R.id.cell_num);
            textCellNumberInputLayout.setError("Required");
            cellNum.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (emailAdd.getText().toString().isEmpty()) {
            textEmailInputLayout = rootView.findViewById(R.id.email_address);
            textEmailInputLayout.setError("Required");
            emailAdd.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (zipCode.getText().toString().isEmpty()) {
            textZipcodeInputLayout = rootView.findViewById(R.id.zipcode);
            textZipcodeInputLayout.setError("Required");
            zipCode.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (lifeInsurance.getText().toString().isEmpty()) {
            textInsuranceInputLayout = rootView.findViewById(R.id.lifeinsurance);
            textInsuranceInputLayout.setError("Required");
            lifeInsurance.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        return validationSuccess;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (hasFocus) {
            switch (view.getId()) {
                case R.id.first_name:
                    textFirstNameInputLayout.setError(null);
                    break;
                case R.id.last_name:
                    textLastNameInputLayout.setError(null);
                    break;
                case R.id.birth_date:
                    textDoBInputLayout.setError(null);
                    break;
                case R.id.emailadd:
                    textEmailInputLayout.setError(null);
                    break;
                case R.id.cellno:
                    textCellNumberInputLayout.setError(null);
                    break;
                case R.id.zip_code:
                    textZipcodeInputLayout.setError(null);
                    break;
                case R.id.life_insurance:
                    textInsuranceInputLayout.setError(null);
                    break;
            }
        }

    }
}
