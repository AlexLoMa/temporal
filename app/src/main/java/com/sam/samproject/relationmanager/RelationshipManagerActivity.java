package com.sam.samproject.relationmanager;

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
import com.sam.samproject.branchmanager.BranchManagerActivity;
import com.sam.samproject.personalbanker.PersonalBankerActivity;
import com.sam.samproject.relationmanager.fragment.CRMSummaryFragment;
import com.sam.samproject.relationmanager.fragment.ElectronicQueueFragment;
import com.sam.samproject.relationmanager.fragment.FastCheckDepositeFragment;
import com.sam.samproject.relationmanager.fragment.UsingTheMobileAppFragment;
import com.sam.samproject.utils.Utils;

public class RelationshipManagerActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    private ImageView btnBack;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set to get the title on the toolbar when rm opens up
        setTitle(Utils.getUserName() +" " + getString(R.string.dashboard));
        setContentView(R.layout.activity_relationship_manager_1);
        findViewById(R.id.mortage_app).setOnClickListener(this);
        findViewById(R.id.email).setOnClickListener(this);
        findViewById(R.id.calender).setOnClickListener(this);
        findViewById(R.id.crm).setOnClickListener(this);
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
    @Override
    public void onClick(View view) {
        //In RM if any of the tile is clicked this section will replace the fragment according to the tile selected.
        switch (view.getId()){
            case R.id.mortage_app:
                showFragment(new UsingTheMobileAppFragment(), true);
                break;
            case R.id.email:
                showFragment(new ElectronicQueueFragment(), true);
                break;
            case R.id.calender:
                showFragment(new FastCheckDepositeFragment(), true);
                break;
            case R.id.crm:
                showFragment(new CRMSummaryFragment(), true);
                break;
        }
    }

    private void showFragment(Fragment fragment, boolean addToBackStack) {
        //This will help to replace the fragments on root activity layout.
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
        }else if(i==2){
            startActivity(new Intent(this, BranchManagerActivity.class));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
