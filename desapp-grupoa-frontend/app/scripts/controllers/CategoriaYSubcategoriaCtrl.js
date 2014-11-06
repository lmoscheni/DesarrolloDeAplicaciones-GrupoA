'use strict';

var app = angular.module('angularApp');
/**
 * @ngdoc function
 * @name angularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularApp
 */




app.controller('CategoriaYSubcategoriaCtrl', function ($http,$scope,$location,ngDialog) {
    $scope.objectCategory = { 'name':'', 'subcategory':''};
    $scope.category = '';
    
    $scope.createCategory = function() {
        
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/categories/save/', $scope.objectCategory.name)
        .success(function() {
            ngDialog.open({template:'Categoria "' + $scope.objectCategory.name + '", creada correctamente!!',plain:true});
            $location.path('/crearOperacion');
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al crear la categoria',plain:true});
        });
    };
    
    $scope.createSubcategory = function() {
        $scope.objectCategory.name = $scope.category;
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/categories/saveSubcategory/', $scope.objectCategory)
        .success(function() {
            ngDialog.open({template:'Subcategoria "' + $scope.objectCategory.subcategory + '", creada correctamente!!',plain:true});
        })
        .error(function() {
            ngDialog.open({template:'Error del servidor, al crear la subcategoria',plain:true});
        });
    };
});