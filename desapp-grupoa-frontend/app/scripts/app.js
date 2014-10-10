'use strict';

/**
 * @ngdoc overview
 * @name angularApp
 * @description
 * # angularApp
 *
 * Main module of the application.
 */
angular
  .module('angularApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
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
      })
        .when('/crearOperacion', {
        templateUrl: 'views/crearOperacion.html',
        controller: 'CrearComprobanteYOperacionCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
