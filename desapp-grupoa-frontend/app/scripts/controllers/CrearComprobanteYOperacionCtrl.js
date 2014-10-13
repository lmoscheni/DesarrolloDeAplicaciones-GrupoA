
'use strict';

var app = angular.module('angularApp');
/**
 * @ngdoc function
 * @name angularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angularApp
 */

app.controller('CrearComprobanteYOperacionCtrl', function ($http,$scope, dataResource) {
    
      /*$scope.categories = $resource('https://localhost:8080/desapp-grupoa-backend/rest/categories/all', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: true
        }
        });
      
            
    */
      /*var config={
        method:'GET',
        url:'http://localhost:8080/desapp-grupoa-backend/rest/categories/all'
        };
      
      var response=$http(config);
      
      response.success(function(data) {
      $scope.categories=data;
    });
*/
       /*
      $http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/all').
        success(function(data) {
          $scope.categories = data;
        });
      
      
      
      
      CategoriesFactory.get({}, function (categoriesFactory) {
                $scope.categories = categoriesFactory
            })
            */
        
        $scope.getCategories = function() {
            
           /* $scope.categories = dataResource.query();*/
           
            /*$http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/all').success(function(response) {
                
                    $scope.status = 'bien';
                
            }).error(function(response) {
                $scope.status = 'error';  
            });*/
            
            $http({
                    method : 'GET',
                    url: 'http://localhost:8080/desapp-grupoa-backend/rest/categories/all',
                    respondType: 'json',
                    headers : {'Content-Type' : 'application/json'},
                }).success(function(data){
                        $scope.status = 'bien';
                        $scope.categories = {};
                        $scope.categories = data;
                    
                }).error(function(data){
                    $scope.status = 'error';
                    console.log('An Error occurred while trying to get all categories');
                });
            /*
		      $scope.categories = $http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/all').
                success(function(data) {
                $scope.categories = 'bien';
                }).
              error(function(date,status,headers,config) {
                  $scope.categories = 'error';
              });*/
                
        };
        
  });


