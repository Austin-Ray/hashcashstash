angular.module('navController', [])
    .controller('nav', function ($scope, $state) {
        $scope.title = 'HashCash Stash';

        // returns true if the current router url matches the passed in url
        // so views can set 'active' on links easily
        $scope.isUrl = function (url) {
            if (url === '#') return false;
            return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
        };

        $scope.pages = [
            {
                name: 'Portfolio',
                url: '#/currencys'
            },
            {
                name: 'Account',
                url: '#/account'
            },
            {
                name: 'Status',
                url: '#/basic'
            },
            {
                name: 'FAQ',
                url: '#/faq'
            },
            {
                name: 'About Us',
                url: '#/aboutUs'
            }
        ]
    });
