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
              templateUrl: "gofPlayground/gofPlayground.html"
            })

            .state('gofPlayground.patterns', {
              url: "/patterns",
              views: {
                  'headline@gofPlayground': {
                        template: "<h1>Pattern overview</h1><br>" },
                  'content@gofPlayground': {
                        templateUrl: "gofPlayground/views/patterns/patternOverview.html" }
                }
              })

            .state('pattern', {
              abstract: true,
              url: "/playground/gof/pattern",
              controller: "consoleCtrl as console",
              templateUrl: "gofPlayground/views/patterns/pattern.html"
            })

              .state('pattern.example', {
                url: "/example",
                views: {
                   'console@pattern': {
                         templateUrl: "gofPlayground/views/console/console.html"},
                   'content@pattern': {
                        templateUrl: "gofPlayground/views/patterns/patternOverview.html" }
                }
              });
}]);
