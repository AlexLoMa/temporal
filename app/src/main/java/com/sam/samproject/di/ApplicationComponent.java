package com.sam.samproject.di;

/**
 * Created by Alejandro Lopez on 23/09/2018.
 */

import com.sam.samproject.SamApplication;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ActivityModule.class})
public interface ApplicationComponent extends AndroidInjector<SamApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<SamApplication> {
    }

}
