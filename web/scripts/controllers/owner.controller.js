'use strict'

angular.module('petshopinterview')
  .controller('OwnerCtrl', ['$scope', 'OwnerService', function($scope, OwnerService){
    $scope.owners = [];
    $scope.owner = {};

    $scope.loadAll = function() {
      OwnerService.getAll().$promise.then(function(response) {
        $scope.owners = response;
      })
    };

    $scope.clear = function() {
      $scope.owner = {};
    };

    $scope.addOwner = function(owner) {
      OwnerService.save(owner).$promise.then(function(response) {
        $scope.clear();
        $scope.loadAll();
      })
    };

    $scope.deleteOwner = function(ownerId) {
      OwnerService.delete({'id':ownerId}).$promise.then(function(response) {
        $scope.loadAll();
      })
    };

    $scope.loadAll();

}])