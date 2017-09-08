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
            });
}]);

function createPatternState(url, headline, contentUrl, ctrl) {
    return {
            url: url,
            views: {
                'headline@pattern': {
                    template: "<h1>" + headline + "</h1><br>" },
               'console@pattern': {
                     templateUrl: "gofPlayground/views/console/console.html"},
               'content@pattern': {
                    templateUrl: "gofPlayground/views/patterns" + contentUrl,
                    controller:  ctrl + " as patternCtrl"}
            }
          }
}