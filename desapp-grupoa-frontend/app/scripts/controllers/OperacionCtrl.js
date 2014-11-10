
'use strict';

var app = angular.module('angularApp');

app.controller('OperacionCtrl', function ($http,$scope,$location,$window,$routeParams,ngDialog) {
    
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
            ngDialog.open({template:'Error del servidor, al obtener las categorias',plain:true});
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
            }).error(function(){
                ngDialog.open({template:'Error del servidor, al borrar la operación',plain:true});
            });
        }
    };
    
    $scope.createOperation = function() {
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/operations/save/',angular.toJson($scope.objectOperationJson))
        .success(function(data) {
            $scope.operations = data;
            $location.path('/verOperaciones');
            ngDialog.open({template:'Operacion creada con exito',plain:true});
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al crear la operación',plain:true});
        });
        
    };
    
    
    
  });

