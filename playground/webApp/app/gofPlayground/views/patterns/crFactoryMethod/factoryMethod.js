'use strict';

angular.module('myApp.gofPlayground')
.config(['$stateProvider',
    function( $stateProvider) {
        $stateProvider
          .state('pattern.factoryMethod',
            createPatternState("/factoryMethod", "Factory method", "/crFactoryMethod/factoryMethod.html", "factoryMethodCtrl")
            );
}])

.controller('factoryMethodCtrl', factoryMethodCtrl);

    function factoryMethodCtrl($scope, restService) {
        //$scope.console.log("hello factory method");
        $scope.console.executeHealthCheck();

        restService.GET("/fakeUrl", $scope.console);
    }
