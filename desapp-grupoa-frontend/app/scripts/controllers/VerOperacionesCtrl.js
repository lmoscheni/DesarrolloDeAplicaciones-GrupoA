'use strict';

var app = angular.module('angularApp');

app.controller('VerOperacionesCtrl', function ($http,$scope,$location,$route,ngDialog) {

    $scope.operations = [];
    $scope.itemsPerPage = 5;
    $scope.currentPage = 0;
    
    
    $http.get('http://localhost:8080/desapp-grupoa-backend/rest/operations/all')
        .success(function(data) {
            $scope.operations = data;
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al obtener las operaciones',plain:true});
    });

    $scope.parse = function(date){
        var datee = new Date(JSON.parse(date));  
        return datee.toLocaleDateString();
    };
    
    $scope.cuenta = function(c) {
        return c === 'BankAccount' ? 'Cuenta bancaria' : c === 'CashAccount' ? 'Cuenta en efectivo' : 'Cuenta corriente';  
    };
    
    $scope.turno = function(t) {
        return t === 'MAÑANA' ? 'Mañana' : c === 'TARDE' ? 'Tarde' : 'Noche';  
    };
    
    $scope.tipoOperacion = function(to) {
        return to === 'INCOME' ? 'Ingreso' : 'Egreso';
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
        return Math.ceil($scope.operations.length/$scope.itemsPerPage)-1;
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