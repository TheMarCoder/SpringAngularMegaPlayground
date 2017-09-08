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

    function factoryMethodCtrl() {
        alert("hello factory method")
    }
