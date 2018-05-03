angular.module('app.controllers', [])

    .controller('CurrencyListController', function ($scope, $state, popupService, $window, Currency) {
        $scope.currencys = Currency.query(); //fetch all currencys. Issues a GET to /api/vi/currencys
        $scope.deleteCurrency = function (currency) { // Delete a Currency. Issues a DELETE to /api/v1/currencys/:id
            if (popupService.showPopup('Really delete this?')) {
                currency.$delete(function () {
                    $scope.currencys = Currency.query();
                    $state.go('currencys');
                });
            }
        };
    })
    .controller("CurrencyController", function ($scope, $http) {
        $scope.list_loading = true;
        $scope.graph_loading = false; // TODO: CHANGE TO TRUE

        $scope.assetList = [];
        $scope.assetPriceHistory = [];
        $scope.graphData = [];
        $scope.selectedButton = 14;

        refreshPageData();

        function refreshPageData() {
            $http({
                method: 'GET',
                url: 'api/v1/currency/all'
            }).then(function successCallback(response) {
                $scope.list_loading = false;
                $scope.assetList = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText)
            })
        }

        $scope.loadGraphData = function loadGraphData(uid) {
            console.log(uid);
            $http({
                method: 'GET',
                url: 'api/v1/currency/price_history',
                params: {uid: uid}
            }).then(function successCallback(response) {
                $scope.graph_loading = false;
                $scope.graphData = response.data;
                $scope.loadGraph();
            })
        };

        $scope.loadGraphData(14);

        $scope.loadGraph = function () {
            var ctx = document.getElementById("linechart").getContext("2d");
            var linechart =
                new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: $scope.graphData[0].labels,
                        datasets: $scope.graphData
                    },
                    options: {
                        maintainAspectRatio: false,
                        legend: {
                            display: false,
                        },
                        title: {
                            display: false,
                            responsive: false,
                            text: 'Price of cryptocurrencies over past 7 days'
                        },
                        elements: {
                            point:{
                                radius: 0
                            }
                        }
                    }
                });
        };

        $scope.doAlert = function(uid) {
            $scope.loadGraphData(uid);
            $scope.selectedButton = uid;
        }
    })
    .controller("PortfolioController", function ($scope, $http) {
        $scope.total = 0.0;

        $scope.portList = [];
        $scope.assetList = [];
        $scope.allAsset = [];
        $scope.graphData = [];
        $scope.graphLabels = [];

        $scope.loading = true;
        $scope.graph_loading = true;

        $scope.refreshPageData = function refreshPageData() {
            $http({
                method: 'GET',
                url: 'api/v1/port/owned'
            }).then(function successCallback(response) {
                $scope.portList = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText)
            });
            $http({
                method: 'GET',
                url: 'api/v1/port/total'
            }).then(function successCallback(response) {
                $scope.total = response.data;
                $scope.loading = false;
                $scope.loadGraphData1();
            }, function errorCallback(response) {
                console.log(response.statusText)
            });
            $http({
                method: 'GET',
                url: 'api/v1/port/all'
            }).then(function successCallback(response) {
                $scope.allAsset = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText)
            });
            $http({
                method: 'GET',
                url: 'api/v1/currency/all'
            }).then(function successCallback(response) {
                $scope.assetList = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText)
            });
        };
        $scope.submit = function submit() {
            var data = {
                quant: $scope.selectedAsset.quant,
                uid: $scope.selectedAsset.uid
            };

            $http({
                method: 'POST',
                url: 'api/v1/port/modquant',
                data: data
            }).finally(function() {
                  $scope.refreshPageData();
                  $root.refreshView();
                }
            );
        };

        $scope.delCurr = function(uid) {
            console.log(uid);
            var data = {
                quant: 0.0,
                uid: uid
            };

            $http({
                method: 'POST',
                url: 'api/v1/port/modquant',
                data: data
            }).finally(function() {
                $scope.refreshPageData();
                $root.refreshView();
            });
        };


        $scope.filterQuant = function () {
            return function (item) {
                return !(item.quant === 0);
            };
        };
        $scope.loadGraphData1 = function () {
            $http({
                method: 'GET',
                url: 'api/v1/port/wealth_hist'
            }).then(function successCallback(response) {
                $scope.graphData = response.data;
                $scope.loadGraph1();
            })
        };

        $scope.loadGraph1 = function () {
            $scope.graph_loading = false;
            var canvas = document.getElementById("linechart");
            var ctx = document.getElementById("linechart").getContext("2d");

            if ($scope.linechart != null) {
                $scope.linechart.destroy();
            }

            $scope.linechart =
                new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: $scope.graphData[0].labels,
                        datasets: $scope.graphData
                    },
                    options: {
                        maintainAspectRatio: false,
                        title: {
                            display: false,
                            text: 'Wealth'
                        },
                        legend: {
                            display: false
                        },
                        animation: {
                            easing: "easeInOutQuad"
                        }
                    }
                });
        };
        $scope.selectedAsset = $scope.allAsset[0];
        $scope.refreshPageData();
    })

    .controller('CurrencyViewController', function ($scope, $stateParams, Currency) {
        $scope.currency = Currency.get({id: $stateParams.id}); //Get a single currency.Issues a GET to /api/v1/currencys/:id
    })

    .controller('CurrencyCreateController', function ($scope, $state, $stateParams, Currency) {
        $scope.currency = new Currency();  //create new currency instance. Properties will be set via ng-model on UI

        $scope.addCurrency = function () { //create a new currency. Issues a POST to /api/v1/currencys
            $scope.currency.$save(function () {
                $state.go('currencys'); // on success go back to the list i.e. currencys state.
            });
        };
    })

    .controller('CurrencyEditController', function ($scope, $state, $stateParams, Currency) {
        $scope.updateCurrency = function () { //Update the edited currency. Issues a PUT to /api/v1/currencys/:id
            $scope.currency.$update(function () {
                $state.go('currencys'); // on success go back to the list i.e. currencys state.
            });
        };

        $scope.loadCurrency = function () { //Issues a GET request to /api/v1/currencys/:id to get a currency to update
            $scope.currency = Currency.get({id: $stateParams.id});
        };

        $scope.loadCurrency(); // Load a currency which can be edited on UI
    })

    .controller('AccountInfoController', ['$scope', 'Account', function ($scope, Account) {
        $scope.acc = Account.get();
//	$state.lastName = "";

//	function getAccountInfo() {
//		var url = $location.path("localhost:8080/api/v1/account");

//		$http.get(url).then(function (response) {
//			$state.firstName = response.firstName;
//			$state.lastName = response.lastName;
//		}, function error(response) {
//			$scope.error = "error";
//		});
//	}

//	getAccountInfo();
    }]);

