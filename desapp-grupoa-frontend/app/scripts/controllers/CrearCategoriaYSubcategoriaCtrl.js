'use strict';

var app = angular.module('angularApp');
/**
 * @ngdoc function
 * @name angularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularApp
 */




app.controller('CrearCategoriaYSubcategoriaCtrl', function ($http,$scope) {
    $scope.objectCategory = { 'name':'', 'subcategory':''};
    $scope.category = '';
    $scope.createCategory = function() {
        
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/categories/save/', $scope.objectCategory.name)
        .success(function() {
                alert('Categoria "' + $scope.objectCategory.name + '", creada correctamente!!');
        }).error(function() {
            alert('No se pudo crear la categoria');
        });
    };
    
    $scope.createSubcategory = function() {
        $scope.objectCategory.name = $scope.category;
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/categories/saveSubcategory/', $scope.objectCategory)
        .success(function() {
            alert('Categoria "' + $scope.objectCategory.name + '", creada correctamente!!');
        })
        .error(function() {
            console.log('An Error occurred');
        });
    };
});