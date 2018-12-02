package com.sam.samproject.branchmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.branchmanager.fragment.EmailFragment;
import com.sam.samproject.branchmanager.fragment.PerformanceFragment;
import com.sam.samproject.branchmanager.fragment.StaffingFragment;
import com.sam.samproject.branchmanager.fragment.StocksFragment;
import com.sam.samproject.personalbanker.PersonalBankerActivity;
import com.sam.samproject.relationmanager.RelationshipManagerActivity;
import com.sam.samproject.utils.Utils;

public class BranchManagerActivity extends BaseActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener{


    private ImageView btnBack;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set to get the title on the toolbar when branchmanager opens up
        setTitle(Utils.getUserName() +" " + getString(R.string.dashboard));
        setContentView(R.layout.activity_branch_manager_1);
        findViewById(R.id.calender).setOnClickListener(this);
        findViewById(R.id.email).setOnClickListener(this);
        findViewById(R.id.crm).setOnClickListener(this);
        findViewById(R.id.mortage_app).setOnClickListener(this);
        findViewById(R.id.stock).setOnClickListener(this);

        AppCompatSpinner spinner = findViewById(R.id.spRole);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item_view_personal,getRoles());
        spinner.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

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
        dot = findViewById(R.id.dot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPopupButtonClick(dot);
            }
        });
        popupWindow = new PopupWindow(getLayoutInflater().inflate(R.layout.profile_view,null,false), 400, RelativeLayout.LayoutParams.WRAP_CONTENT);
    }

    private ImageView dot;
    PopupWindow popupWindow;
    public void onPopupButtonClick(View button) {

        //popupWindow.showAtLocation(dot, Gravity.CENTER,0,0);
        if(popupWindow.isShowing()){
            popupWindow.dismiss();
        }else{
            popupWindow.setAttachedInDecor(true);
            popupWindow.showAsDropDown(dot);
        }

    }

    private String[] getRoles(){ // will help to get the roles selected from dropdown menu
        return getResources().getStringArray(R.array.role_personal);
    }
    // onclick listener to open up the tiles on branch manager
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calender:
                btnBack.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                showFragment(new com.sam.samproject.personalbanker.fragments.CalendarFragment(), true);
                break;
            case R.id.email:
                btnBack.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                showFragment(new EmailFragment(), true);
                break;
            case R.id.crm:
                btnBack.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                showFragment(new PerformanceFragment(), true);
                break;
            case R.id.mortage_app:
                btnBack.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
                showFragment(new StaffingFragment(), true);
                break;
            case R.id.stock:
                btnBack.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.VISIBLE);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0){
            startActivity(new Intent(this, PersonalBankerActivity.class));
        }else if(i==1){
            startActivity(new Intent(this, RelationshipManagerActivity.class));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
