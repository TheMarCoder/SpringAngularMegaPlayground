'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp.angularPlayground', [
  'ui.router',
  'ngRoute'
]).
config(['$locationProvider', '$routeProvider', '$stateProvider',
    function($locationProvider, $routeProvider, $stateProvider) {
       $stateProvider
            .state('angularPlayground', {
              url: "/playground/angular",
              templateUrl: "angularPlayground/angularPlayground.html"
        });
}]);
