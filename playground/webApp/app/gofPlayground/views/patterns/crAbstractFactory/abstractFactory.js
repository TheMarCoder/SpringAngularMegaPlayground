'use strict';

angular.module('myApp.gofPlayground')
.config(['$stateProvider',
    function( $stateProvider) {
        $stateProvider
          .state('pattern.abstractFactory',
            createPatternState("/abstractFactory", "Abstract Factory", "/crAbstractFactory/abstractFactory.html", "abstractFactoryCtrl")
            );
}])

.controller('abstractFactoryCtrl', abstractFactoryCtrl);

    function abstractFactoryCtrl($scope) {
        $scope.console.log("hello abstract factory");
    }
