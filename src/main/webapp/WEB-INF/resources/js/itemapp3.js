    var app = angular.module('app', ['ngAnimate', 'ngTouch', 'ui.grid', 'ui.grid.selection', 'ui.grid.exporter']);
     
    app.controller('MainCtrl', ['$scope', '$http', function ($scope, $http) {
      $scope.gridOptions = {
    	      columnDefs: [
    	          {name: 'id'},
    	          {name: 'name'},
    	          {name: 'description'},
    	          {name: 'price'}
    	        ],
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
        exporterExcelSheetName: 'Sheet1',
        onRegisterApi: function(gridApi){
          $scope.gridApi = gridApi;
        }
      };
     
      $http.get('itemsList')
      .then(function(response) {
        $scope.gridOptions.data = response.data;
      });
     
    }]);