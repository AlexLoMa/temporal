package com.sam.samproject.di;

/**
 * Created by Alejandro Lopez on 23/09/2018.
 */

import com.sam.samproject.branchmanager.BranchManagerActivity;
import com.sam.samproject.branchmanager.BranchManagerActivityModule;
import com.sam.samproject.branchmanager.fragment.BranchManagerFragmentModule;
import com.sam.samproject.login.LoginActivity;
import com.sam.samproject.login.LoginActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {BranchManagerActivityModule.class, BranchManagerFragmentModule.class})
    abstract BranchManagerActivity bindBranchManagerActivity();
}
