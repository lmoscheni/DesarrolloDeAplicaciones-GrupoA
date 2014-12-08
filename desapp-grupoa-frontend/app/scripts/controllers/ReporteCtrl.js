
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
            
              $http.get('http://localhost:8080/desapp-grupoa-backend/rest/reports/distributionExpensesIncome')
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
            
              $http.get('http://localhost:8080/desapp-grupoa-backend/rest/reports/distributionExpensesEgress')
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

    app.directive('chart3', function($http) {
        return {
          restrict: 'A',
          link: function($scope, $elm, $attr) {
            // Create the data table.
                $scope.categories = [];
                $scope.category = '';
                $http.get('http://localhost:8080/desapp-grupoa-backend/rest/categories/all')
                .success(function(data) {
                    $scope.categories = data;
                }).error(function() {
                    ngDialog.open({template:'Error del servidor, al obtener las categorias',plain:true});
                }); 
                
              $scope.getReport = function(){
              $http.get('http://localhost:8080/desapp-grupoa-backend/rest/reports/distributionExpensesByCategory/' + $scope.category)
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
            var options = {'title':'Costos por subcategorías de categoría ' + $scope.category,
                           'width':400,
                           'height':300};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart($elm[0]);
            chart.draw(data, options);
        }).error(function() {
            /*ngDialog.open({template:'Error del servidor, al obtener los comprobantes',plain:true});*/
        });
              };

            
          }
      }
    });

    app.directive('chart4', function($http) {
        return {
          restrict: 'A',
          link: function($scope, $elm, $attr) {
            // Create the data table.
            
              $http.get('http://localhost:8080/desapp-grupoa-backend/rest/reports/accountDistribution')
        .success(function(dataa) {
            $scope.reportAccount = dataa;
            var list = [];
            var a = '';
            var count = 0; 
            for(a in $scope.reportAccount){
                list.push([a,$scope.reportAccount[a]]);
            }
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');
            data.addColumn('number', 'Slices');
            
            data.addRows(list);
            // Set chart options
            var options = {'title':'Distribución de cuentas',
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

    app.directive('chart5', function($http) {
        return {
          restrict: 'A',
          link: function($scope, $elm, $attr) {
            // Create the data table.
            
              $http.get('http://localhost:8080/desapp-grupoa-backend/rest/reports/incomeByShift')
        .success(function(dataa) {
            $scope.report_turno = dataa;
            var list = [];
            var a = '';
            var count = 0; 
            for(a in $scope.report_turno){
                list.push([a,$scope.report_turno[a]]);
            }
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');
            data.addColumn('number', 'Slices');
            
            data.addRows(list);
            // Set chart options
            var options = {'title':'Ingresos por turno',
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
