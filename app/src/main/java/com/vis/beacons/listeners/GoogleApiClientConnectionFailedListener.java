package com.vis.beacons.listeners;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Vis on 14-07-2017.
 */

public class GoogleApiClientConnectionFailedListener implements   GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "";

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG,"ConnectionFailed");
    }
}
