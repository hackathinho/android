package com.smartjump.app.di.component;

import com.smartjump.app.activity.NotificationResultActivity;
import com.smartjump.app.activity.SmartJumpActivity;
import com.smartjump.app.di.LifeScope;
import com.smartjump.app.di.module.ApplicationModule;
import com.smartjump.app.di.module.NetworkModule;
import com.smartjump.app.service.SmartJumpService;
import com.smartjump.domain.MainThread;
import com.smartjump.domain.ThreadExecutor;

import dagger.Component;

/**
 *
 */
@LifeScope
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(SmartJumpActivity activity);

    void inject(NotificationResultActivity activity);

    void inject(SmartJumpService service);

    MainThread mainThread();

    ThreadExecutor threadExecutor();
}
