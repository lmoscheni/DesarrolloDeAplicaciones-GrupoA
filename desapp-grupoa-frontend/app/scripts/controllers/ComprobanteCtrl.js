
'use strict';

var app = angular.module('angularApp');

app.controller('ComprobanteCtrl', function ($http,$scope,$location,$window,$routeParams,ngDialog) {
    
    $scope.objectVoucherJson = {};
    $scope.date = new Date(2013, 9, 22);
    $scope.objectVoucherJson = {'date':'', 'socialReason':'', 'cuit': '', 'concept':'', 'amount':'', 'billType' : '', 'taxed':'', 'noTaxed':'', 'IIBB':'', 'IVA':''};
    $scope.objectVoucherJson.date = $scope.date;
    $scope.visible = 'false';
    
    $scope.updateVoucher = function() {
        if($scope.objectVoucherJson.billType === 'Bill A'){
            $scope.visible = 'true';
        }else{
            $scope.visible = 'false';
        }
    };
   /* $scope.delete = function(operation) {
        if(confirm('Confirmar operación?')) {
            $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/operations/deleteOperation/' + operation.id,
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(data){
                $scope.operations = data;
                ngDialog.open({template:'Operación eliminada con exito',plain:true});
                $window.location.reload();
            }).error(function(){
                ngDialog.open({template:'Error del servidor, al borrar la operación',plain:true});
            });
        }
    };
    */
    
    $scope.createVoucher = function() {
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/vouchers/save/',angular.toJson($scope.objectVoucherJson))
        .success(function(data) {
            $scope.operations = data;
            $location.path('/verOperaciones');
            ngDialog.open({template:'Comprobante creado con éxito',plain:true});
        }).error(function(data,status) {
            if(status === 500){
                ngDialog.open({template:'Monto invalido (no negativo)',plain:true});
            }else{
                ngDialog.open({template:'Error del servidor '+status+', al crear el comprobante',plain:true});
            }
            
        });
        
    }
    
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