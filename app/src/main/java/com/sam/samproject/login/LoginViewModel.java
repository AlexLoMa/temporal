package com.sam.samproject.login;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.ObservableField;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.sam.samproject.R;
import com.sam.samproject.SamApplication;
import com.sam.samproject.base.BaseViewModel;
import com.sam.samproject.branchmanager.BranchManagerActivity;
import com.sam.samproject.personalbanker.PersonalBankerActivity;
import com.sam.samproject.relationmanager.RelationshipManagerActivity;
import com.sam.samproject.utils.Utils;

public class LoginViewModel extends BaseViewModel {
    private String roles[];
    //set observable for the variables to update view.
    private ObservableField<String> text;
    private ObservableField<String> strUserName;
    private ObservableField<String> strUserPassword;

    public LoginViewModel() {
        text = new ObservableField<>();
        strUserName = new ObservableField<>();
        strUserPassword = new ObservableField<>();
    }

    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    public static String captureSelectedValue(AppCompatSpinner pAppCompatSpinner) {
        return (String) pAppCompatSpinner.getSelectedItem(); // get the selected item from spinner or drop down.
    }

    @BindingAdapter(value = {"selectedValue", "selectedValueAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(AppCompatSpinner pAppCompatSpinner, String newSelectedValue, final InverseBindingListener newTextAttrChanged) {
        pAppCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //This will help to set the selected item and change the attribute.
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newTextAttrChanged.onChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        if (newSelectedValue != null) {
            int pos = ((ArrayAdapter<String>) pAppCompatSpinner.getAdapter()).getPosition(newSelectedValue);
            pAppCompatSpinner.setSelection(pos, true);
        }
    }

    public ObservableField<String> getText() {
        return text;
    }

    public ObservableField<String> getStrUserName() {
        return strUserName;
    }

    public ObservableField<String> getStrUserPassword() {
        return strUserPassword;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public void onLogin(View v) {
        // when user clicks login will ask for the fields require if he will miss something then toast msg sown

        if (strUserName.get() == null || strUserName.get().trim().length() == 0) {
            Toast.makeText(v.getContext(), "Please Enter User Name.", Toast.LENGTH_LONG).show();
            return;
        }

        if (strUserPassword.get() == null || strUserPassword.get().trim().length() == 0) {
            Toast.makeText(v.getContext(), "Please Enter User Password.", Toast.LENGTH_LONG).show();
            return;
        }
        // set to get the username on toolbar
        Utils.setUserName(strUserName.get());

        LoginModel loginModel = new LoginModel();
        loginModel.setEmailId(strUserName.get());
        loginModel.setPassword(strUserPassword.get());
        SamApplication samApplication = (SamApplication) v.getContext().getApplicationContext();
        if (text.get().equals(v.getContext().getString(R.string.rel_manager))) { //If RM selected then go to RM screen using intent.
            loginModel.setUserType(1);
            if (samApplication.validateUser(loginModel)) {
                (v.getContext()).startActivity(new Intent(v.getContext(), RelationshipManagerActivity.class));
            } else {
                Toast.makeText(v.getContext(), "Invalid user name or password.", Toast.LENGTH_LONG).show();
            }

        } else if (text.get().equals(v.getContext().getString(R.string.personal_adv))) {//If PB selected then go to PB screen using intent.
            loginModel.setUserType(2);


            if (samApplication.validateUser(loginModel)) {
                Intent intent = new Intent(v.getContext(), PersonalBankerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            } else {
                Toast.makeText(v.getContext(), "Invalid user name or password.", Toast.LENGTH_LONG).show();
            }


        } else if (text.get().equals(v.getContext().getString(R.string.branch_manager))) {//If BM selected then go to BM screen using intent.
            loginModel.setUserType(3);
            if (samApplication.validateUser(loginModel)) {
                Intent intent = new Intent(v.getContext(), BranchManagerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            } else {
                Toast.makeText(v.getContext(), "Invalid user name or password.", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(v.getContext(), "Please select role", Toast.LENGTH_LONG).show();
            return;
        }


    }
}