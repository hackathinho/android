package com.smartjump.app;

import android.app.Application;

/**
 * Base application class
 */
public abstract class SmartJumpApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

   /**
    *
    */
    abstract void initialize();
}