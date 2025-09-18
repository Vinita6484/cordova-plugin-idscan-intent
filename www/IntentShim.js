var exec = require('cordova/exec');

module.exports = {
  startListening: function (successCallback, errorCallback) {
    exec(successCallback, errorCallback, "IdScanIntentPlugin", "startListening", []);
  },

  sendBroadcast: function (params, successCallback, errorCallback) {
    exec(successCallback, errorCallback, "IntentShim", "sendBroadcast", [params]);
  }
};
