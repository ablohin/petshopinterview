'use strict';

angular.module('petshopinterview')
  .service('OwnerService', ['$resource', function($resource) {
    return $resource('/api/owners', {}, {
      'getAll': {
        method: 'GET',
        isArray: true
      },
      'delete': {
        method: 'DELETE',
        url: '/api/owners/:id',
        params: {id: 'id'}
      },
      'save': {
        method: 'POST',
        url: '/api/owners/create'
      }
    })
  }]);