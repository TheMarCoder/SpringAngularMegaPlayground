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

            .state('gofPlayground.patterns', {
              url: "/patterns",
              views: {
                  'console@gofPlayground': {
                        templateUrl: "gofPlayground/views/console/console.html"},
                  'headline@gofPlayground': {
                        template: "<h1>Pattern overview</h1><br>" },
                  'content@gofPlayground': {
                        templateUrl: "gofPlayground/views/patterns/patternOverview.html" }
              }
        });
}]);
