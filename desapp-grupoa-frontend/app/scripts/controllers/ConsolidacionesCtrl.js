'use strict';



angular.module('angularApp').controller('ConsolidacionesCtrl', function ($http,$scope,$location,ngDialog) {

   $scope.consolidations = [];
    
   $http.get('http://localhost:8080/desapp-grupoa-backend/rest/consolidations/all')
        .success(function(data) {
            $scope.consolidations = data;
        }).error(function() {
            ngDialog.open({template:'Error del servidor, al obtener las consolidaciones',plain:true});
    });
    
    $scope.parse = function(date){
        var datee = new Date(JSON.parse(date));  
        return datee.toLocaleDateString();
    };
});