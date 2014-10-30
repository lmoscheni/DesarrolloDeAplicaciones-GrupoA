'use strict';

var app = angular.module('angularApp');

app.controller('RegistroDeOperacionesYComprobantesCtrl', function ($http,$scope,$location) {

    $scope.operations = [];
    
    $scope.getOperations = function() {
        $http.get('http://localhost:8080/desapp-grupoa-backend/rest/operations/all')
        .success(function(data) {
                $scope.operations = data;
        
        }).error(function() {
            alert('No se pudieron obtener resultados del servidor');
        });
    };
    
    $scope.parse = function(date){
        var datee = new Date(JSON.parse(date));    
        return datee;
    };
    
    $scope.typeOperation = function(operationType){
        return operationType.income ? 'Income' : 'Egress'
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