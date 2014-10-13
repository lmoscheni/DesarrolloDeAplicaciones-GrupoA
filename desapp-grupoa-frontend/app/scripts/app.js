'use strict';

/**
 * @ngdoc overview
 * @name angularApp
 * @description
 * # angularApp
 *
 * Main module of the application.
 */
var app = angular.module('angularApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ngResource'
  ]);

app.config(function ($routeProvider, $httpProvider) {
    $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    
    $routeProvider
      .when('/', {
        templateUrl: 'views/homePage.html',
        controller: 'HomePageCtrl'
      })
        .when('/crearComprobante', {
        templateUrl: 'views/crearComprobante.html',
        controller: 'CrearComprobanteYOperacionCtrl'
      })
        .when('/registroDeOperacionesYComprobantes', {
        templateUrl: 'views/registroDeOperacionesYComprobantes.html',
        controller: 'CrearComprobanteYOperacionCtrl'
      })
        .when('/crearOperacion', {
        templateUrl: 'views/crearOperacion.html',
        controller: 'CrearComprobanteYOperacionCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

app.factory('dataResource', function ($resource) {
    return $resource('http://localhost:8080/desapp-grupoa-backend/rest/categories/all', //la url donde queremos consumir
        {resource:'', callback:'JSON_CALLBACK'}, //aquí podemos pasar variables que queramos pasar a la consulta
        //a la función get le decimos el método, y, si es un array lo que devuelve
        //ponemos isArray en true
        { query: { method: 'JSONP', isArray: true }
    });
});
