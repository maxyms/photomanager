angular.module('photomanager.controllers', []).controller('FilesListController',
		function($scope, $state, /*popupService,*/ $window, Files) {
			
			Files.get(function(data){
				$scope.files = data;
			});

			$scope.deleteFile = function(file) {
				/*if (popupService.showPopup('Really delete this?')) {
					item.$delete(function() {
						$window.location.href = '';
					});
				}*/
			};
			
			$scope.addFiles = function() {
				Files.add();
			};
			
		}).controller('DuplicatesController',
		function($scope, $stateParams, Duplicates, Files) {
			Duplicates.get.then(function(result) {
				console.log(result.data);
//				console.log(result.data.data);
//				console.log(result.data.data.fundOptions);
//				if(result.data.isSuccess){
//					$scopeModal.fundOptions = result.data.data.fundOptions;
//				}
				$scope.duplicates = result.data;
			}, function(result) {
				console.error("Error: No data returned. " + result);
			});
			
			$scope.deleteFile = function(_id) {
				console.log('deleting file ' + _id);
				Files.delete(_id);
			};
			
			
			
		}).controller('ItemCreateController',
		function($scope, $state, $stateParams, Item) {
			$scope.item = new Item();

			$scope.addItem = function() {
				$scope.item.$save(function() {
					$state.go('items');
				});
			};
		}).controller('ItemEditController',
		function($scope, $state, $stateParams, Item) {
			$scope.updateItem = function() {
				$scope.item.$update(function() {
					$state.go('items');
				});
			};

			$scope.loadItem = function() {
				$scope.item = Item.get({
					id : $stateParams.id
				});
			};

			$scope.loadItem();
		});