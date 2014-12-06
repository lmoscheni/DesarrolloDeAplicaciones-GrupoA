
'use strict';
var report = {};

var app = angular.module('angularApp');
    app.controller('ReporteCtrl', function($scope,$http) {
      $scope.name = "Ejemplo";
      
    });
    app.directive('chart', function($http) {
        return {
          restrict: 'A',
          link: function($scope, $elm, $attr) {
            // Create the data table.
            
              $http.get('http://localhost:8080/desapp-grupoa-backend/rest/reports/distributionExpenses')
        .success(function(dataa) {
            $scope.report = dataa;
            var list = [];
            var a = '';
            var count = 0; 
            for(a in $scope.report){
                list.push([a,$scope.report[a]]);
            }
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');
            data.addColumn('number', 'Slices');
            
            data.addRows(list);
            // Set chart options
            var options = {'title':'Costos por categoría',
                           'width':400,
                           'height':300};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart($elm[0]);
            chart.draw(data, options);
        }).error(function() {
            /*ngDialog.open({template:'Error del servidor, al obtener los comprobantes',plain:true});*/
        });
            
            

            
          }
      }
    });

    app.directive('chart2', function($http) {
        return {
          restrict: 'A',
          link: function($scope, $elm, $attr) {
            // Create the data table.
            
              $http.get('http://localhost:8080/desapp-grupoa-backend/rest/reports/distributionExpenses')
        .success(function(dataa) {
            $scope.report = dataa;
            var list = [];
            var a = '';
            var count = 0; 
            for(a in $scope.report){
                list.push([a,$scope.report[a]]);
            }
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');
            data.addColumn('number', 'Slices');
            
            data.addRows(list);
            // Set chart options
            var options = {'title':'Costos por categoría',
                           'width':400,
                           'height':300};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart($elm[0]);
            chart.draw(data, options);
        }).error(function() {
            /*ngDialog.open({template:'Error del servidor, al obtener los comprobantes',plain:true});*/
        });
            
            

            
          }
      }
    });
    
    google.setOnLoadCallback(function() {
        angular.bootstrap(document.body, ['angularApp']);
    });
    google.load('visualization', '1', {packages: ['corechart']});
