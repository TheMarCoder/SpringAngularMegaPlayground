/**
 * Created by BurggrafM on 13.06.2017.
 */

angular.module('myApp.gofPlayground')
    .service('restService', restService);

    function restService($http, $q) {
        var self = this;
        self.GET = GET;

        function GET(url, console) {
            var deferred = $q.defer();
            $http.get(url)
              .success(function(response) {
                  console.logEntries.push.apply(console.logEntries, response.logEntries);
                  console.logEntries.push("-");
                  deferred.resolve(response.content);
                }
              )
              .error(function (error, status) {
                  console.logEntries.push("*ERROR* could not execute request to '" + url + "'. Status: " + status);
                  console.logEntries.push("-");
                  deferred.reject(response.content);
              });
        }
    }