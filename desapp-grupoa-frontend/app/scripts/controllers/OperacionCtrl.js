
'use strict';

var app = angular.module('angularApp');

app.controller('OperacionCtrl', function ($http,$scope,$location,$window,$routeParams,$translate) {
    
    $scope.categories = [];
    $scope.subcategories = [];
    $scope.objectOperationJson = {};
    $scope.objectOperationJson = {'amount':'', 'shift':'', 'category': '', 'operationType':'false', 'subcategory':''};
    $scope.disableSubcategory = true;
    $scope.d = false;
    

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
    
    $scope.delete = function(operation) {
        if(confirm('Confirmar operacion?')) {
            $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/operations/deleteOperation/' + operation.id,
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(data){
                   $scope.operations = data;
                    $window.location.reload();
            }).error(function(data,status){
                alert('Error (' + status + ') al borrar la operacion');
            });
        }
    };
    
    
        $scope.objectOperationJson.amount = $routeParams.amount;
        /*$scope.objectOperationJson.amount = '4';
        $scope.objectOperationJson.category = operation.category;
        $scope.objectOperationJson.shift = 'lalallala';*/
    
    
    $scope.createOperation = function() {
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/operations/save/',angular.toJson($scope.objectOperationJson))
        .success(function(data) {
                $scope.operations = data;
                $location.path('/verOperaciones');
            alert('Operacion creada con exito!!');
        }).error(function(status) {
            alert('Error ('+ status +') al guardar la operacion');
        });
        
    };
    
  });

