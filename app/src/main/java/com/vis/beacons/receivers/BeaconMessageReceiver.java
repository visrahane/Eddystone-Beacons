package com.vis.beacons.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;

/**
 * Created by Vis on 14-07-2017.
 */

public class BeaconMessageReceiver extends BroadcastReceiver {
    private static final String TAG = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        Nearby.Messages.handleIntent(intent, new MessageListener() {
            @Override
            public void onFound(Message message) {
                Log.i(TAG, "Message found: " + message);
                Log.i(TAG, "Message string: " + new String(message.getContent()));
                Log.i(TAG, "Message namespaced type: " + message.getNamespace() +
                        "/" + message.getType());
            }

            @Override
            public void onLost(Message message) {
                Log.i(TAG, "Lost message via PendingIntent: " + message);
            }
        });
    }
}
