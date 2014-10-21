
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
    $scope.objectOperationJson = {};
    $scope.objectOperationJson = {'amount':'', 'shift':'', 'category':''};
   
        
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
            console.log('An Error occurred while trying to get all operations');
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
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/operations/saveOperation/', angular.toJson($scope.objectOperationJson)).success(
        function(data, status, headers, config) {
            /*$location.path("/");*/
                $scope.operations = data;
        }).error(function(data, status, headers, config) {
            console.log('An Error occurred while trying to store a book');
        });
    };
    
  });


