'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp.gofPlayground', [
  'ui.router',
  'ngRoute'
]).
config(['$locationProvider', '$routeProvider', '$stateProvider',
    function($locationProvider, $routeProvider, $stateProvider) {
        $stateProvider
            .state('gofPlayground', {
              abstract: true,
              url: "/playground/gof",
              controller: "consoleCtrl as console",
              templateUrl: "gofPlayground/gofPlayground.html"
            })

            .state('gofPlayground.overview', {
              url: "/overview",
              views: {
                  'console@gofPlayground': {
                        templateUrl: "gofPlayground/views/console/console.html"},
                  'headline@gofPlayground': {
                        template: "<h1>GoF Playground</h1><br>" },
                  'overview@gofPlayground': {
                        template: "<button type='button' class='btn btn-default' ng-click='console.executeHealthCheck()'>Execute healthcheck</button>" }
              }
        });
}]);
