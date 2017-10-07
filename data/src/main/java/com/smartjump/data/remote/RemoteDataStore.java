package com.smartjump.data.remote;

import com.smartjump.data.DataSource;
import com.smartjump.data.entity.Location;
import com.smartjump.data.entity.Station;

import java.util.List;

import io.reactivex.Observable;

/**
 *
 */
public class RemoteDataStore implements DataSource {

    private final SmartJumpApi smartJumpApi;

    public RemoteDataStore(SmartJumpApi smartJumpApi) {
        this.smartJumpApi = smartJumpApi;
    }

    @Override
    public Observable<List<Station>> sendLocation(Location location) {
        return smartJumpApi.sendLocation(location);
    }
}
