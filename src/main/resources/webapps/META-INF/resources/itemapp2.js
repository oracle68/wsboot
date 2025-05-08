var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.edit', 'ui.grid.rowEdit', 'ui.grid.selection','ui.grid.pagination']);


app.controller('MainCtrl', ['$scope', '$http', '$q', '$interval', 'uiGridConstants',
  function($scope, $http, $q, $interval, uiGridConstants) {
 

    $scope.gridOptions = {
      enableFiltering: true,
      enableRowSelection: true,
      multiSelect: false,
      enableRowHeaderSelection: false,
      columnDefs: [
          {name: 'id'},
          {name: 'name'},
          {name: 'description'},
          {name: 'price'}
        ],
        paginationPageSizes: [5, 10, 20,25],
        paginationPageSize: 5        
    };



    $scope.saveRow = function(rowEntity) {
      // create a fake promise - normally you'd use the promise returned by $http or $resource
      var promise = $q.defer();
      $scope.gridApi.rowEdit.setSavePromise(rowEntity, promise.promise);
      promise.resolve();
    };

    $scope.gridOptions.onRegisterApi = function(gridApi) {
      //set gridApi on scope
      $scope.gridApi = gridApi;
      gridApi.rowEdit.on.saveRow($scope, $scope.saveRow);

      gridApi.selection.on.rowSelectionChanged($scope, function(row) {
        var msg = 'row selected ' + row.entity.age;
        console.log(row);
      });
    };

    $http
    .get("itemsList")
    .then(function(response) {
    $scope.data = response.data;
    $scope.gridOptions.data = $scope.data; 
    });
    
    //$scope.gridOptions.data = $scope.data;
  }
]);