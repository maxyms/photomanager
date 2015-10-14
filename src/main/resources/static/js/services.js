angular.module('photomanager.services', []).factory('Files',
		function($resource) {
			return $resource('/api/files/:id', {
				id : '@id'
			}, {
				update : {
					method : 'PUT'
				}
			});
		}).factory('Duplicates', function($http) {
	var getDuplicates = $http({
		method : 'GET',
		url : '/api/duplicate'
	});

	return {
		get : getDuplicates
	}
});