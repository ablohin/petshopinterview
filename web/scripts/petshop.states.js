'use strict'

angular.module('petshopinterview')
  .config(['$stateProvider', function($stateProvider) {
    $stateProvider
      .state('AnimalState', {
        url: '/animals',
        templateUrl: 'templates/animals.template.html',
        controller: 'AnimalCtrl'
      })
      .state('OwnerState', {
        url: '/owners',
        templateUrl: 'templates/owners.template.html',
        controller: 'OwnerCtrl'
      })
      .state('PetState', {
        url: '/pets',
        templateUrl: 'templates/pets.template.html',
        controller: 'PetCtrl'
      })
}])