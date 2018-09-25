package com.sam.samproject.personalbanker;

/**
 * Created by Alejandro Lopez on 23/09/2018.
 */


import com.sam.samproject.personalbanker.fragments.AccountOpenFragment;
import com.sam.samproject.personalbanker.fragments.CalendarFragment;
import com.sam.samproject.personalbanker.fragments.CrmFragment;
import com.sam.samproject.personalbanker.fragments.EmailFragment;
import com.sam.samproject.personalbanker.fragments.StocksFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PersonalBankerActivityModule {

    @ContributesAndroidInjector
    abstract AccountOpenFragment bindAccountOpenFragment();

    @ContributesAndroidInjector
    abstract CalendarFragment bindCalendarFragment();

    @ContributesAndroidInjector
    abstract CrmFragment bindCrmFragment();

    @ContributesAndroidInjector
    abstract EmailFragment bindEmailFragment();

    @ContributesAndroidInjector
    abstract StocksFragment bindStocksFragment();
}
