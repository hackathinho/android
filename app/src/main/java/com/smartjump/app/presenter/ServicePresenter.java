package com.smartjump.app.presenter;

import android.location.Location;
import android.util.Log;

import com.smartjump.app.di.LifeScope;
import com.smartjump.domain.interactor.GetNearStations;
import com.smartjump.domain.model.BicycleStation;
import com.smartjump.domain.model.BusStation;
import com.smartjump.domain.model.Jump;
import com.smartjump.domain.model.UserLocation;

import java.util.ArrayList;
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

    public interface ResultCallback {
        void onJumpsFound(List<BusStation> busStations, List<BicycleStation> bicycleStations);
    }

    private ResultCallback resultCallback;

    private final GetNearStations getNearStations;

    @Inject
    public ServicePresenter(GetNearStations getNearStations) {
        this.getNearStations = getNearStations;
    }

    public void getFrom(Location location) {
        getNearStations.execute(new DisposableObserver<List<Jump>>() {
            @Override
            public void onNext(@NonNull List<Jump> jumps) {
                final List<BusStation> busStations = new ArrayList<>();
                final List<BicycleStation> bicycleStations = new ArrayList<>();

                for (Jump jump : jumps) {
                    if (jump instanceof BusStation) busStations.add((BusStation) jump);
                    if (jump instanceof BicycleStation) bicycleStations.add((BicycleStation) jump);
                }
                resultCallback.onJumpsFound(busStations, bicycleStations);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        }, new UserLocation(location.getLatitude(), location.getLongitude(), 100f));
    }

    public void setResultCallback(ResultCallback resultCallback) {
        this.resultCallback = resultCallback;
    }
}
