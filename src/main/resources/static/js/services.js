angular.module('photomanager.services', []).factory('Files', function($http) {

	return {
		get : function(cb) {
			$http({
				method : 'GET',
				url : '/api/files'
			}).then(function(result) {
				console.log(result.data);
				cb(result.data);
			}, function(result) {
				console.error("Error: No data returned. " + result);
			});
		},
		add : function() {
			$http({
				method : 'GET',
				url : '/api/files/add'
			}).then(function(result) {
				console.log(result.data);
			}, function(result) {
				console.error("Error: No data returned. " + result);
			});
		},
		delete : function(_id) {
			$http({
				method : 'DELETE',
				url : '/api/files',
				params : {
					id : _id
				}
			}).then(function(result) {
				console.log(result.data);
			}, function(result) {
				console.error("Error: No data returned. " + result);
			});
		}
	}

}).factory('Duplicates', function($http) {
	var getDuplicates = $http({
		method : 'GET',
		url : '/api/duplicate'
	});

	return {
		get : getDuplicates
	}
});