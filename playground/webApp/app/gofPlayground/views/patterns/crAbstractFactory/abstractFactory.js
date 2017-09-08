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

    function abstractFactoryCtrl() {
        alert("hello abstract factory")
    }
