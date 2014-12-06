'use strict';



angular.module('angularApp').controller('CuentasCtrl', function ($http,$scope,$location,ngDialog) {

   $scope.cuentas = [];
   $scope.state = 'danger';
    $scope.color = '';
    $scope.total = 0;
    
   $http.get('http://localhost:8080/desapp-grupoa-backend/rest/accounts/all')
        .success(function(data) {
            $scope.cuentas = data;
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al obtener las cuentas',plain:true});
    });
    
    $scope.consolidate = function(){
        $http.get('http://localhost:8080/desapp-grupoa-backend/rest/consolidations/consolidate')
        .success(function() {
            $location.path('/verConsolidaciones');
            ngDialog.open({template:'Consolidación exitosa',plain:true});
        }).error(function() {
            ngDialog.open({template:'Error del servidor al consolidar cuentas',plain:true});
        });
    };
    
    $scope.cuentaNombre = function(c) {
        return c === 'BankAccount' ? 'Cuenta bancaria' : c === 'CashAccount' ? 'Cuenta en efectivo' : 'Cuenta corriente';  
    };
    
    $scope.totalCuentas = function(){
        return $scope.total = $scope.cuentas[0].balance + $scope.cuentas[1].balance + $scope.cuentas[2].balance
    };
    
    $scope.devengado = function() {
        return $scope.cuentas[2].accrued;
    };
    
    
    
    $scope.stateAmount = function(amount) {
        if(parseInt(amount) >= 0.0){
            $scope.state = 'success';
            $scope.color = 'black';
        }else{
            $scope.state = 'danger';
            $scope.color = 'red';
        }
        /*else{
        if(parseFloat(amount) >= 0.0){
            $scope.state = 'danger';
        }else{
            $scope.state = 'success';
        }
        }*/
        return amount;
    };
});
