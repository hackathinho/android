package com.smartjump.app.presenter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 *
 */
public class LocationUpdates implements LocationListener {
    private static final String TAG = LocationUpdates.class.getSimpleName();

    public interface LocationCallback {
        void onLocation(Location location);

        void onMissingPermission();
    }

    private final Context context;
    private final LocationCallback locationUpdates;
    private final LocationManager locationManager;

    public LocationUpdates(Context context, LocationCallback listener) {
        this.context = context;
        this.locationUpdates = listener;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public void startLocation() {
        Log.d(TAG, "Prepared to start location");
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            locationUpdates.onMissingPermission();
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
    }

    public void stop() {
        Log.d(TAG, "stop location updates");
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "onLocationChanged: " + location.toString());
        locationUpdates.onLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}
