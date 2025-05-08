              var app = angular.module('app', ['ui.grid', 'ui.grid.pagination']);
              
              app.controller('MainCtrl', ['$scope','$http', function ($scope,$http) {
              $http
              .get("usersList")
              .then(function(response) {
              $scope.data = response.data;
              });
             
                 $scope.gridOptions = {
                   data: 'data',
                   paginationPageSizes: [5, 10, 20,25],
                   paginationPageSize: 5,
                   columnDefs: [
                     {name: 'id'},
                     {name: 'name'}
                   ]
                  }
               }]);       