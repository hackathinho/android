package com.smartjump.app;

import android.app.Application;

import com.smartjump.app.di.component.ApplicationComponent;
import com.smartjump.app.di.component.DaggerApplicationComponent;
import com.smartjump.app.di.module.ApplicationModule;
import com.smartjump.app.di.module.NetworkModule;

/**
 * Base application class
 */
public abstract class SmartJumpApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule("http://smartjump.ovh/"))
                .build();

        initialize();
    }

   /**
    *
    */
    abstract void initialize();
}