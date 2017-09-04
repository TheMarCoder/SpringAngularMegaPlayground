'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp.springPlayground', [
  'ui.router',
  'ngRoute'
]).
config(['$locationProvider', '$routeProvider', '$stateProvider',
    function($locationProvider, $routeProvider, $stateProvider) {
        $stateProvider
            .state('springPlayground', {
              abstract: true,
              url: "/playground/spring",
              controller: "consoleCtrl as console",
              templateUrl: "springPlayground/springPlayground.html"
            })

            .state('springPlayground.overview', {
              url: "/overview",
              views: {
                  'console@springPlayground': {
                        templateUrl: "springPlayground/views/console/console.html"},
                  'headline@springPlayground': {
                        template: "<h1>Spring 4 Playground</h1><br>" },
                  'overview@springPlayground': {
                        template: "<button type='button' class='btn btn-default' ng-click='console.executeHealthCheck()'>Execute healthcheck</button>" }
              }
        });
}]);
