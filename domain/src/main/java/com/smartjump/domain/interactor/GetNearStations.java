package com.smartjump.domain.interactor;

import com.smartjump.domain.DataRepository;
import com.smartjump.domain.MainThread;
import com.smartjump.domain.ThreadExecutor;
import com.smartjump.domain.model.Jump;
import com.smartjump.domain.model.UserLocation;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 *
 */
public class GetNearStations extends BaseInteractor<List<Jump>, UserLocation> {

    private final DataRepository dataRepository;

    @Inject
    GetNearStations(MainThread mainThread, ThreadExecutor threadExecutor, DataRepository dataRepository) {
        super(mainThread, threadExecutor);
        this.dataRepository = dataRepository;
    }

    @Override
    Observable<List<Jump>> result(UserLocation params) {
        return dataRepository.userLocation(params);
    }
}
