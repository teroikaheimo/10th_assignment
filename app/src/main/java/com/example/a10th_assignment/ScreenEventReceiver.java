package com.example.a10th_assignment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Objects;

public class ScreenEventReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), Intent.ACTION_SCREEN_OFF)) {
            startStatusIntent(false, context);
        } else if (Objects.equals(intent.getAction(), Intent.ACTION_SCREEN_ON)) {
            startStatusIntent(true, context);
        }
    }

    private void startStatusIntent(boolean status, Context context) {
        Intent serviceIntent = new Intent(context, IntentScreenStateSaver.class);
        serviceIntent.putExtra("screenStatus", status);
        context.startService(serviceIntent);
    }
}
