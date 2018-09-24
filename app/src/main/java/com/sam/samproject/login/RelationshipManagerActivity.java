package com.sam.samproject.login;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.databinding.ActivityRelationshipManagerBinding;
import com.sam.samproject.viewmodels.RelationshipManagerViewModel;

public class RelationshipManagerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRelationshipManagerBinding activityRelationshipManagerBinding = DataBindingUtil.setContentView(this, R.layout.activity_relationship_manager);
        RelationshipManagerViewModel relationshipManagerViewModel = ViewModelProviders.of(this).get(RelationshipManagerViewModel.class);
        activityRelationshipManagerBinding.setViewmodel(relationshipManagerViewModel);
    }
}
