package com.smartjump.app.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.smartjump.app.R;
import com.smartjump.app.SmartJumpApplication;
import com.smartjump.app.service.SmartJumpService;

/**
 *
 */
public class SmartJumpActivity extends BaseActivity {

    private static final int REQUEST_CODE = 121;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        application().getApplicationComponent().inject(this);
        checkPermissions();
    }

    private void checkPermissions() {
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            String[] perms = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
            requestPermissions(perms, REQUEST_CODE);
        } else {
            startService();
            hideApplication();
            finish();
        }
    }

    private void hideApplication() {
        final PackageManager packageManager = getPackageManager();
        final ComponentName componentName = new ComponentName(this, SmartJumpActivity.class);
        packageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length == 0) {
            return;
        }
        if (requestCode != REQUEST_CODE) {
            return;
        }
        for (String permission : permissions) {
            for (int grantResult : grantResults) {
                if (permission.equals(Manifest.permission.ACCESS_FINE_LOCATION) && grantResult
                        == PackageManager.PERMISSION_GRANTED) {
                    startService();
                    hideApplication();
                    break;
                }
            }
        }
        checkPermissions();
    }

    private void startService() {
        final Intent intent = new Intent(this, SmartJumpService.class);
        startService(intent);
    }

    private SmartJumpApplication application() {
        return (SmartJumpApplication) getApplication();
    }
}
