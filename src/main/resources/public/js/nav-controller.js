angular.module('navController', [])
	.controller('nav', function($scope, $state) {
		$scope.title = 'CryptoCurrencies';

		// returns true if the current router url matches the passed in url
		// so views can set 'active' on links easily
		$scope.isUrl = function(url) {
			if (url === '#') return false;
			return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
		};

		$scope.pages = [
			{
				name: 'Home',
				url: '#'
			},
			{
				name: 'Portfolio',
				url: '#/currencys'
			},
            {
                name: 'FAQ',
                url: '#/faq'
            },
            {
                name: 'Account',
                url: '#/account'
            },
			{
                name: 'Graph',
                url: '#/basic'
            },
            {
                name: 'About Us',
                url: '#/aboutUs'
            }
		]
	});
