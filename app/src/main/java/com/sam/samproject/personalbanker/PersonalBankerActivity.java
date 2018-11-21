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
import com.sam.samproject.utils.Utils;

public class PersonalBankerActivity extends BaseActivity implements View.OnClickListener {

    private AccountOpenFragment accountOpenFragment = new AccountOpenFragment();
    private CalendarFragment calendarFragment = new CalendarFragment();
    private EmailFragment emailFragment = new EmailFragment();
    private CrmFragment crmFragment = new CrmFragment();
    private StocksFragment stocksFragment = new StocksFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set to get the title on the toolbar when personalbanker opens up
        setTitle(Utils.getUserName() +" " + getString(R.string.dashboard));
        setContentView(R.layout.activity_personal_banker_1);
        findViewById(R.id.calender).setOnClickListener(this);
        findViewById(R.id.email).setOnClickListener(this);
        findViewById(R.id.mortage_app).setOnClickListener(this);
        findViewById(R.id.crm).setOnClickListener(this);
        findViewById(R.id.stock).setOnClickListener(this);
    }

    // onclick listener to open up the different tiles on personal banker

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calender:
                if (!calendarFragment.isVisible()) {
                    showFragment(calendarFragment, true, null);
                }
                break;
            case R.id.email:
                if (!emailFragment.isVisible()) {
                    showFragment(emailFragment, true, null);
                }
                break;
            case R.id.crm:
                if (!crmFragment.isVisible()) {
                    showFragment(crmFragment, true, null);
                }
                break;
            case R.id.mortage_app:
                if (!accountOpenFragment.isVisible()) {
                    showFragment(accountOpenFragment, true, null);
                }
                break;
            case R.id.stock:
                if(!stocksFragment.isVisible()) {
                    showFragment(stocksFragment, true, null);
                }
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
