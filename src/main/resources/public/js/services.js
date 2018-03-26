angular.module('app.services', []).factory('Currency', function($resource) {
  return $resource('/api/v1/currencys/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
