'use strict';

var app = angular.module('angularApp');

app.controller('ConsolidacionesCtrl', function ($http,$scope,$location,ngDialog) {

    $scope.consolidations = [];
    $scope.itemsPerPage = 10;
    $scope.currentPage = 0;
    
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
    
    $scope.prevPage = function() {
        if ($scope.currentPage > 0) {
          $scope.currentPage--;
        }
      };

      $scope.prevPageDisabled = function() {
        return $scope.currentPage === 0 ? 'disabled' : '';
      };

      $scope.pageCount = function() {
        return Math.ceil($scope.consolidations.length/$scope.itemsPerPage)-1;
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
        var countData = $scope.consolidations.length;
        var countPages = 0;
        $scope.listPages = [];
        for (var i=0; i<countData; i = i+$scope.itemsPerPage) {
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