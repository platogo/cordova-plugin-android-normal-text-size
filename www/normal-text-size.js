var exec = require('cordova/exec');

function NormalTextSize() { }

NormalTextSize.prototype.initialize = function () {
    return new Promise(function (resolve, reject) {
        exec(resolve, reject, 'NormalTextSizePlugin', 'initialize', []);
    })
}

module.exports = new NormalTextSize();
