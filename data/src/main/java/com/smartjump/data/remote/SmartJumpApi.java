package com.smartjump.data.remote;

import com.smartjump.data.entity.Location;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.POST;

/**
 *
 */
public interface SmartJumpApi {

    @POST("nearest")
    Observable<Response<ResponseBody>> sendLocation(Location location);
}
