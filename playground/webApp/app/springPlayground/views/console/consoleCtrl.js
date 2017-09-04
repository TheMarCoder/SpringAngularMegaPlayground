/**
 * Created by BurggrafM on 13.06.2017.
 */

angular.module('myApp.springPlayground')
    .controller('consoleCtrl', consoleCtrl);

    function consoleCtrl(healthCheckService) {
        var self = this;
        self.executeHealthCheck = executeHealthCheck;
        self.clear = clear;

        clear();
        executeHealthCheck();

        function executeHealthCheck() {
            healthCheckService.executeHealthCheck(self.logEntries)
        }
        
        function clear() {
            self.logEntries = [];
        }
    }