/**
 * Created by BurggrafM on 13.06.2017.
 */

angular.module('myApp.gofPlayground')
    .service('healthCheckService', healthCheckService);

    function healthCheckService($http) {
        var self = this;
        self.executeHealthCheck = executeHealthCheck;

        function executeHealthCheck(console) {
            $http.get("/healthCheck")
              .success(function(response) {
                  console.logEntries.push.apply(console.logEntries, response.logEntries);
                  console.logEntries.push(response.content);
                  console.logEntries.push("-");
                }
              )
              .error(function (error) {
                  console.logEntries.push(error === null ? "backend healthCheck ... FAILED" : error);
                  console.logEntries.push("-");
              });
        }
    }