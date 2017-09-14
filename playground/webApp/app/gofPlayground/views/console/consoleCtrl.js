/**
 * Created by BurggrafM on 13.06.2017.
 */

angular.module('myApp.gofPlayground')
    .controller('consoleCtrl', consoleCtrl);

    function consoleCtrl(healthCheckService) {
        var self = this;
        self.executeHealthCheck = executeHealthCheck;
        self.log = log;
        self.clear = clear;
        self.logEntries = [];

        clear();

        function executeHealthCheck() {
            healthCheckService.executeHealthCheck(self)
        }
        
        function log(message) {
            self.logEntries.push(message);
        }
        
        function clear() {
            self.logEntries = [];
        }
    }