'use strict'

angular.module('petshopinterview')
  .controller('PetCtrl', ['$scope', 'PetService', function($scope, PetService) {
    $scope.pets = [];
    $scope.pet = {};

    $scope.loadAll = function() {
      PetService.getAll().$promise.then(function(response) {
        $scope.pets = response;
      })
    };

    $scope.clear = function() {
      $scope.pet = {};
    };

    $scope.addPet = function(pet) {
      PetService.save(pet).$promise.then(function(response) {
        $scope.clear();
        $scope.loadAll();
      })
    };

    $scope.deletePet = function(petId) {
      PetService.delete({'id':petId}).$promise.then(function(response) {
        $scope.loadAll();
      })
    };

    $scope.loadAll();

}])