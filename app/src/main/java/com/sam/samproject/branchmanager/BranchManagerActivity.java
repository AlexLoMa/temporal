package com.sam.samproject.branchmanager;

import com.sam.samproject.branchmanager.fragment.CalendarFragment;
import com.sam.samproject.branchmanager.fragment.EmailFragment;
import com.sam.samproject.branchmanager.fragment.PerformanceFragment;
import com.sam.samproject.branchmanager.fragment.StaffingFragment;
import com.sam.samproject.branchmanager.fragment.StocksFragment;
import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.utils.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class BranchManagerActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(Utils.getUserName() +" " + getString(R.string.dashboard));
        setContentView(R.layout.activity_branch_manager);
        findViewById(R.id.bnch_calendar).setOnClickListener(this);
        findViewById(R.id.bnch_email).setOnClickListener(this);
        findViewById(R.id.bnch_performance).setOnClickListener(this);
        findViewById(R.id.bnch_staffing).setOnClickListener(this);
        findViewById(R.id.bnch_stocks).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bnch_calendar:
                showFragment(new CalendarFragment(), true);
                break;
            case R.id.bnch_email:
                showFragment(new EmailFragment(), true);
                break;
            case R.id.bnch_performance:
                showFragment(new PerformanceFragment(), true);
                break;
            case R.id.bnch_staffing:
                showFragment(new StaffingFragment(), true);
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
