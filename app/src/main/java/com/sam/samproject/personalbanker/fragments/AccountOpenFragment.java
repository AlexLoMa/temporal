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

    private Button eSignButton;
    private Button submitButton;
    private Spinner monthspinner;

    @Override
    protected int layoutResource() {
        return R.layout.customerlayout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        eSignButton = view.findViewById(R.id.e_sign);
        submitButton = view.findViewById(R.id.submit_button);
        monthspinner = view.findViewById(R.id.monthSpinner);
        addMonthSpinnerItems();
        eSignButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.e_sign:
                SignatureDialogFragment signatureDialogFragment = new SignatureDialogFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(SignatureDialogFragment.class.getSimpleName());

                signatureDialogFragment.show(fragmentTransaction, "signature");
                break;

            case R.id.submit_button:
                SuccessDialogFragment successDialogFragment = new SuccessDialogFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(SuccessDialogFragment.class.getSimpleName());
                successDialogFragment.show(ft,"success");
                break;
        }
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
}
