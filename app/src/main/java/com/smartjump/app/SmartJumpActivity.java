package com.smartjump.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.smartjump.app.service.SmartJumpService;

/**
 *
 */
public class SmartJumpActivity extends AppCompatActivity {

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
