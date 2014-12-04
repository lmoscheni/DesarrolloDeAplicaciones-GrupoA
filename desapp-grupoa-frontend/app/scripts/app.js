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
    'pascalprecht.translate',
    'ngDialog',
    'ngCsv',
    'ngChartist'
  ]);

app.config(function ($routeProvider, $httpProvider, $translateProvider) {
    $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    
    $routeProvider
      .when('/verOperaciones', {
        templateUrl: 'views/verOperaciones.html',
        controller: 'VerOperacionesCtrl'
      })
        .when('/crearComprobante', {
        templateUrl: 'views/crearComprobante.html',
        controller: 'ComprobanteCtrl'
      })
        .when('/verComprobantes', {
        templateUrl: 'views/verComprobantes.html',
        controller: 'VerComprobantesCtrl'
      })
        .when('/registroDeOperacionesYComprobantes', {
        templateUrl: 'views/registroDeOperacionesYComprobantes.html',
        controller: 'RegistroDeOperacionesYComprobantesCtrl'
      })
        .when('/crearOperacion', {
        templateUrl: 'views/crearOperacion.html',
        controller: 'OperacionCtrl'
      })
        .when('/modificarOperacion/:operacion', {
        templateUrl: 'views/modificarOperacion.html',
        controller: 'EditarOperacionCtrl'
      })
        .when('/crearCategory', {
        templateUrl: 'views/crearCategory.html',
        controller: 'CategoriaYSubcategoriaCtrl'
      })
        .when('/crearSubcategory', {
        templateUrl: 'views/crearSubcategory.html',
        controller: 'CategoriaYSubcategoriaCtrl'
      })
        .when('/verCategorias', {
        templateUrl: 'views/verCategorias.html',
        controller: 'CategoriaYSubcategoriaCtrl'
      })
        .when('/verSubcategorias/:categoria', {
        templateUrl: 'views/verSubcategorias.html',
        controller: 'CategoriaYSubcategoriaCtrl'
      })
        .when('/verCuentas', {
        templateUrl: 'views/verCuentas.html',
        controller: 'CuentasCtrl'
      })
        .when('/verReportes', {
        templateUrl: 'views/verReportes.html',
        controller: 'ReporteCtrl'
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
        OPERACION : 'Operation',
        COMPROBANTE : 'Voucher',
        CREAR : 'Create',
        ELIMINAR : 'Delete',
        MODIFICAR : 'Modify',
        ACEPTAR : 'Agree',
        CANCELAR : 'Cancel',
        SELECCIONAR_PARA_INGRESO : 'Check for income',
        MONTO : 'Amount',
        TURNO : 'Shift',
        CATEGORIA : 'Category',
        CATEGORIAS : 'Categories',
        SUBCATEGORIA : 'Subcategory',
        SUBCATEGORIAS : 'Subcategories',
        CREAR_CATEGORIA : 'Create category',
        MODIFICAR_CATEGORIA : 'Modify category',
        ELIMINAR_CATEGORIA : 'Delete category',
        CREAR_SUBCATEGORIA : 'Create subcategory',
        MODIFICAR_SUBCATEGORIA : 'Modify subcategory',
        MODIFICAR_SUBCATEGORIAS : 'Modify subcategories',
        SELECCIONAR_CATEGORIA : 'Select category',
        SELECCIONAR_SUBCATEGORIA : 'Select subcategory',
        CREAR_OPERACION : 'Create operation',
        EDITAR_OPERACION : 'Edit operation',
        DIA_OPERACION : 'Date operation',
        TIPO_OPERACION : 'Operation type',
        ACCION : 'Actions',
        NOMBRE : 'Name',
        VER : 'See',
        MENSAJE_CONFIRMACION : 'To confirm operation?',
        CONCEPTO : 'Concept',
        CUENTA : 'Account',
        MANANA : 'Morning',
        TARDE : 'Evening',
        NOCHE : 'Night',
        SELECCIONAR_TURNO : 'Select shift',
        SELECCIONAR_CUENTA : 'Select account',
        CARGAR_COMPROBANTE : 'Load voucher',
        RAZON_SOCIAL : 'Social reason',
        ESTADO_CUENTAS : 'Accounts state',
        REPORTES : 'Reports',
        PREVIO : 'Prev',
        SIGUIENTE : 'Next'
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
        OPERACION : 'Operación',
        COMPROBANTE : 'Comprobante',
        CREAR : 'Crear',
        ELIMINAR : 'Eliminar',
        MODIFICAR : 'Modificar',
        ACEPTAR : 'Aceptar',
        CANCELAR : 'Cancelar',
        SELECCIONAR_PARA_INGRESO : 'Seleccionar para un ingreso',
        MONTO : 'Monto',
        TURNO : 'Turno',
        CATEGORIA : 'Categoría',
        CATEGORIAS : 'Categorias',
        SUBCATEGORIA : 'Subcategoría',
        SUBCATEGORIAS : 'Subcategorias',
        CREAR_CATEGORIA : 'Crear categoría',
        MODIFICAR_CATEGORIA : 'Modificar categoría',
        MODIFICAR_SUBCATEGORIA : 'Modificar subcategoría',
        MODIFICAR_SUBCATEGORIAS : 'Modificar subcategorias',
        ELIMINAR_CATEGORIA : 'Borrar categoría',
        CREAR_SUBCATEGORIA : 'Crear subcategoría',
        SELECCIONAR_CATEGORIA : 'Seleccionar categoría',
        SELECCIONAR_SUBCATEGORIA : 'Seleccionar subcategoría',
        CREAR_OPERACION : 'Crear operación',
        EDITAR_OPERACION : 'Editar operación',
        DIA_OPERACION : 'Día de la operación',
        TIPO_OPERACION : 'Tipo de operación',
        ACCION : 'Acciones',
        NOMBRE : 'Nombre',
        VER : 'Ver',
        MENSAJE_CONFIRMACION : '¿Confirmar operación?',
        CONCEPTO : 'Concepto',
        CUENTA : 'Cuenta',
        MANANA : 'Mañana',
        TARDE : 'Tarde',
        NOCHE : 'Noche',
        SELECCIONAR_TURNO : 'Seleccionar turno',
        SELECCIONAR_CUENTA : 'Seleccionar cuenta',
        CARGAR_COMPROBANTE : 'Cargar comprobante',
        RAZON_SOCIAL : 'Razon social',
        ESTADO_CUENTAS : 'Estado de cuentas',
        REPORTES : 'Reportes',
        PREVIO : 'Prev',
        SIGUIENTE : 'Sig'
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
