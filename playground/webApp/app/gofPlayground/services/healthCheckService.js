/**
 * Created by BurggrafM on 13.06.2017.
 */

angular.module('myApp.gofPlayground')
    .service('healthCheckService', healthCheckService);

    function healthCheckService($http) {
        var self = this;
        self.executeHealthCheck = executeHealthCheck;

        function executeHealthCheck(logEntries) {
            $http.get("/healthCheck")
              .success(function(response) {
                  logEntries.push.apply(logEntries, response.logEntries);
                  logEntries.push(response.content);
                  logEntries.push("_");
                }
              )
              .error(function (error) {
                  logEntries.push(error === null ? "backend healthCheck ... FAILED" : error);
              });
        }
    }