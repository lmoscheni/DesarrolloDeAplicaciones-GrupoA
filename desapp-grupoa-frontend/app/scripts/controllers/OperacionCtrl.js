
'use strict';

var app = angular.module('angularApp');

app.controller('OperacionCtrl', function ($http,$scope,$location,$window,$routeParams,ngDialog) {
    
    $scope.categories = [];
    $scope.subcategories = [];
    $scope.objectOperationJson = {};
    $scope.objectOperationJson = {'amount':'', 'shift':'', 'category': '', 'operationType':'false', 'subcategory':'', 'concept' : '', 'account' : ''};
    $scope.disableSubcategory = true;
    $scope.d = false;
    

    $scope.getCategories = function() {
        $http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/all')
        .success(function(data) {
            $scope.categories = data;
            $scope.disableSubcategory = false;
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al obtener las categorias',plain:true});
        });
    };
       
    $scope.getSubcategories = function() {
            $scope.getCategories();
            for(var i in $scope.categories){
                if($scope.categories[i].name === $scope.objectOperationJson.category){
                    $scope.subcategories = $scope.categories[i].subcategories;    
                }
            }
    };    
    
    $scope.delete = function(operation) {
        if(confirm('Confirmar operación?')) {
            $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/operations/deleteOperation/' + operation.id,
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(data){
                $scope.operations = data;
                ngDialog.open({template:'Operación eliminada con exito',plain:true});
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
            ngDialog.open({template:'Operación creada con éxito',plain:true});
        }).error(function(data,status) {
            if(status === 500){
                ngDialog.open({template:'Monto invalido (no negativo)',plain:true});
            }else{
                ngDialog.open({template:'Error del servidor '+status+', al crear la operación',plain:true});
            }
            
        });
        
    };
    
    
    
  });

