package com.smartjump.data.remote;

import com.smartjump.data.entity.Location;
import com.smartjump.data.entity.Station;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 *
 */
public interface SmartJumpApi {

    @POST("nearest")
    Observable<List<Station>> sendLocation(@Body Location location);
}
