package com.smartjump.app.presenter;

import android.location.Location;
import android.util.Log;

import com.smartjump.app.di.LifeScope;
import com.smartjump.domain.interactor.GetNearStations;
import com.smartjump.domain.model.Jump;
import com.smartjump.domain.model.UserLocation;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 *
 */
@LifeScope
public class ServicePresenter {
    private static final String TAG = ServicePresenter.class.getSimpleName();

    private final GetNearStations getNearStations;

    @Inject
    public ServicePresenter(GetNearStations getNearStations) {
        this.getNearStations = getNearStations;
    }

    public void getFrom(Location location) {
        getNearStations.execute(new DisposableObserver<List<Jump>>() {
            @Override
            public void onNext(@NonNull List<Jump> jumps) {
                Log.d(TAG, "onNext: ");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        }, new UserLocation(location.getLatitude(), location.getLongitude(), 100f));
    }
}
