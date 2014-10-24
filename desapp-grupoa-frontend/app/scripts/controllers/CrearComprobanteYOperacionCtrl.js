
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
    $scope.subcategories = [];
    $scope.operations = [];
    $scope.objectOperationJson = {};
    $scope.objectOperationJson = {'amount':'', 'shift':'', 'category': '', 'operationType':'false'};
    $scope.disableSubcategory = true;
    
    
    $scope.getCategories = function() {
        $scope.disableSubcategory = false;
        $http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/all')
        .success(function(data) {
            $scope.categories = data;
            
        }).error(function() {
            alert('No se pudieron obtener resultados del servidor');
        });
    };
       
    $scope.getSubcategories = function() {
            for(var i in $scope.categories){
                if($scope.categories[i].name === $scope.objectOperationJson.category){
                    $scope.subcategories = $scope.categories[i].subcategories;    
                };
            };
    }
    
    function sleep(milliseconds) {
        var start = new Date().getTime();
        for (var i = 0; i < 1e7; i++) {
            if ((new Date().getTime() - start) > milliseconds){
                break;
            }
        }
    }
    
    $scope.getOperations = function() {
        $http.get('http://localhost:8080/desapp-grupoa-backend/rest/operations/all')
        .success(function(data) {
                $scope.operations = data;
        }).error(function() {
            alert('No se pudieron obtener resultados del servidor');
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
            console.log('An Error occurred while trying delete a category');
        });
    };
    
    $scope.parse = function(date){
        var datee = new Date(JSON.parse(date));    
        return datee;
    };
    
    $scope.typeOperation = function(operationType){
        if(operationType.income) {
            return 'Income';   
        }else{
            return 'Egress';
        }
    };
    
    $scope.createOperation = function() {
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/operations/save/',angular.toJson($scope.objectOperationJson))
        .success(function(data, status, headers, config) {
            /*$location.path("/");*/
                $scope.operations = data;
        }).error(function(data, status, headers, config) {
            console.log('An Error occurred while trying to store a book');
        });
    };
    
    
  });
