package com.idscan.intent;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;
import android.content.Context;

public class IntentShim extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = this.cordova.getActivity().getApplicationContext();

        if ("sendBroadcast".equals(action)) {
            Intent intent = new Intent(args.getJSONObject(0).getString("action"));
            intent.putExtra("com.symbol.datawedge.data_string", args.getJSONObject(0).getString("data"));
            context.sendBroadcast(intent);
            callbackContext.success("Broadcast sent");
            return true;
        }

        return false;
    }
}
