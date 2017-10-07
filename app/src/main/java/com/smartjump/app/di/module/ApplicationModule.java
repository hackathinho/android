package com.smartjump.app.di.module;

import com.smartjump.app.SmartJumpApplication;
import com.smartjump.app.executor.DefaultMainThread;
import com.smartjump.app.executor.DefaultThreadExecutor;
import com.smartjump.domain.MainThread;
import com.smartjump.domain.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class ApplicationModule {

    private final SmartJumpApplication application;

    public ApplicationModule(SmartJumpApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    MainThread provideMainThread(DefaultMainThread mainThread) {
        return mainThread;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(DefaultThreadExecutor threadExecutor) {
        return threadExecutor;
    }
}
