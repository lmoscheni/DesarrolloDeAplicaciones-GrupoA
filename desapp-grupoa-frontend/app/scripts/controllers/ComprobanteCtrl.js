
'use strict';

var app = angular.module('angularApp');

app.controller('ComprobanteCtrl', function ($http,$scope,$location,$window,$routeParams,ngDialog) {
    
    $scope.objectVoucherJson = {};
    $scope.objectVoucherJson = {'date':'', 'socialReason':'', 'cuit': '', 'concept':'', 'amount':'', 'billType' : '', 'taxed':'', 'noTaxed':'', 'IIBB':'', 'IVA':''};
    $scope.visible = 'false';
    $scope.montoFinal = 0;
    $scope.facturas = ['Tipo A', 'Tipo B', 'Tipo C', 'Tipo D', 'Tipo X'];
    
    $scope.updateVoucher = function() {
        if($scope.objectVoucherJson.billType === 'Tipo A'){
            $scope.visible = 'true';
            IVA.disable = false;
        }else{
            $scope.visible = 'false';
        }
    };
    
    $scope.validar = function(){
        var dateArray = [];
        dateArray = $scope.objectVoucherJson.date.split("-");
        if(dateArray[0].length === 4){
            return true;
        }else{
            return false;  
        };
    };
   
    $scope.delete = function(voucher) {
        if(confirm('¿Esta seguro de borrar el comprobante?')) {
            $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/vouchers/delete/' + voucher.id,
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(data){
                $scope.vouchers = data;
                ngDialog.open({template:'Comprobante eliminado con exito',plain:true});
                $window.location.reload();
            }).error(function(){
                ngDialog.open({template:'Error del servidor, al borrar el comprobante',plain:true});
            });
        }
    };
    
    
    $scope.createVoucher = function() {
        if($scope.validar()){
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/vouchers/save/',angular.toJson($scope.objectVoucherJson))
        .success(function(data) {
            $scope.operations = data;
            $location.path('/verComprobantes');
            ngDialog.open({template:'Comprobante creado con éxito',plain:true});
        }).error(function(data,status) {
            if(status === 500){
                ngDialog.open({template:'Monto invalido (no negativo)',plain:true});
            }else{
                ngDialog.open({template:'Error del servidor '+status+', al crear el comprobante',plain:true});
            }
            
        });
        }else{
            ngDialog.open({template:'Error al ingresar fecha, formato: aaaa-mm-dd',plain:true});
        };
        
    }
    
    $scope.calculateAmount = function(){
        if($scope.objectVoucherJson.billType === 'Tipo A'){
            $scope.objectVoucherJson.IVA = $scope.objectVoucherJson.amount + ($scope.objectVoucherJson.amount * 0.21);
            $scope.montoFinal = $scope.objectVoucherJson.amount + $scope.objectVoucherJson.taxed + $scope.objectVoucherJson.noTaxed + $scope.objectVoucherJson.IIBB + $scope.objectVoucherJson.IVA;   
        }else{
            $scope.montoFinal = $scope.objectVoucherJson.amount;   
        }
    };
    
    $scope.calculateIVA = function(){
        if($scope.objectVoucherJson.billType === 'Tipo A'){
            $scope.montoFinal = 0;
            $scope.montoFinal = $scope.objectVoucherJson.amount + $scope.objectVoucherJson.taxed + $scope.objectVoucherJson.noTaxed + $scope.objectVoucherJson.IIBB + $scope.objectVoucherJson.IVA; 
        };
    };
    
  });

app.directive('dateTimePicker', function() {
  return {
    restrict: 'E',
    replace: true,
    scope: {
      recipient: '='
    },
    template:
      '<div>' +
      '<input type="text" readonly data-date-format="yyyy-mm-dd hh:ii" name="recipientDateTime" data-date-time required>'+
      '</div>',
    link: function(scope, element, attrs, ngModel) {
      var input = element.find('input');
 
      input.datetimepicker({
        format: "mm/dd/yyyy hh:ii",
        showMeridian: true,
        autoclose: true,
        todayBtn: true,
        todayHighlight: true
      });
 
      element.bind('blur keyup change', function(){
        scope.recipient.datetime = input.val();
      });
    }
  }
});