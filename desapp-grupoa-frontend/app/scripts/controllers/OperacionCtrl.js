
'use strict';

var app = angular.module('angularApp');

app.controller('OperacionCtrl', function ($http,$scope,$location,ngTableParams) {
    
    
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

    $scope.l = $location.search();
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
            respondType: 'jso n',
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
        return operationType.income ? 'Income' : 'Egress'
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
    
    $scope.itemsPerPage = 5;
    $scope.currentPage = 0;
    
    $scope.prevPage = function() {
        if ($scope.currentPage > 0) {
          $scope.currentPage--;
        }
      };

      $scope.prevPageDisabled = function() {
        return $scope.currentPage === 0 ? "disabled" : "";
      };

      $scope.pageCount = function() {
        return Math.ceil($scope.operations.length/$scope.itemsPerPage)-1;
      };

      $scope.nextPage = function() {
        if ($scope.currentPage < $scope.pageCount()) {
          $scope.currentPage++;
        }
      };

      $scope.nextPageDisabled = function() {
        return $scope.currentPage === $scope.pageCount() ? "disabled" : "";
      };
    
    $scope.page = function(nPage) {
        $scope.currentPage = nPage;  
    };
    
    $scope.numberPages = function(){
        var countData = $scope.operations.length;
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