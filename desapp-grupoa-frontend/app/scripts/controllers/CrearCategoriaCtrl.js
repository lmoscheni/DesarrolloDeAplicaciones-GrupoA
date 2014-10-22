'use strict';

var app = angular.module('angularApp');
/**
 * @ngdoc function
 * @name angularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularApp
 */




app.controller('CrearCategoriaCtrl', function ($http,$scope) {
    $scope.name;
    
    $scope.createCategory = function() {
        $http.post('http://localhost:8080/desapp-grupoa-backend/rest/categories/save/',                       
                   $scope.name).success(
        function(data, status, headers, config) {
            /*$location.path("/");*/
                $scope.operations = data;
        }).error(function(data, status, headers, config) {
            console.log('An Error occurred while trying to store a book');
        });
    };
});