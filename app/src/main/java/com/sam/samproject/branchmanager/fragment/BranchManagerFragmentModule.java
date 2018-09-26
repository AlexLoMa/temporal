package com.sam.samproject.branchmanager.fragment;

/**
 * Created by Alejandro Lopez on 23/09/2018.
 */

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BranchManagerFragmentModule {

    @ContributesAndroidInjector
    abstract CalendarFragment bindCalendarFragment();

    @ContributesAndroidInjector
    abstract EmailFragment bindEmailFragment();

    @ContributesAndroidInjector
    abstract PerformanceFragment bindPerformanceFragment();

    @ContributesAndroidInjector
    abstract StaffingFragment bindStaffingFragment();

    @ContributesAndroidInjector
    abstract StocksFragment bindStocksFragment();

}
