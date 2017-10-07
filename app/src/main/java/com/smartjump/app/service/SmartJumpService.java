package com.smartjump.app.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.smartjump.app.R;

/**
 *
 */
public class SmartJumpService extends Service {
    private static final String TAG = SmartJumpService.class.getSimpleName();

    private static final int NOTIFICATION_ID = 981;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Start service in foreground...");

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.bus)
                .build();
        startForeground(NOTIFICATION_ID, notification);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
