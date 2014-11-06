
'use strict';

var app = angular.module('angularApp');

app.controller('EditarOperacionCtrl', function ($http,$scope,$location,$window,$routeParams,ngDialog) {
    
    $scope.categories = [];
    $scope.subcategories = [];
    $scope.objectOperationJson = {};
    $scope.objectOperationJson = {'amount':'', 'shift':'', 'category': '', 'operationType':'false', 'subcategory':''};

    $scope.getCategories = function() {
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
    
    $scope.objectOperationJson.amount = JSON.parse($routeParams.operacion).amount;
    $scope.objectOperationJson.operationType = JSON.parse($routeParams.operacion).operationType.income;
    $scope.objectOperationJson.shift = JSON.parse($routeParams.operacion).shift;
    $scope.objectOperationJson.category = JSON.parse($routeParams.operacion).category.name;
    $scope.objectOperationJson.subcategory = JSON.parse($routeParams.operacion).subcategory;
    
    $scope.modificar = function() {
        
        $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/operations/modify/' + JSON.parse($routeParams.operacion).id + '/' + angular.toJson($scope.objectOperationJson),
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(){
                  $location.path('/verOperaciones');
            }).error(function(){
                ngDialog.open({template:'Error del servidor, al modificar la operación',plain:true});
            });
    };
    
  });