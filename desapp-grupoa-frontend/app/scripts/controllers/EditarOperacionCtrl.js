
'use strict';

var app = angular.module('angularApp');

app.controller('EditarOperacionCtrl', function ($http,$scope,$location,$window,$routeParams) {
    
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
    
    $scope.objectOperationJson.amount = JSON.parse($routeParams.operacion).amount;
    $scope.objectOperationJson.shift = JSON.parse($routeParams.operacion).shift;
    $scope.objectOperationJson.category = JSON.parse($routeParams.operacion).category.name;
        /*$scope.objectOperationJson.amount = '4';
        $scope.objectOperationJson.category = operation.category;
        $scope.objectOperationJson.shift = 'lalallala';*/
    
  });