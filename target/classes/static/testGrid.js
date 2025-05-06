var app = angular.module('app', ['ngAnimate','ngTouch', 'ui.grid', 'ui.grid.edit', 'ui.grid.rowEdit', 'ui.grid.selection','ui.grid.pagination','ui.grid.exporter','ui.grid.resizeColumns', 'ui.grid.moveColumns']);


app.controller('MainCtrl', ['$scope', '$http', '$q', '$interval', 'uiGridConstants',
  function($scope, $http, $q, $interval, uiGridConstants) {
 

    $scope.gridOptions = {
      enableFiltering: true,
      enableRowSelection: true,
      multiSelect: false,
      enableRowHeaderSelection: false,
      enableGridMenu: true,
      enableSorting: true,
      columnDefs: [
          {name: 'id',minWidth: 200, width: 250, enableColumnResizing: false },
          {name: 'name' ,width: '30%', maxWidth: 200, minWidth: 70},
          {name: 'description', width: '30%', maxWidth: 200, minWidth: 70},
          {name: 'price', width: '20%'}
        ],
        paginationPageSizes: [5, 10, 20,25],
        paginationPageSize: 5,
        enableGridMenu: true,
        enableSelectAll: true,
        exporterCsvFilename: 'myFile.csv',
        exporterPdfDefaultStyle: {fontSize: 9},
        exporterPdfTableStyle: {margin: [30, 30, 30, 30]},
        exporterPdfTableHeaderStyle: {fontSize: 10, bold: true, italics: true, color: 'red'},
        exporterPdfHeader: { text: "My Header", style: 'headerStyle' },
        exporterPdfFooter: function ( currentPage, pageCount ) {
          return { text: currentPage.toString() + ' of ' + pageCount.toString(), style: 'footerStyle' };
        },
        exporterPdfCustomFormatter: function ( docDefinition ) {
          docDefinition.styles.headerStyle = { fontSize: 22, bold: true };
          docDefinition.styles.footerStyle = { fontSize: 10, bold: true };
          return docDefinition;
        },
        exporterPdfOrientation: 'portrait',
        exporterPdfPageSize: 'LETTER',
        exporterPdfMaxGridWidth: 500,
        exporterCsvLinkElement: angular.element(document.querySelectorAll(".custom-csv-link-location")),
        exporterExcelFilename: 'myFile.xlsx',
        exporterExcelSheetName: 'Sheet1'        
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
     	$scope.gridOptions.data = response.data;
 
    });
    

  }
]);