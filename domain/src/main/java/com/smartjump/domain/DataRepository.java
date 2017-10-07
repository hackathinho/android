package com.smartjump.domain;

import com.smartjump.domain.model.Jump;
import com.smartjump.domain.model.UserLocation;

import java.util.List;

import io.reactivex.Observable;

/**
 *
 */
public interface DataRepository {

    Observable<List<Jump>> userLocation(UserLocation userLocation);
}
