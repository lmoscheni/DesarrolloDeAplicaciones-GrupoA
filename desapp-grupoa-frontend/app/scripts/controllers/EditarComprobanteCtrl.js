
'use strict';

var app = angular.module('angularApp');

app.controller('EditarComprobanteCtrl', function ($http,$scope,$location,$window,$routeParams,ngDialog) {
    

    $scope.objectVoucherJson = {};
    $scope.objectVoucherJson = {'date':'', 'socialReason':'', 'cuit': '', 'concept':'', 'amount':'', 'billType' : '', 'taxed':'', 'noTaxed':'', 'IIBB':'', 'IVA':''};

    $scope.parse = function(date){
        var datee = new Date(JSON.parse(date));  
        return datee.toLocaleDateString();
    };

    $scope.objectVoucherJson.date = $scope.parse(JSON.parse($routeParams.voucher).dateOfIssue);
    $scope.objectVoucherJson.socialReason = JSON.parse($routeParams.voucher).socialReason;
    $scope.objectVoucherJson.cuit = JSON.parse($routeParams.voucher).cuit;
    $scope.objectVoucherJson.concept = JSON.parse($routeParams.voucher).concept;
    $scope.objectVoucherJson.amount = JSON.parse($routeParams.voucher).amount;
    $scope.objectVoucherJson.billType = JSON.parse($routeParams.voucher).billType.name;
    $scope.objectVoucherJson.taxed = JSON.parse($routeParams.voucher).taxed;
    $scope.objectVoucherJson.noTaxed = JSON.parse($routeParams.voucher).noTaxed;
    $scope.objectVoucherJson.IIBB = JSON.parse($routeParams.voucher).IIBBPerception;
    $scope.objectVoucherJson.IVA = JSON.parse($routeParams.voucher).IVA;
    
    $scope.visible = 'false';
    
    $scope.updateVoucher = function() {
        if($scope.objectVoucherJson.billType === 'Tipo A'){
            $scope.visible = 'true';
        }else{
            $scope.visible = 'false';
        }
    };
    
    $scope.modificar = function() {
        
        $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/vouchers/modify/' + JSON.parse($routeParams.voucher).id + '/' + angular.toJson($scope.objectVoucherJson),
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(){
                $location.path('/verComprobantes');
            }).error(function(data,status){
                ngDialog.open({template:'Error del servidor '+status+', al editar el comprobante',plain:true});
            });
    };
    
  });