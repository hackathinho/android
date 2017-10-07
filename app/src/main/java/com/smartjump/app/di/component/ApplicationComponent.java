package com.smartjump.app.di.component;

import com.smartjump.app.di.LifeScope;
import com.smartjump.app.di.module.ApplicationModule;

import dagger.Component;

/**
 *
 */
@LifeScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

}
