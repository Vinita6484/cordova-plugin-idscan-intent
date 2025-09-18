package com.idscan.intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class IdScanIntentPlugin extends CordovaPlugin {

    private BroadcastReceiver receiver;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("startListening".equals(action)) {
            Context context = this.cordova.getActivity().getApplicationContext();

            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    String data = intent.getStringExtra("com.symbol.datawedge.data_string");
                    if (data != null) {
                        callbackContext.success(data);
                    } else {
                        callbackContext.error("No scan data received");
                    }
                }
            };

            // TODO: Replace "cordova.plugin.idscan.ACTION" with the actual
            // DataWedge intent action configured on your Zebra device
            context.registerReceiver(receiver, new IntentFilter("cordova.plugin.idscan.ACTION"));

            Toast.makeText(context, "Listening for ID scan...", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
