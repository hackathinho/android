package com.smartjump.app.activity;

import android.content.Intent;
import android.os.Bundle;

import com.smartjump.app.R;
import com.smartjump.app.SmartJumpApplication;
import com.smartjump.app.service.SmartJumpService;

/**
 *
 */
public class SmartJumpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        application().getApplicationComponent().inject(this);
        startService();
    }

    private void startService() {
        final Intent intent = new Intent(this, SmartJumpService.class);
        startService(intent);
    }

    private SmartJumpApplication application() {
        return (SmartJumpApplication) getApplication();
    }
}
