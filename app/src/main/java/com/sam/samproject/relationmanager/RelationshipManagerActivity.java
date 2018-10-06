package com.sam.samproject.relationmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.relationmanager.fragment.CRMSummaryFragment;
import com.sam.samproject.relationmanager.fragment.ElectronicQueueFragment;
import com.sam.samproject.relationmanager.fragment.FastCheckDepositeFragment;
import com.sam.samproject.relationmanager.fragment.UsingTheMobileAppFragment;
import com.sam.samproject.utils.Utils;

public class RelationshipManagerActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set to get the title on the toolbar when rm opens up
        setTitle(Utils.getUserName() +" " + getString(R.string.dashboard));
        setContentView(R.layout.activity_relationship_manager);
        findViewById(R.id.rlshUsingMobileApp).setOnClickListener(this);
        findViewById(R.id.rlshElectronicQueue).setOnClickListener(this);
        findViewById(R.id.rlshFastCheckDepo).setOnClickListener(this);
        findViewById(R.id.rlshCRMSummary).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //In RM if any of the tile is clicked this section will replace the fragment according to the tile selected.
        switch (view.getId()){
            case R.id.rlshUsingMobileApp:
                showFragment(new UsingTheMobileAppFragment(), true);
                break;
            case R.id.rlshElectronicQueue:
                showFragment(new ElectronicQueueFragment(), true);
                break;
            case R.id.rlshFastCheckDepo:
                showFragment(new FastCheckDepositeFragment(), true);
                break;
            case R.id.rlshCRMSummary:
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
}
