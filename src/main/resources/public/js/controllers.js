angular.module('app.controllers', [])

.controller('CurrencyListController', function($scope, $state, popupService, $window, Currency) {
  $scope.currencys = Currency.query(); //fetch all currencys. Issues a GET to /api/vi/currencys

  $scope.deleteCurrency = function(currency) { // Delete a Currency. Issues a DELETE to /api/v1/currencys/:id
    if (popupService.showPopup('Really delete this?')) {
        currency.$delete(function() {
        $scope.currencys = Currency.query();
        $state.go('currencys');
      });
    }
  };
})

.controller('CurrencyViewController', function($scope, $stateParams, Currency) {
  $scope.currency = Currency.get({ id: $stateParams.id }); //Get a single currency.Issues a GET to /api/v1/currencys/:id
})

.controller('CurrencyCreateController', function($scope, $state, $stateParams, Currency) {
  $scope.currency = new Currency();  //create new currency instance. Properties will be set via ng-model on UI

  $scope.addCurrency = function() { //create a new currency. Issues a POST to /api/v1/currencys
    $scope.currency.$save(function() {
      $state.go('currencys'); // on success go back to the list i.e. currencys state.
    });
  };
})

.controller('CurrencyEditController', function($scope, $state, $stateParams, Currency) {
  $scope.updateCurrency = function() { //Update the edited currency. Issues a PUT to /api/v1/currencys/:id
    $scope.currency.$update(function() {
      $state.go('currencys'); // on success go back to the list i.e. currencys state.
    });
  };

  $scope.loadCurrency = function() { //Issues a GET request to /api/v1/currencys/:id to get a currency to update
    $scope.currency = Currency.get({ id: $stateParams.id });
  };

  $scope.loadCurrency(); // Load a currency which can be edited on UI
})

.controller('UserViewController', function($scope) {
	$scope.first_name = "Greatest";
	$scope.last_name = "Ever";
	$scope.email = "test@test.com";
	$scope.password = "testpw";
});
