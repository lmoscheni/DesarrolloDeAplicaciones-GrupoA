
'use strict';

var app = angular.module('angularApp');

app.controller('ComprobanteCtrl', function ($http,$scope,$location,$window,$routeParams,ngDialog) {
    
    $scope.objectVoucherJson = {};
    $scope.objectVoucherJson = {'dateOfIssue':'', 'socialReason':'', 'cuit': '', 'concept':'', 'amount':'', 'billType' : ''};
       
    
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
    
    $scope.createOperation = function() {
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/operations/save/',angular.toJson($scope.objectOperationJson))
        .success(function(data) {
            $scope.operations = data;
            $location.path('/verOperaciones');
            ngDialog.open({template:'Operación creada con éxito',plain:true});
        }).error(function(data,status) {
            if(status === 500){
                ngDialog.open({template:'Monto invalido (no negativo)',plain:true});
            }else{
                ngDialog.open({template:'Error del servidor '+status+', al crear la operación',plain:true});
            }
            
        });
        
    };
    */
    
    
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