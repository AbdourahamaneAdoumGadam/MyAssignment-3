package com.example.myassignment3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class BatteryLevelReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float) scale * 100;

        if (batteryPct >= 90 && intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) != 0) {
            Toast.makeText(context, "Battery level is " + batteryPct + "% and charging", Toast.LENGTH_LONG).show();
            // Add your code to ring the phone here
        }
    }
}
