package com.sam.samproject.login;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login); //binding the layout
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setViewmodel(viewModel);
        binding.getViewmodel().setRoles(getRoles());
    }

    private String[] getRoles() { // will help to get the roles selected from dropdown menu
        return getResources().getStringArray(R.array.role);
    }
}
