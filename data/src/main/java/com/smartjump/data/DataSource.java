package com.smartjump.data;

import com.smartjump.data.entity.Location;
import com.smartjump.data.entity.Station;

import java.util.List;

import io.reactivex.Observable;

/**
 *
 */
public interface DataSource {

    Observable<List<Station>> sendLocation(Location location);
}
