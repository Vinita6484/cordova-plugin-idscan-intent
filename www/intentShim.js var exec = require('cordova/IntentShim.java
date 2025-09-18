package com.idscan.intent;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

public class IntentShim extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = this.cordova.getActivity().getApplicationContext();

        if ("sendBroadcast".equals(action)) {
            String intentAction = args.getJSONObject(0).getString("action");
            String data = args.getJSONObject(0).getString("data");

            Intent intent = new Intent(intentAction);
            intent.putExtra("com.symbol.datawedge.data_string", data);
            context.sendBroadcast(intent);

            // ✅ Show confirmation alert
            Toast.makeText(context, "📡 Broadcast sent: " + data, Toast.LENGTH_SHORT).show();

            callbackContext.success("Broadcast sent");
            return true;
        }

        // ❌ Unsupported action alert
        Toast.makeText(context, "⚠️ Unsupported action: " + action, Toast.LENGTH_SHORT).show();
        return false;
    }
}
