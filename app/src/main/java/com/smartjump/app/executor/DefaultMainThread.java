package com.smartjump.app.executor;


import com.smartjump.app.di.LifeScope;
import com.smartjump.domain.MainThread;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 *
 */
@LifeScope
public class DefaultMainThread implements MainThread {

    @Inject
    DefaultMainThread() {
        // required empty
    }

    @Override
    public Scheduler scheduler() {
        return AndroidSchedulers.mainThread();
    }
}
