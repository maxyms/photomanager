angular.module('photomanager', [ 'ui.router', 'ngResource',
		'photomanager.controllers', 'photomanager.services' ]);

angular.module('photomanager').config(function($stateProvider) {
	$stateProvider.state('files', { // state for showing all items
		url : '/files',
		templateUrl : 'partials/files.html',
		controller : 'FilesListController'
	}).state('duplicates', { // state for showing single item
		url : '/duplicates',
		templateUrl : 'partials/duplicates.html',
		controller : 'DuplicatesController'
	}).state('newItem', { // state for adding a new item
		url : '/items/new',
		templateUrl : 'partials/item-add.html',
		controller : 'ItemCreateController'
	}).state('editItem', { // state for updating a item
		url : '/items/:id/edit',
		templateUrl : 'partials/item-edit.html',
		controller : 'ItemEditController'
	});
}).run(function($state) {
	$state.go('files'); // make a transition to items state when app starts
});
