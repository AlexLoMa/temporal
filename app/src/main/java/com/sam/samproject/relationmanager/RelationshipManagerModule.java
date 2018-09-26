package com.sam.samproject.relationmanager;

import com.sam.samproject.personalbanker.fragments.AccountOpenFragment;
import com.sam.samproject.relationmanager.fragment.CRMSummaryFragment;
import com.sam.samproject.relationmanager.fragment.ElectronicQueueFragment;
import com.sam.samproject.relationmanager.fragment.FastCheckDepositeFragment;
import com.sam.samproject.relationmanager.fragment.UsingTheMobileAppFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RelationshipManagerModule {

    @ContributesAndroidInjector
    abstract CRMSummaryFragment bindCRMSummaryFragment();

    @ContributesAndroidInjector
    abstract ElectronicQueueFragment bindElectronicQueueFragment();

    @ContributesAndroidInjector
    abstract FastCheckDepositeFragment bindFastCheckDepositeFragment();

    @ContributesAndroidInjector
    abstract UsingTheMobileAppFragment bindUsingTheMobileAppFragment();
}
