'use strict';

angular.module('petshopinterview')
  .controller('AnimalCtrl', ['$scope', 'AnimalService', function($scope, AnimalService){
    $scope.animals = [];
    $scope.animal = {};

    $scope.loadAll = function() {
      AnimalService.getAll().$promise.then(function(response) {
        $scope.animals = response;
      })
    };

    $scope.clear = function() {
      $scope.animal = {};
    };

    $scope.addAnimal = function(animal) {
      AnimalService.save(animal).$promise.then(function(response) {
        $scope.clear();
        $scope.loadAll();
      })
    };

    $scope.deleteAnimal = function(animalId) {
      AnimalService.delete({'id':animalId}).$promise.then(function(response) {
        $scope.loadAll();
      })
    };

    $scope.loadAll();

}])