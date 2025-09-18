module.exports = {
  startListening: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "IdScanIntentPlugin", "startListening", []);
  }
};
