package com.smartjump.app.di.module;

import com.smartjump.app.SmartJumpApplication;
import com.smartjump.app.di.LifeScope;
import com.smartjump.app.executor.DefaultMainThread;
import com.smartjump.app.executor.DefaultThreadExecutor;
import com.smartjump.app.navigation.Navigator;
import com.smartjump.domain.MainThread;
import com.smartjump.domain.ThreadExecutor;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module(includes = NetworkModule.class)
public class ApplicationModule {

    private final SmartJumpApplication application;

    public ApplicationModule(SmartJumpApplication application) {
        this.application = application;
    }

    @LifeScope
    @Provides
    MainThread provideMainThread(DefaultMainThread mainThread) {
        return mainThread;
    }

    @LifeScope
    @Provides
    ThreadExecutor provideThreadExecutor(DefaultThreadExecutor threadExecutor) {
        return threadExecutor;
    }

    @LifeScope
    @Provides
    Navigator provideNavigation(SmartJumpApplication application) {
        return new Navigator(application);
    }

    public SmartJumpApplication getApplication() {
        return application;
    }
}
