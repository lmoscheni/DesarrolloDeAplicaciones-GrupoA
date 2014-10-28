
'use strict';

var app = angular.module('angularApp');

app.controller('OperacionCtrl', function ($http,$scope,$location) {
    
    
    $scope.categories = [];
    $scope.subcategories = [];
    $scope.operations = [];
    $scope.objectOperationJson;
    $scope.objectOperationJson = {'amount':'', 'shift':'', 'category': '', 'operationType':'false', 'subcategory':''};
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
                }
            }
    };

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
        }).error(function(data,status){
            alert('Error (' + status + ') al borrar la operacion');
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
    
    $scope.modificar = function(operation) {
        $scope.objectOperationJson.amount = '4';
        $scope.objectOperationJson.category = operation.category;
        $scope.objectOperationJson.shift = 'lalallala';
        $scope.$watch($scope.modificar);
        $location.path('/crearOperacion');
    };
    
    $scope.createOperation = function() {
        if ($scope.objectOperationJson.amount === '' || $scope.objectOperationJson.shift === '' || $scope.objectOperationJson.category === '' || $scope.objectOperationJson.subcategory === '') {
            alert('Debe llenar todos los campos');  
        }else{
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/operations/save/',angular.toJson($scope.objectOperationJson))
        .success(function(data) {
                $scope.operations = data;
                $location.path('/registroDeOperacionesYComprobantes');
            alert('Operacion creada con exito!!');
        }).error(function(data,status) {
            alert('Error (' + status + ') al guardar la operacion');
        });
        }
    };
  });
