package com.sam.samproject.personalbanker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.personalbanker.fragments.AccountOpenFragment;
import com.sam.samproject.personalbanker.fragments.CalendarFragment;
import com.sam.samproject.personalbanker.fragments.CrmFragment;
import com.sam.samproject.personalbanker.fragments.EmailFragment;
import com.sam.samproject.personalbanker.fragments.StocksFragment;

public class PersonalBankerActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_banker);
        findViewById(R.id.pb_calendar).setOnClickListener(this);
        findViewById(R.id.pb_email).setOnClickListener(this);
        findViewById(R.id.account_open).setOnClickListener(this);
        findViewById(R.id.crm).setOnClickListener(this);
        findViewById(R.id.pb_stocks).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.
                    pb_calendar: showFragment(new CalendarFragment(), true, null);
                break;
            case R.id.pb_email:
                showFragment(new EmailFragment(), true, null);
                break;
            case R.id.crm:
                showFragment(new CrmFragment(), true, null);
                break;
            case R.id.account_open:
                showFragment(new AccountOpenFragment(), true, null);
                break;
            case R.id.pb_stocks:
                showFragment(new StocksFragment(), true, null);
                break;

        }
    }

    private void showFragment(Fragment fragment, boolean addToBackStack, Bundle bundle
    ) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_root, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        fragmentTransaction.commit();
    }



}
