package com.bhavdip.learningpoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by Bhavdip Bhalodia on 10-10-2015.
 */
public class ServiceExample extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);
    }

    public void startService(View view) {
        startService(new Intent(ServiceExample.this, MyService.class));
    }

    public void stopService(View view) {

        Log.v("Service", getBaseContext().toString());
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}
