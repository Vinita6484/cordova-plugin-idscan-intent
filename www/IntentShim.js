var exec = require('cordova/exec');

module.exports = {
  startListening: function (success, error) {
    exec(success, error, "IdScanIntentPlugin", "startListening", []);
  },
  sendBroadcast: function (params, success, error) {
    exec(success, error, "IntentShim", "sendBroadcast", [params]);
  }
};
