package com.sam.samproject.di;

/**
 * Created by Alejandro Lopez on 23/09/2018.
 */

import com.sam.samproject.branchmanager.BranchManagerActivity;
import com.sam.samproject.branchmanager.BranchManagerActivityModule;
import com.sam.samproject.branchmanager.fragment.BranchManagerFragmentModule;
import com.sam.samproject.login.LoginActivity;
import com.sam.samproject.login.LoginActivityModule;
import com.sam.samproject.personalbanker.NewsActivity;
import com.sam.samproject.personalbanker.PersonalBankerActivity;
import com.sam.samproject.personalbanker.PersonalBankerActivityModule;
import com.sam.samproject.personalbanker.SignatureActivity;
import com.sam.samproject.relationmanager.RelationshipManagerActivity;
import com.sam.samproject.relationmanager.RelationshipManagerModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {BranchManagerActivityModule.class, BranchManagerFragmentModule.class})
    abstract BranchManagerActivity bindBranchManagerActivity();

    @ContributesAndroidInjector(modules = PersonalBankerActivityModule.class)
    abstract PersonalBankerActivity bindPersonalBankerActivity();

    @ContributesAndroidInjector(modules = RelationshipManagerModule.class)
    abstract RelationshipManagerActivity bindRelationshipManagerActivity();

    @ContributesAndroidInjector
    abstract SignatureActivity bindSignatureActivity();

    @ContributesAndroidInjector
    abstract NewsActivity bindNewsActivity();
}
