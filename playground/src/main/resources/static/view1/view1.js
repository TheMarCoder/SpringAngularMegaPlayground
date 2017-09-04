'use strict';

//angular.module('myApp.view1', ['ngRoute'])
angular.module('myApp.console', [
  'ui.router',
  'ngRoute'
]).
config(['$locationProvider', '$routeProvider', '$stateProvider', function($locationProvider, $routeProvider, $stateProvider) {

  $stateProvider
    .state('console2', {
      url: "/console2",
      templateUrl: "view1/view1.html"
    });

  });
}]);