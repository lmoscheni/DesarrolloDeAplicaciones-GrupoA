'use strict';

var app = angular.module('angularApp');

app.controller('VerOperacionesCtrl', function ($http,$scope,$location,$route,ngDialog) {

    $scope.operations = [];
    $scope.itemsPerPage = 5;
    $scope.currentPage = 0;
    $scope.report = '';
    
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
        return to === "INCOME" ? 'Ingreso' : 'Egreso';
    };
    
    $scope.getOperations = function(){
        var operaciones = [];
        

        for(var i=0;i<$scope.operations.length;i++){
            var operacion = {'id' : '','amount':'', 'shift':'', 'category': '', 'operationType':'false', 'subcategory':'', 'concept' : '', 'account' : ''};
            operacion.id = $scope.operations[i].id + ' ';
            operacion.amount = angular.toJson($scope.operations[i].amount) + ' ';
            operacion.shift = $scope.operations[i].shift + ' ';
            operacion.category = $scope.operations[i].category.name + ' ';
            operacion.operationType = $scope.tipoOperacion($scope.operations[i].operationType) + ' ';
            operacion.subcategory = $scope.operations[i].subcategory + ' ';
            operacion.concept = $scope.operations[i].concept + ' ';
            operacion.account = $scope.operations[i].account + ' ';
            operaciones.push(operacion);
            /*var operacion = '';
            operacion = angular.toJson($scope.operations[i].id) + ' ' + $scope.operations[i].amount + ' ' + $scope.operations[i].shift;
            operaciones.push(operacion);*/
        };
        return operaciones;
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
    
    $("#filename").change(function(e) {
    var ext = $("input#filename").val().split(".").pop().toLowerCase();

    if($.inArray(ext, ["csv"]) == -1) {
        alert('Upload CSV');
        return false;
    }

    if (e.target.files != undefined) {
        var reader = new FileReader();
        reader.onload = function(e) {
        var csvval=e.target.result.split("\n");
        var csvvalue=csvval[0].split(",");
        var inputrad="";
        for(var i=0;i<csvvalue.length;i++)
        {
            var temp=csvvalue[i];
            var inputrad=inputrad+" "+temp;
        }
        $("#csvimporthint").html(inputrad);
        $("#csvimporthinttitle").show();
    };
    reader.readAsText(e.target.files.item(0));

    }

    return false;

    });
});

app.filter('offset', function() {
  return function(input, start) {
    start = parseInt(start, 10);
    return input.slice(start);
  };
});

