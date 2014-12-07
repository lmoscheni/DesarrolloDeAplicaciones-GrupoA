
'use strict';

var app = angular.module('angularApp');

app.controller('EditarOperacionCtrl', function ($http,$scope,$location,$window,$routeParams,ngDialog) {
    
    $scope.categories = [];
    $scope.subcategories = [];
    $scope.objectOperationJson = {};
    $scope.objectOperationJson = {'amount':'', 'shift':'', 'category': '', 'operationType':'false', 'subcategory':'', 'concept' : '', 'account' : ''};
    $scope.shifts = ['Mañana', 'Tarde', 'Noche'];
    $scope.accounts = ['CurrentAccount', 'CashAccount', 'BankAccount'];

    $http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/all')
        .success(function(data) {
            $scope.categories = data;
            for(var i in $scope.categories){
                if($scope.categories[i].name === $scope.objectOperationJson.category){
                    $scope.subcategories = $scope.categories[i].subcategories;    
                }
            }
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al obtener las categorias',plain:true});
        });
    
    $scope.turno = function(t) {
        return t === 'MAÑANA' ? "Mañana" : c === 'TARDE' ? "Tarde" : "Noche";  
    };  
    
    $scope.cuenta = function(c) {
        return c === 'BankAccount' ? 'Cuenta bancaria' : c === 'CashAccount' ? 'Cuenta en efectivo' : 'Cuenta corriente';  
    };
    
    $scope.objectOperationJson.amount = JSON.parse($routeParams.operacion).amount;
    if(JSON.parse($routeParams.operacion).operationType === 'INCOME'){
        $scope.objectOperationJson.operationType = true;
    }
    $scope.objectOperationJson.shift = JSON.parse($routeParams.operacion).shift;
    $scope.objectOperationJson.category = JSON.parse($routeParams.operacion).category.name;
    $scope.objectOperationJson.subcategory = JSON.parse($routeParams.operacion).subcategory;
    $scope.objectOperationJson.concept = JSON.parse($routeParams.operacion).concept;
    $scope.objectOperationJson.account = JSON.parse($routeParams.operacion).account;
    
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
            
            for(var i=0;i<$scope.categories.length;i++){
                if($scope.categories[i].name === $scope.objectOperationJson.category){
                    $scope.subcategories = $scope.categories[i].subcategories;    
                }
            }
    };  
    
    $scope.modificar = function() {
        
        $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/operations/modify/' + JSON.parse($routeParams.operacion).id + '/' + angular.toJson($scope.objectOperationJson),
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(){
                $location.path('/verOperaciones');
            }).error(function(data,status){
                if(status === 501){
                    ngDialog.open({template:'Monto invalido (no negativo)',plain:true});
                }else{
                    ngDialog.open({template:'Error del servidor '+status+', al editar la operación',plain:true});
                }
            });
    };
    
  });