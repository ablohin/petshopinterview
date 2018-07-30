'use strict';

angular.module('petshopinterview')
  .service('AnimalService', ['$resource', function($resource) {
    return $resource('/api/animals', {}, {
      'getAll': {
        method: 'GET',
        isArray: true
      },
      'delete': {
        method: 'DELETE',
        url: '/api/animals/:id',
        params: {id: 'id'}
      },
      'save': {
        method: 'POST',
        url: '/api/animals/create'
      }
    })
  }]);