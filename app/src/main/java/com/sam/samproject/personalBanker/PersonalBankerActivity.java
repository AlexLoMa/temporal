package com.sam.samproject.personalBanker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.personalBanker.fragments.AccountOpenFragment;
import com.sam.samproject.personalBanker.fragments.CalendarFragment;
import com.sam.samproject.personalBanker.fragments.CrmFragment;
import com.sam.samproject.personalBanker.fragments.EmailFragment;
import com.sam.samproject.personalBanker.fragments.StocksFragment;

public class PersonalBankerActivity extends BaseActivity  implements View.OnClickListener{
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
            case R.id.pb_calendar:
                showFragment(new CalendarFragment(), true);
                break;
            case R.id.pb_email:
                showFragment(new EmailFragment(), true);
                break;
            case R.id.crm:
                showFragment(new CrmFragment(), true);
                break;
            case R.id.account_open:
                showFragment(new AccountOpenFragment(), true);
                break;
            case R.id.pb_stocks:
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
