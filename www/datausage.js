

var DatausageLoader = function (require, exports, module) {
    var exec = require("cordova/exec");
    
    function Datausage () {}
        
    Datausage.prototype.getMobileData = function (successFunc, failFunc) {
        exec(successFunc, failFunc, "Datausage","getMobileData",[]);
    };
    
    var dataUsage = new Datausage();
    module.exports = dataUsage;
};

DatausageLoader(require, exports, module);

cordova.define("cordova/plugin/Datausage", DatausageLoader);