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
    'ngResource',
    'pascalprecht.translate'
  ]);

app.config(function ($routeProvider, $httpProvider, $translateProvider) {
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
        controller: 'RegistroDeOperacionesYComprobantesCtrl'
      })
        .when('/crearOperacion', {
        templateUrl: 'views/crearOperacion.html',
        controller: 'OperacionCtrl'
      })
        .when('/crearCategory', {
        templateUrl: 'views/crearCategory.html',
        controller: 'CategoriaYSubcategoriaCtrl'
      })
        .when('/crearSubcategory', {
        templateUrl: 'views/crearSubcategory.html',
        controller: 'CategoriaYSubcategoriaCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
    
    $translateProvider.translations('en', {
        TITLE: 'System of flow of cash and analysis of expenses.',
        SELECT_IDIOMA : 'Select language:',
        EN : 'English',
        ES : 'Spanish',
        INICIO : 'Main',
        OPERACIONES_Y_COMPROBANTES : 'Operations and vouchers',
        CONTROL_DE_EFECTIVO : 'Control of cash',
        ANALISIS_DE_GASTOS : 'Analysis of expenses',
        OPERACIONES : 'Operations',
        COMPROBANTES : 'Vouchers',
        CREAR : 'Create',
        ELIMINAR : 'Delete',
        MODIFICAR : 'Modify',
        ACEPTAR : 'Agree',
        CANCELAR : 'Cancel',
        SELECCIONAR_PARA_INGRESO : 'Check for income',
        MONTO : 'Amount',
        TURNO : 'Shift',
        CATEGORIA : 'Category',
        SUBCATEGORIA : 'Subcategory',
        CREAR_CATEGORIA : 'Create category',
        CREAR_SUBCATEGORIA : 'Create subcategory',
        SELECCIONAR_CATEGORIA : 'Select category',
        SELECCIONAR_SUBCATEGORIA : 'Select subcategory',
        CREAR_OPERACION : 'Create operation',
        DIA_OPERACION : 'Date operation',
        TIPO_OPERACION : 'Operation type',
        ACCION : 'Actions',
        NOMBRE : 'Name'
    });
    
    $translateProvider.translations('es', {
        TITLE: 'Sistema  de flujo de efectivo y análisis de gastos.',
        SELECT_IDIOMA : 'Seleccionar lenguaje:',
        EN : 'Inglés',
        ES : 'Español',
        INICIO : 'Inicio',
        OPERACIONES_Y_COMPROBANTES : 'Operaciones y comprobantes',
        CONTROL_DE_EFECTIVO : 'Control de efectivo',
        ANALISIS_DE_GASTOS : 'Análisis de gastos',
        OPERACIONES : 'Operaciones',
        COMPROBANTES : 'Comprobantes',
        CREAR : 'Crear',
        ELIMINAR : 'Eliminar',
        MODIFICAR : 'Modificar',
        ACEPTAR : 'Aceptar',
        CANCELAR : 'Cancelar',
        SELECCIONAR_PARA_INGRESO : 'Seleccionar para un ingreso',
        MONTO : 'Monto',
        TURNO : 'Turno',
        CATEGORIA : 'Categoria',
        SUBCATEGORIA : 'Subcategoria',
        CREAR_CATEGORIA : 'Crear categoria',
        CREAR_SUBCATEGORIA : 'Crear subcategoria',
        SELECCIONAR_CATEGORIA : 'Seleccionar categoria',
        SELECCIONAR_SUBCATEGORIA : 'Seleccionar subcategoria',
        CREAR_OPERACION : 'Crear operación',
        DIA_OPERACION : 'Día de la operación',
        TIPO_OPERACION : 'Tipo de operación',
        ACCION : 'Acciones',
        NOMBRE : 'Nombre'
    });
    $translateProvider.preferredLanguage('es');
    
  });

app.factory('dataResource', function ($resource) {
    return $resource('http://localhost:8080/desapp-grupoa-backend/rest/categories/all', //la url donde queremos consumir
        {resource:'', callback:'JSON_CALLBACK'}, //aquí podemos pasar variables que queramos pasar a la consulta
        //a la función get le decimos el método, y, si es un array lo que devuelve
        //ponemos isArray en true
        { query: { method: 'JSONP', isArray: true }
    });
});
