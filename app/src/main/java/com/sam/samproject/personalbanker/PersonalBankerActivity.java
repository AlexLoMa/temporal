package com.sam.samproject.personalbanker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.branchmanager.BranchManagerActivity;
import com.sam.samproject.personalbanker.fragments.AccountOpenFragment;
import com.sam.samproject.personalbanker.fragments.CalendarFragment;
import com.sam.samproject.personalbanker.fragments.CrmFragment;
import com.sam.samproject.personalbanker.fragments.EmailFragment;
import com.sam.samproject.personalbanker.fragments.StocksFragment;
import com.sam.samproject.relationmanager.RelationshipManagerActivity;
import com.sam.samproject.utils.Utils;

public class PersonalBankerActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private AccountOpenFragment accountOpenFragment = new AccountOpenFragment();
    private CalendarFragment calendarFragment = new CalendarFragment();
    private EmailFragment emailFragment = new EmailFragment();
    private CrmFragment crmFragment = new CrmFragment();
    private StocksFragment stocksFragment = new StocksFragment();
    private ImageView btnBack;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set to get the title on the toolbar when personalbanker opens up
        setTitle(Utils.getUserName() +" " + getString(R.string.dashboard));
        setContentView(R.layout.activity_personal_banker_1);
        findViewById(R.id.calender).setOnClickListener(this);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBack.setVisibility(View.GONE);
                frameLayout.setVisibility(View.GONE);
                onBackPressed();
            }
        });
        frameLayout = findViewById(R.id.activity_root);
        findViewById(R.id.email).setOnClickListener(this);
        findViewById(R.id.mortage_app).setOnClickListener(this);
        findViewById(R.id.crm).setOnClickListener(this);
        findViewById(R.id.stock).setOnClickListener(this);
        AppCompatSpinner spinner = findViewById(R.id.spRole);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item_view_personal,getRoles());
        spinner.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

    }

    // onclick listener to open up the different tiles on personal banker
    private String[] getRoles(){ // will help to get the roles selected from dropdown menu
        return getResources().getStringArray(R.array.role_personal);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calender:
                if (!calendarFragment.isVisible()) {
                    frameLayout.setVisibility(View.VISIBLE);
                    showFragment(calendarFragment, true, null);
                    btnBack.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.email:
                if (!emailFragment.isVisible()) {
                    frameLayout.setVisibility(View.VISIBLE);
                    showFragment(emailFragment, true, null);
                    btnBack.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.crm:
                if (!crmFragment.isVisible()) {
                    frameLayout.setVisibility(View.VISIBLE);
                    showFragment(crmFragment, true, null);
                    btnBack.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.mortage_app:
                if (!accountOpenFragment.isVisible()) {
                    frameLayout.setVisibility(View.VISIBLE);
                    showFragment(accountOpenFragment, true, null);
                    btnBack.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.stock:
                if(!stocksFragment.isVisible()) {
                    frameLayout.setVisibility(View.VISIBLE);
                    showFragment(stocksFragment, true, null);
                    btnBack.setVisibility(View.VISIBLE);
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


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==1){
            startActivity(new Intent(this, RelationshipManagerActivity.class));
        }else if(i==2){
            startActivity(new Intent(this, BranchManagerActivity.class));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
