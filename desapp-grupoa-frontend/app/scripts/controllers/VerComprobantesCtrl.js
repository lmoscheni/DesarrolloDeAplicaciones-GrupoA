'use strict';

var app = angular.module('angularApp');

app.controller('VerComprobantesCtrl', function ($http,$scope,$location,$route,ngDialog) {

    $scope.vouchers = [];
    $scope.itemsPerPage = 5;
    $scope.currentPage = 0;
    
    
    $http.get('http://localhost:8080/desapp-grupoa-backend/rest/vouchers/all')
        .success(function(data) {
            $scope.vouchers = data;
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al obtener los comprobantes',plain:true});
    });

    $scope.parse = function(date){
        var datee = new Date(JSON.parse(date));  
        return datee.toLocaleDateString();
    };
    
    $scope.cuenta = function(c) {
        return c === 'BankAccount' ? 'Cuenta bancaria' : c === 'CashAccount' ? 'Cuenta en efectivo' : 'Cuenta corriente';  
    };
    
    $scope.calcular = function(voucher) {
        if (voucher.billType === 'BillA'){
            
        }
        return voucher.amount;
    };
    
    $scope.verificar = function(dato){
          if(dato == null){
            return '-'   
          };
    };
    
    $scope.comprobanteNombre = function(factura) {
        return factura === 'BiilA' ? 'Factura A' : factura === 'BillB' ? 'Factura B' : factura === 'BillC' ? 'Factura C' : factura === 'BiilD' ? 'Factura D' : 'Factura X';  
    };
    
    $scope.parse = function(date){
        var datee = new Date(JSON.parse(date));  
        return datee.toLocaleDateString();
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
        return Math.ceil($scope.vouchers.length/$scope.itemsPerPage)-1;
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
        var countData = $scope.vouchers.length;
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