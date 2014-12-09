
'use strict';

var app = angular.module('angularApp');

app.controller('EditarComprobanteCtrl', function ($http,$scope,$location,$window,$routeParams,ngDialog) {
    

    $scope.objectVoucherJson = {};
    $scope.objectVoucherJson = {'date':'', 'socialReason':'', 'cuit': '', 'concept':'', 'amount':'', 'billType' : '', 'taxed':'', 'noTaxed':'', 'IIBB':'', 'IVA':''};
    $scope.facturas = ['Tipo A', 'Tipo B', 'Tipo C', 'Tipo D', 'Tipo X'];
    $scope.visible = false;
    
    $scope.parse = function(date){
        var datee = new Date(JSON.parse(date)); 
        var d = datee.toLocaleDateString();
        var dateArray = [];
        dateArray = d.split("/");
        d = dateArray[2] + '-' + dateArray[1] + '-' + dateArray[0]
        return d;
    };

    $scope.comprobanteNombre = function(factura) {
        return factura === 'BillA' ? 'Tipo A' : factura === 'BillB' ? 'Tipo B' : factura === 'BillC' ? 'Tipo C' : factura === 'BiilD' ? 'Tipo D' : 'Tipo X';  
    };
    
    $scope.objectVoucherJson.date = $scope.parse(JSON.parse($routeParams.voucher).dateOfIssue);
    $scope.objectVoucherJson.socialReason = JSON.parse($routeParams.voucher).socialReason;
    $scope.objectVoucherJson.cuit = JSON.parse($routeParams.voucher).cuit;
    $scope.objectVoucherJson.concept = JSON.parse($routeParams.voucher).concept;
    $scope.objectVoucherJson.amount = JSON.parse($routeParams.voucher).amount;
    $scope.objectVoucherJson.billType = $scope.comprobanteNombre(JSON.parse($routeParams.voucher).billType.name);
    $scope.objectVoucherJson.taxed = JSON.parse($routeParams.voucher).billType.taxed;
    $scope.objectVoucherJson.noTaxed = JSON.parse($routeParams.voucher).billType.noTaxed;
    $scope.objectVoucherJson.IIBB = JSON.parse($routeParams.voucher).billType.iibbperception;
    $scope.objectVoucherJson.IVA = JSON.parse($routeParams.voucher).billType.iva;
    
    if($scope.objectVoucherJson.billType === 'Tipo A'){
    $scope.montoFinal = $scope.objectVoucherJson.amount + $scope.objectVoucherJson.taxed + $scope.objectVoucherJson.noTaxed + $scope.objectVoucherJson.IIBB + $scope.objectVoucherJson.IVA;
        $scope.visible = true;
    }else{
        $scope.montoFinal = $scope.objectVoucherJson.amount;  
    };
    
    $scope.updateVoucher = function() {
        if($scope.objectVoucherJson.billType === 'Tipo A'){
            $scope.visible = 'true';
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
    
    $scope.modificar = function() {
        if($scope.validar()){
        $http({
                method : 'GET',
                url: 'http://localhost:8080/desapp-grupoa-backend/rest/vouchers/modify/' + JSON.parse($routeParams.voucher).id + '/' + angular.toJson($scope.objectVoucherJson),
                respondType: 'jso n',
                headers : {'Content-Type' : 'application/json'},
            }).success(function(){
                $location.path('/verComprobantes');
            }).error(function(data,status){
                if(status === 500){
                    ngDialog.open({template:'Campos con montos negativos',plain:true});
                }else{
                    ngDialog.open({template:'Error del servidor '+status+', al editar el comprobante',plain:true});
                }
            });
        }else{
            ngDialog.open({template:'Error al ingresar fecha, formato: aaaa-mm-dd',plain:true});
        };

    };
    
    $scope.calculateAmount = function(){
        if($scope.objectVoucherJson.billType === 'Tipo A'){
            $scope.objectVoucherJson.IVA = ($scope.objectVoucherJson.amount * 0.21);
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