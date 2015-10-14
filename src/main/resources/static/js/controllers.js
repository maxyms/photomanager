angular.module('photomanager.controllers', []).controller('FilesListController',
		function($scope, $state, /*popupService,*/ $window, Files) {
			$scope.files = Files.query();

			$scope.deleteItem = function(item) {
				/*if (popupService.showPopup('Really delete this?')) {
					item.$delete(function() {
						$window.location.href = '';
					});
				}*/
			};
		}).controller('DuplicatesController',
		function($scope, $stateParams, Duplicates) {
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