package com.vis.beacons.callbacks;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.vis.beacons.listeners.BeaconMessageListener;
import com.vis.beacons.receivers.BeaconMessageReceiver;



/**
 * Created by Vis on 14-07-2017.
 */

public class BeaconConnectionCallback implements GoogleApiClient.ConnectionCallbacks{

    private static final String TAG="";
    private GoogleApiClient googleApiClient;
    private FragmentActivity mainActivity;


    public BeaconConnectionCallback(FragmentActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    public GoogleApiClient getGoogleApiClient() {
        return googleApiClient;
    }

    public void setGoogleApiClient(GoogleApiClient googleApiClient) {
        this.googleApiClient = googleApiClient;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        subscribe();
    }

    private void subscribe() {
        Log.i(TAG, "Subscribing.");
        SubscribeOptions options = new SubscribeOptions.Builder()
                .setStrategy(Strategy.BLE_ONLY)
                .build();
        Nearby.Messages.subscribe(googleApiClient, new BeaconMessageListener(), options);
    }

    private PendingIntent getPendingIntent() {
        return PendingIntent.getBroadcast(mainActivity, 0, new Intent(mainActivity, BeaconMessageReceiver.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    @Override
    public void onConnectionSuspended(int cause) {
        Log.e("", "GoogleApiClient disconnected with cause: " + cause);
    }
}
