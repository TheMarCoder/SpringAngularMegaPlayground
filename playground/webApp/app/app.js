'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ui.router',
  'ngRoute',
  'myApp.version',
  'myApp.springPlayground',
  'myApp.angularPlayground'
]).
config(['$urlRouterProvider',
    function( $urlRouterProvider) {
        $urlRouterProvider.otherwise('/playground/spring/overview');
}]);
