/**
 * Created by BurggrafM on 13.06.2017.
 */

angular.module('myApp.springPlayground')
    .service('healthCheckService', healthCheckService);

    function healthCheckService($http) {
        var self = this;
        self.executeHealthCheck = executeHealthCheck;

        function executeHealthCheck(logEntries) {
            $http.get("/healthCheck")
              .success(function(response) {
                  logEntries.push(response.content);
                }
              )
              .error(function (error) {
                  logEntries.push(error === null ? "Backend healthCheck ... FAILED" : error);
              });
        }
    }