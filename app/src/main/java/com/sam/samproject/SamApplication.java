package com.sam.samproject;

/**
 * Created by Alejandro Lopez Malvaez on 23/09/2018.
 */

import com.sam.samproject.di.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class SamApplication extends DaggerApplication{

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }

}
