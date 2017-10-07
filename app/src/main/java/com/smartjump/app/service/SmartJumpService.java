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

/**
 *
 */
public class SmartJumpService extends Service implements LocationUpdates.LocationCallback {
    private static final String TAG = SmartJumpService.class.getSimpleName();

    private static final int NOTIFICATION_ID = 981;
    private static final int REQUEST_CODE = 189;

    private LocationUpdates locationUpdates;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Start service in foreground...");

        application().getApplicationComponent().inject(this);

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
        updateNotification();
    }

    private void updateNotification() {
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(getString(R.string.title_location_found))
                .setContentIntent(openWhenClick())
                .setSmallIcon(R.drawable.bus)
                .build();
        startForeground(NOTIFICATION_ID, notification);
    }

    @Override
    public void onMissingPermission() {

    }
}
