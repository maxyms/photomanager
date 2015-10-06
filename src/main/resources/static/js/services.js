angular.module('photomanager.services', []).factory('Files', function($resource) {
  return $resource('/api/files/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
});