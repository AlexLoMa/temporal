package com.sam.samproject.personalbanker.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.sam.samproject.R;
import com.sam.samproject.personalbanker.PersonalBankerActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountOpenFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener, View.OnFocusChangeListener {
    private Bitmap bitmap;
    private View rootView;
    private EditText firstName;
    private EditText workNumber;
    private EditText personalNumber;
    private EditText homeLandLineNumber;
    private EditText emailAddress;
    private EditText numDependents;
    private EditText zipCode;
    private TextView birthDate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey("sign")) {
            byte[] byteArray = getArguments().getByteArray("sign");
            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_form, container, false);
        if (bitmap != null)
            ((ImageView) view.findViewById(R.id.imgSign)).setImageBitmap(bitmap);

        view.findViewById(R.id.relSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PersonalBankerActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.activity_root, new SignatureFragment()).commit();
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.birthdate:
                showBirthDatePickerDialog();
                break;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;

        birthDate = view.findViewById(R.id.birthdate);
        birthDate.setOnClickListener(this);

        workNumber = rootView.findViewById(R.id.work_phone_number);
        workNumber.setOnFocusChangeListener(this);

        personalNumber = rootView.findViewById(R.id.personal_number);
        personalNumber.setOnFocusChangeListener(this);

        homeLandLineNumber = rootView.findViewById(R.id.landline_number);
        homeLandLineNumber.setOnFocusChangeListener(this);

        emailAddress = rootView.findViewById(R.id.personal_email_address);
        emailAddress.setOnFocusChangeListener(this);

        numDependents = rootView.findViewById(R.id.number_of_dependents);
        numDependents.setOnFocusChangeListener(this);

        zipCode = rootView.findViewById(R.id.us_zipcode);
        zipCode.setOnFocusChangeListener(this);

        firstName = rootView.findViewById(R.id.et_firstname);
        firstName.setOnFocusChangeListener(this);


    }

    private boolean isValidEmail(String emailAddress) {
        return (!TextUtils.isEmpty(emailAddress) && Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches());
    }

    private boolean isValidMobile(String phoneNumber) {
        return android.util.Patterns.PHONE.matcher(phoneNumber).matches();
    }

    private boolean isValidateUSPostCodes(String zipCode) {
        if (!TextUtils.isEmpty(zipCode)) {
            String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(zipCode);
            return (matcher.matches());
        } else {
            return false;
        }
    }

    private void updateSpinnerList() {
        Spinner s = (Spinner) rootView.findViewById(R.id.spin_salution);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.salutation));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s.setAdapter(adapter);
    }

    private void showBirthDatePickerDialog() {
        try {
            InputMethodManager nickNameInputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            nickNameInputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            Log.d("Demo", "Exception occured: " + e.getMessage());
        }
        Calendar c = Calendar.getInstance();
        DatePickerDialog dialog =
                new DatePickerDialog(getContext(), this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        dialog.setButton(DatePickerDialog.BUTTON_NEGATIVE, null, (DialogInterface.OnClickListener) null);
        dialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

   //  birthDate.setText((month+1)+"/"+dayOfMonth+"/"+year);
        Calendar cal = new GregorianCalendar(year,month,dayOfMonth);
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        String date = df.format(cal.getTime());
        birthDate.setText(date);

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b == true) {
            return;
        }
        EditText editText = ((EditText) view);
        switch (view.getId()) {
            case R.id.landline_number:
            case R.id.personal_number:
            case R.id.work_phone_number:
                if (isValidMobile(editText.getText().toString())) {
                    editText.setError(null);
                } else {
                    editText.setError("Invalid Phone Number");
                }
                break;
            case R.id.personal_email_address:
                if (isValidEmail(editText.getText().toString())) {
                    editText.setError(null);
                } else {
                    editText.setError("Invalid Email Address");
                }
                break;
            case R.id.number_of_dependents:
            case R.id.et_firstname:
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    editText.setError("Data Empty");
                } else {
                    editText.setError(null);
                }
                break;

            case R.id.us_zipcode:
                if (!isValidateUSPostCodes(editText.getText().toString())) {
                    editText.setError("Invalid Zipcode");
                } else {
                    editText.setError(null);
                }
                break;
        }
    }
}
