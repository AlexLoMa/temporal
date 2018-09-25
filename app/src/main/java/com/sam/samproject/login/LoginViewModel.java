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

import com.sam.samproject.base.BaseViewModel;
import com.sam.samproject.branchmanager.BranchManagerActivity;
import com.sam.samproject.relationmanager.RelationshipManagerActivity;

public class LoginViewModel extends BaseViewModel {
    private String roles[];
    private ObservableField<String> text;
    private ObservableField<String> strUserName;
    private ObservableField<String> strUserPassword;

    public LoginViewModel() {
        text = new ObservableField<>();
        strUserName = new ObservableField<>();
        strUserPassword = new ObservableField<>();
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
    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    public static String captureSelectedValue(AppCompatSpinner pAppCompatSpinner) {
        return (String) pAppCompatSpinner.getSelectedItem();
    }
    @BindingAdapter(value = {"selectedValue", "selectedValueAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(AppCompatSpinner pAppCompatSpinner, String newSelectedValue, final InverseBindingListener newTextAttrChanged) {
        pAppCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    public void onLogin(View v){
        if(strUserName.get()==null || strUserName.get().trim().length()==0){
            Toast.makeText(v.getContext(),"Please Enter User Name.",Toast.LENGTH_LONG).show();
            return;
        }
        if(strUserPassword.get()==null || strUserPassword.get().trim().length()==0){
            Toast.makeText(v.getContext(),"Please Enter User Password.",Toast.LENGTH_LONG).show();
            return;
        }
        if(text.get().toString().contains("Relationship Manager")){
            (v.getContext()).startActivity(new Intent(v.getContext(),RelationshipManagerActivity.class));
        }else if(text.get().toString().contains("Personal Banker + Financial Advisor")){
            Toast.makeText(v.getContext(),"Personal Banker + Financial Advisor Under development",Toast.LENGTH_LONG).show();
        }else if(text.get().toString().contains("Branch Manager")){
            (v.getContext()).startActivity(new Intent(v.getContext(),BranchManagerActivity.class));
        }else{
            Toast.makeText(v.getContext(),"Please select role",Toast.LENGTH_LONG).show();
        }
    }
}