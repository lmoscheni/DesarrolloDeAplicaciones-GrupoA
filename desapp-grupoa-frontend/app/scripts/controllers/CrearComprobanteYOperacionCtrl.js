
'use strict';

var app = angular.module('angularApp');
/**
 * @ngdoc function
 * @name angularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularApp
 */




app.controller('CrearComprobanteYOperacionCtrl', function ($http,$scope) {
    
    $scope.categories = [];
    $scope.operations = [];
    
    $scope.getCategories = function() {
        $http({
            method : 'GET',
            url: 'http://localhost:8080/desapp-grupoa-backend/rest/categories/all',
            respondType: 'json',
            headers : {'Content-Type' : 'application/json'},
        }).success(function(data){
                $scope.categories = data;
        }).error(function(data){
            console.log('An Error occurred while trying to get all categories');
        });
    };
        
    $scope.getOperations = function() {
        $http({
            method : 'GET',
            url: 'http://localhost:8080/desapp-grupoa-backend/rest/operations/all',
            respondType: 'json',
            headers : {'Content-Type' : 'application/json'},
        }).success(function(data){
                $scope.operations = data;
        }).error(function(data){
            console.log('An Error occurred while trying to get all categories');
        });
    };
    
    $scope.delete = function(operation) {
        $http({
            method : 'GET',
            url: 'http://localhost:8080/desapp-grupoa-backend/rest/operations/deleteOperation/' + operation.id,
            respondType: 'json',
            headers : {'Content-Type' : 'application/json'},
        }).success(function(data){
               $scope.operations = data;
        }).error(function(data){
            console.log('An Error occurred while trying to get all categories');
        });
    };
    
  });


