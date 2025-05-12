       window.App = angular.module('App', ['ui.bootstrap']);

       App.controller('mainCtrl', ['$scope','$http', function($scope,$http) {

       $http.get('empleadosList')
       .success(function (response){
         $scope.objects = response;
         console.log($scope.objects);


         
         $scope.totalItems= $scope.objects.length;
         $scope.currentPage = 1;
         $scope.numPerPage = 15;
         
         $scope.paginate = function(value) {
           var begin, end, index;
           begin = ($scope.currentPage - 1) * $scope.numPerPage;
           end = begin + $scope.numPerPage;
           index = $scope.objects.indexOf(value);
           return (begin <= index && index < end);
         };
         
            $scope.export = function () {
                html2canvas(document.getElementById('tabla'), {
                    onrendered: function (canvas) {
                        var data = canvas.toDataURL("image/png");
                        var docDefinition = {
                            content: [{
                                image: data,
                                width: 500
                            }]
                        };
                        pdfMake.createPdf(docDefinition).download("document.pdf");
                    }
                });
             }         
         
     })
     
       }]);