package com.sam.samproject.di;

/**
 * Created by Alejandro Lopez on 23/09/2018.
 */

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }
}
