package com.smartjump.app.activity;

import android.support.v7.app.AppCompatActivity;

import com.smartjump.app.SmartJumpApplication;

/**
 *
 */
public class BaseActivity extends AppCompatActivity {

    protected SmartJumpApplication application() {
        return (SmartJumpApplication) getApplication();
    }

}
