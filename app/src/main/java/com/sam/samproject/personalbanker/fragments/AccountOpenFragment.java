package com.sam.samproject.personalbanker.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.sam.samproject.R;
import com.sam.samproject.base.BaseFragment;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountOpenFragment extends BaseFragment implements View.OnClickListener {
  /*  private SignaturePad mSignaturePad;
    private EditText firstName;
    private EditText lastName;
    private EditText dob;
    private EditText cellNum;
    private EditText emailAdd;
    private EditText zipCode;
    private EditText lifeInsurance;
    private View rootView;

    private TextView firstNameErrorMSg;
    private TextView lastNameErrorMSg;
    private TextView birthDateErrorMSg;
    private TextView emailAddressErrorMSg;
    private TextView cellErrorMSg;
    private TextView zipcodeErrorMsg;
    private TextView lifeinsuranceErrormsg; */

    private Button eSignButton;

    private Spinner monthspinner;

    @Override
    protected int layoutResource() {
        return R.layout.customerlayout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        eSignButton = view.findViewById(R.id.e_sign);

        monthspinner = view.findViewById(R.id.monthSpinner);
        addMonthSpinnerItems();
      /*  firstName = view.findViewById(R.id.first_name);
        lastName = view.findViewById(R.id.last_name);
        dob = view.findViewById(R.id.birth_date);
        cellNum = view.findViewById(R.id.cellno);
        emailAdd = view.findViewById(R.id.emailadd);
        zipCode = view.findViewById(R.id.zip_code);
        lifeInsurance = view.findViewById(R.id.life_insurance);
        mSignaturePad = view.findViewById(R.id.signature_pad);

        firstNameErrorMSg = view.findViewById(R.id.firstname_errormsg);
        lastNameErrorMSg = view.findViewById(R.id.lastname_errormsg);
        birthDateErrorMSg = view.findViewById(R.id.birthdate_errormsg);
        emailAddressErrorMSg = view.findViewById(R.id.email_errormsg);
        cellErrorMSg = view.findViewById(R.id.cell_errormsg);
        zipcodeErrorMsg = view.findViewById(R.id.zipcode_errormsg);
        lifeinsuranceErrormsg = view.findViewById(R.id.lifeinsurance_errormsg);

        firstName.setOnClickListener(this);
        lastName.setOnClickListener(this);
        dob.setOnClickListener(this);
        cellNum.setOnClickListener(this);
        zipCode.setOnClickListener(this);
        emailAdd.setOnClickListener(this);
        lifeInsurance.setOnClickListener(this);
        view.findViewById(R.id.submit).setOnClickListener(this);
        view.findViewById(R.id.clear).setOnClickListener(this);
        rootView = view; */
       eSignButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

            SignatureDialogFragment signatureDialogFragment = new SignatureDialogFragment();
              FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(SignatureDialogFragment.class.getSimpleName());

                   signatureDialogFragment.show(fragmentTransaction,"show");
        }

    private void addMonthSpinnerItems() {
        final List<String> monthsList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.arry_months)));
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, monthsList) {

            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthspinner.setAdapter(spinnerArrayAdapter);
    }


        // validation for mandatory fields

  /*  private Boolean validationSuccess() {
        boolean validationSuccess = true;
        if (firstName.getText().toString().isEmpty()) {
            firstName.setBackgroundResource(R.drawable.border_error);
            firstNameErrorMSg.setVisibility(View.VISIBLE);
            firstName.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (lastName.getText().toString().isEmpty()) {
            lastName.setBackgroundResource(R.drawable.border_error);
            lastNameErrorMSg.setVisibility(View.VISIBLE);
            lastName.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (dob.getText().toString().isEmpty()) {
            dob.setBackgroundResource(R.drawable.border_error);
            birthDateErrorMSg.setVisibility(View.VISIBLE);
            dob.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (cellNum.getText().toString().isEmpty()) {
            cellNum.setBackgroundResource(R.drawable.border_error);
            cellErrorMSg.setVisibility(View.VISIBLE);
            cellNum.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (emailAdd.getText().toString().isEmpty()) {
            emailAdd.setBackgroundResource(R.drawable.border_error);
            emailAddressErrorMSg.setVisibility(View.VISIBLE);
            emailAdd.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (zipCode.getText().toString().isEmpty()) {
            zipCode.setBackgroundResource(R.drawable.border_error);
            zipcodeErrorMsg.setVisibility(View.VISIBLE);
            zipCode.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        if (lifeInsurance.getText().toString().isEmpty()) {
            lifeInsurance.setBackgroundResource(R.drawable.border_error);
            lifeinsuranceErrormsg.setVisibility(View.VISIBLE);
            lifeInsurance.setOnFocusChangeListener(this);
            validationSuccess = false;
        }
        return validationSuccess;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (hasFocus) {
            setFieldsToDefaultView(view);
        }

    }

    private void setFieldsToDefaultView(View view) {
        switch (view.getId()) {
            case R.id.first_name:
                firstName.setBackgroundResource(R.drawable.border);
                firstNameErrorMSg.setVisibility(View.GONE);
                break;
            case R.id.last_name:
                lastName.setBackgroundResource(R.drawable.border);
                lastNameErrorMSg.setVisibility(View.GONE);
                break;
            case R.id.birth_date:
                dob.setBackgroundResource(R.drawable.border);
                birthDateErrorMSg.setVisibility(View.GONE);
                break;
            case R.id.emailadd:
                emailAdd.setBackgroundResource(R.drawable.border);
                emailAddressErrorMSg.setVisibility(View.GONE);
                break;
            case R.id.cellno:
                cellNum.setBackgroundResource(R.drawable.border);
                cellErrorMSg.setVisibility(View.GONE);
                break;
            case R.id.zip_code:
                zipCode.setBackgroundResource(R.drawable.border);
                zipcodeErrorMsg.setVisibility(View.GONE);
                break;
            case R.id.life_insurance:
                lifeInsurance.setBackgroundResource(R.drawable.border);
                lifeinsuranceErrormsg.setVisibility(View.GONE);
                break;
        }
    } */

}
