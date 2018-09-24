package com.sam.samproject.login;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.databinding.ActivityLoginBinding;
import com.sam.samproject.viewmodels.LoginViewModel;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setViewmodel(viewModel);
        binding.getViewmodel().setRoles(getRoles());
    }

    private String[] getRoles(){
        return getResources().getStringArray(R.array.role);
    }
}
