'use strict';

var app = angular.module('angularApp');
/**
 * @ngdoc function
 * @name angularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularApp
 */




app.controller('CategoriaYSubcategoriaCtrl', function ($http,$scope,$location,$routeParams,$window,ngDialog) {
    $scope.objectCategory = { 'name':'', 'subcategory':''};
    $scope.category = {};
    $scope.categories = [];
    $scope.itemsPerPage = 5;
    $scope.currentPage = 0;
    $scope.categoryName = '';
    $scope.subcategory = '';
    $scope.newSubcategory = '';
    $scope.subcategories = [];
    
    $http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/all')
    .success(function(data) {
        $scope.categories = data;
        $scope.subcategories = data[0].subcategories;
    }).error(function() {
        ngDialog.open({template:'Error del servidor, al obtener las categorias',plain:true});
    });
    
    $scope.createCategory = function() {
        
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/categories/save/', $scope.objectCategory.name)
        .success(function() {
            ngDialog.open({template:'Categoria "' + $scope.objectCategory.name + '", creada correctamente!!',plain:true});
            $location.path('/crearOperacion');
        }).error(function(data,status) {
            if(status === 500){
                ngDialog.open({template:'Ya existe la categoría',plain:true});
            }else{
                ngDialog.open({template:'Error del servidor, al crear la categoría',plain:true});
            }
        });
    };
    
    $scope.createSubcategory = function() {
        $scope.objectCategory.name = $scope.category;
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/categories/saveSubcategory/', $scope.objectCategory)
        .success(function() {
            ngDialog.open({template:'Subcategoría "' + $scope.objectCategory.subcategory + '", creada correctamente!!',plain:true});
        })
        .error(function(data,status) {
            if(status === 500){
                ngDialog.open({template:'Ya existe la subcategoría',plain:true});
            }else{
                ngDialog.open({template:'Error del servidor, al crear la categoría',plain:true});
            }
        });
    };
    
    if($routeParams.categoria != null) {
        $scope.category = JSON.parse($routeParams.categoria);
        $scope.subcategories = JSON.parse($routeParams.categoria).subcategories;  
    }

    $scope.dataModify = function(category) {
        $scope.category = category; 
        $scope.categoryName = category.name;
    };
    
    $scope.dataModifySubcategory = function(subcategory) {
        $scope.subcategory = subcategory; 
        $scope.newSubcategory = subcategory;
    };
    
    $scope.modificar = function() {
        
        $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/categories/modify/' + angular.toJson($scope.category.id) + '/' + $scope.categoryName,
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(data){
                $scope.categories = data;
                ngDialog.open({template:'Categoría modificada.',plain:true});
            }).error(function(){
                ngDialog.open({template:'Error del servidor, al modificar la categoría',plain:true});
            });
    };
    
    $scope.modifySubcategory = function() {
        
        $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/categories/modifySubcategory/' + angular.toJson($scope.category.id) + '/' + $scope.subcategory + '/' + $scope.newSubcategory,
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(data){
                $scope.subcategories = data;
                ngDialog.open({template:'Subcategoría modificada.',plain:true});
            }).error(function(){
                ngDialog.open({template:'Error del servidor, al modificar la categoría',plain:true});
            });
    };
    
    $scope.delete = function(category) {
        if(confirm('Confirmar operación?')) {
            $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/categories/delete/'+ category.id,
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(data){
                $scope.categories = data;
                ngDialog.open({template:'Categoría eliminada',plain:true});
            }).error(function(){
                ngDialog.open({template:'Error del servidor, al borrar la categoría',plain:true});
            });
        }
    };
    
    $scope.deleteSubcategory = function(subcategory) {
        if(confirm('Confirmar operación?')) {
            $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/categories/deleteSubcategory/'+ angular.toJson($scope.category.id) + '/' + subcategory,
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(data){
                $scope.subcategories = data;
                ngDialog.open({template:'Subcategoría eliminada',plain:true});
            }).error(function(){
                ngDialog.open({template:'Error del servidor, al borrar la subcategoría',plain:true});
            });
        }
    };
    
    $scope.prevPage = function() {
        if ($scope.currentPage > 0) {
          $scope.currentPage--;
        }
      };

      $scope.prevPageDisabled = function() {
        return $scope.currentPage === 0 ? 'disabled' : '';
      };

      $scope.pageCount = function(bool) {
          if(bool) {
            return Math.ceil($scope.categories.length/$scope.itemsPerPage)-1;
          }else {
              return Math.ceil($scope.subcategories.length/$scope.itemsPerPage)-1;
          }
      };

      $scope.nextPage = function(bool) {
        if ($scope.currentPage < $scope.pageCount(bool)) {
          $scope.currentPage++;
        }
      };

      $scope.nextPageDisabled = function() {
        return $scope.currentPage === $scope.pageCount() ? 'disabled' : '';
      };
    
    $scope.page = function(nPage) {
        $scope.currentPage = nPage;  
    };
    
    $scope.numberPages = function(bool){
        if(bool) {
            var countData = $scope.categories.length;
        }else{
            var countData = $scope.subcategories.length;
        }
        var countPages = 0;
        $scope.listPages = [];
        for (var i=0; i<countData; i = i+5) {
            $scope.listPages.push(countPages);
            countPages++;
        } 
        return $scope.listPages;
    };
});
app.filter('offset', function() {
  return function(input, start) {
    start = parseInt(start, 10);
    return input.slice(start);
  };
});