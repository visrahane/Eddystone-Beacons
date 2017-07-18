package com.vis.beacons.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;


/**
 * Created by Vis on 16-07-2017.
 */

public class BLEBackgroundScanService extends IntentService {

    public BLEBackgroundScanService()
    {
        super("BLEBackgroundScanService");
    }

    private static final String TAG = "BLEBackgroundScan";

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null)
        {
            Nearby.Messages.handleIntent(intent, new   MessageListener()
            {
                @Override public void onFound(Message message)
                {
                    Log.i(TAG, "Message found: " + message);
                    Log.i(TAG, "Message string: " + new String(message.getContent()));
                    Log.i(TAG, "Message namespaced type: " + message.getNamespace() +
                            "/" + message.getType());
                }
                @Override public void onLost(Message message)
                {
                    Log.i("TAG", "lost message = " + message);
                }
            });
        }
    }
}
