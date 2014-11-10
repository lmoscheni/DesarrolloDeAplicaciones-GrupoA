'use strict';

var app = angular.module('angularApp');
/**
 * @ngdoc function
 * @name angularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularApp
 */




app.controller('CategoriaYSubcategoriaCtrl', function ($http,$scope,$location,ngDialog) {
    $scope.objectCategory = { 'name':'', 'subcategory':''};
    $scope.category = '';
    $scope.categories = [];
    $scope.itemsPerPage = 5;
    $scope.currentPage = 0;
    
    $http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/all')
    .success(function(data) {
        $scope.categories = data;
    }).error(function() {
        ngDialog.open({template:'Error del servidor, al obtener las categorias',plain:true});
    });
    
    $scope.createCategory = function() {
        
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/categories/save/', $scope.objectCategory.name)
        .success(function() {
            ngDialog.open({template:'Categoria "' + $scope.objectCategory.name + '", creada correctamente!!',plain:true});
            $location.path('/crearOperacion');
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al crear la categoria',plain:true});
        });
    };
    
    $scope.createSubcategory = function() {
        $scope.objectCategory.name = $scope.category;
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/categories/saveSubcategory/', $scope.objectCategory)
        .success(function() {
            ngDialog.open({template:'Subcategoria "' + $scope.objectCategory.subcategory + '", creada correctamente!!',plain:true});
        })
        .error(function() {
            ngDialog.open({template:'Error del servidor, al crear la subcategoria',plain:true});
        });
    };
    
    $scope.delete = function(category) {
        if(confirm('Confirmar operacion?')) {
            $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/categories/delete/'+ category.id,
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(data){
                $scope.categories = data;
            }).error(function(){
                ngDialog.open({template:'Error del servidor, al borrar la operación',plain:true});
            });
            /*$http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/delete/', category.id)
            .success(function(data) {
                $scope.categories = data;
            })
            .error(function() {
                ngDialog.open({template:'Error del servidor, al crear la subcategoria',plain:true});
            });*/
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

      $scope.pageCount = function() {
        return Math.ceil($scope.categories.length/$scope.itemsPerPage)-1;
      };

      $scope.nextPage = function() {
        if ($scope.currentPage < $scope.pageCount()) {
          $scope.currentPage++;
        }
      };

      $scope.nextPageDisabled = function() {
        return $scope.currentPage === $scope.pageCount() ? 'disabled' : '';
      };
    
    $scope.page = function(nPage) {
        $scope.currentPage = nPage;  
    };
    
    $scope.numberPages = function(){
        var countData = $scope.categories.length;
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