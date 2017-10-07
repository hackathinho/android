package com.smartjump.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 *
 */
public class SmartJumpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        application().getApplicationComponent().inject(this);
    }

    private SmartJumpApplication application() {
        return (SmartJumpApplication) getApplication();
    }
}
