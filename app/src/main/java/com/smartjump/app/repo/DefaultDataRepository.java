package com.smartjump.app.repo;

import com.smartjump.data.entity.Location;
import com.smartjump.data.entity.Station;
import com.smartjump.data.remote.RemoteDataStore;
import com.smartjump.domain.DataRepository;
import com.smartjump.domain.model.BicycleStation;
import com.smartjump.domain.model.BusStation;
import com.smartjump.domain.model.Jump;
import com.smartjump.domain.model.UserLocation;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 *
 */
@Singleton
public class DefaultDataRepository implements DataRepository {

    private final RemoteDataStore remoteDataStore;

    @Inject
    public DefaultDataRepository(RemoteDataStore remoteDataStore) {
        this.remoteDataStore = remoteDataStore;
    }

    @Override
    public Observable<List<Jump>> userLocation(UserLocation userLocation) {
        return remoteDataStore.sendLocation(
                new Location(userLocation.getLatitude(), userLocation.getLongitude(), userLocation.getPrecision()))
                .flatMap(new Function<List<Station>, ObservableSource<List<Jump>>>() {
                    @Override
                    public ObservableSource<List<Jump>> apply(@NonNull List<Station> stations) throws Exception {
                        return map(stations);
                    }
                });
    }

    private ObservableSource<List<Jump>> map(List<Station> stations) {
        final List<Jump> jumps = new ArrayList<>(stations.size());
        for (Station station : stations) {
            Jump jump = parseStationType(station);
            jumps.add(jump);
        }
        return Observable.just(jumps);
    }

    private Jump parseStationType(Station station) {
        String stationType = station.getType();
        if (stationType.equals("bus")) {
            BusStation busStation = new BusStation(station.getId(), station.getLatitude(),
                    station.getLongitude(), station.getDistance());
            return busStation;
        } else if (stationType.equals("bike")) {
            BicycleStation bikeStation = new BicycleStation(station.getId(), station.getLatitude(),
                    station.getLongitude(), station.getDistance());
            return bikeStation;
        } else {
            return null;
        }
    }
}
