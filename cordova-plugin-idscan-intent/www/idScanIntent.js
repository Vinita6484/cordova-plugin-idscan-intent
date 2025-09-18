var exec = require('cordova/exec');

module.exports = {
  startListening: function(success, error) {
    exec(success, error, "IdScanIntent", "startListening", []);
  }
};
