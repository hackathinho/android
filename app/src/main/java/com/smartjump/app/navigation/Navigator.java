package com.smartjump.app.navigation;

import com.smartjump.app.SmartJumpApplication;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Singleton
public class Navigator {

    private final SmartJumpApplication app;

    @Inject
    public Navigator(SmartJumpApplication app) {
        this.app = app;
    }
}
