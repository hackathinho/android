package com.smartjump.app.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.smartjump.app.R;
import com.smartjump.app.SmartJumpApplication;
import com.smartjump.app.activity.NotificationResultActivity;
import com.smartjump.app.presenter.LocationUpdates;
import com.smartjump.app.presenter.ServicePresenter;
import com.smartjump.domain.model.BicycleStation;
import com.smartjump.domain.model.BusStation;

import java.util.List;

import javax.inject.Inject;

/**
 *
 */
public class SmartJumpService extends Service implements LocationUpdates.LocationCallback,
        ServicePresenter.ResultCallback {
    private static final String TAG = SmartJumpService.class.getSimpleName();

    private static final int NOTIFICATION_ID = 981;
    private static final int REQUEST_CODE = 189;

    private LocationUpdates locationUpdates;

    @Inject
    protected ServicePresenter servicePresenter;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Start service in foreground...");

        application().getApplicationComponent().inject(this);
        servicePresenter.setResultCallback(this);

        // start location
        locationUpdates = new LocationUpdates(this, this);
        locationUpdates.startLocation();

        initServiceForeground();
    }

    private void initServiceForeground() {
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(getString(R.string.title_notification_search))
                .setContentIntent(openWhenClick())
                .setSmallIcon(R.drawable.bus)
                .build();
        startForeground(NOTIFICATION_ID, notification);
    }

    private PendingIntent openWhenClick() {
        final Intent intent = new Intent(this, NotificationResultActivity.class);
        return PendingIntent.getActivity(
                this, REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private SmartJumpApplication application() {
        return (SmartJumpApplication) getApplication();
    }

    @Override
    public void onDestroy() {
        locationUpdates.stop();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocation(Location location) {
        servicePresenter.getFrom(location);
    }

    private void updateNotification(String msg) {
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(msg)
                .setContentIntent(openWhenClick())
                .setSmallIcon(R.drawable.bus)
                .build();
        startForeground(NOTIFICATION_ID, notification);
    }

    @Override
    public void onMissingPermission() {

    }

    @Override
    public void onJumpsFound(List<BusStation> busStations, List<BicycleStation> bicycleStations) {
        String msg = String.format("Se han encontrado %s parades de bus y %s de bici cerca de ti",
                busStations.size(), bicycleStations.size());
        updateNotification(msg);
    }
}
