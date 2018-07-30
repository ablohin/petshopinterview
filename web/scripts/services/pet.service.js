'use strict';

angular.module('petshopinterview')
  .service('PetService', ['$resource', function($resource) {
    return $resource('/api/owneranimals', {}, {
      'getAll': {
        method: 'GET',
        isArray: true
      },
      'delete': {
        method: 'DELETE',
        url: '/api/owneranimals/:id',
        params: {id: 'id'}
      },
      'save': {
        method: 'POST',
        url: '/api/owneranimals/create'
      }
    })
  }])