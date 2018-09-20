package com.sam.samproject.BranchManager;

import com.sam.samproject.BranchManager.BranchManagerFragment.StocksFragment;
import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class BranchManagerActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_manager);
        findViewById(R.id.bnch_calendar).setOnClickListener(this);
        findViewById(R.id.bnch_email).setOnClickListener(this);
        findViewById(R.id.bnch_performance).setOnClickListener(this);
        findViewById(R.id.bnch_staffing).setOnClickListener(this);
        findViewById(R.id.bnch_stocks).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bnch_calendar:
                //TO-DO
                break;
            case R.id.bnch_email:
                //TO-DO
                break;
            case R.id.bnch_performance:
                //TO-DO
                break;
            case R.id.bnch_staffing:
                //TO-DO
                break;
            case R.id.bnch_stocks:
                showFragment(new StocksFragment(), true);
                break;

        }
    }

    private void showFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_root, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        fragmentTransaction.commit();
    }

}
