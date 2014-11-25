'use strict';



angular.module('angularApp').controller('CuentasCtrl', function ($http,$scope,$location,ngDialog) {

   $scope.cuentas = [];
   $scope.state = 'danger';
    $scope.color = '';
    
   $http.get('http://localhost:8080/desapp-grupoa-backend/rest/accounts/all')
        .success(function(data) {
            $scope.cuentas = data;
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al obtener las cuentas',plain:true});
    });
    
    $scope.cuenta = function(c) {
        return c === 'BankAccount' ? 'Cuenta bancaria' : c === 'CashAccount' ? 'Cuenta en efectivo' : 'Cuenta corriente';  
    };
    
    $scope.stateAmount = function(amount) {
        /*if(parseInt(amount) <= 0.0){
            $scope.state = 'success';
            $scope.color = 'black';
        }else{
            $scope.state = 'danger';
            $scope.color = 'red';
        }*/
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
