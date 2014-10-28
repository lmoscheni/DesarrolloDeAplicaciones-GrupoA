'use strict';



angular.module('angularApp').controller('HomePageCtrl', function ($translate,$scope) {

    $scope.changeLanguage = function (langKey) {
        $translate.use(langKey);
    };
});

