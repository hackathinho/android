package com.smartjump.domain;

import io.reactivex.Scheduler;

/**
 *
 */
public interface MainThread {

    Scheduler scheduler();
}
