'use strict';



angular.module('angularApp').controller('IndexCtrl', function ($translate,$scope) {

    $scope.changeLanguage = function (langKey) {
        $translate.use(langKey);
    };
    
    $scope.date = Date.now();
});

