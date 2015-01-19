//Define an angular module for our app
angular.module("ngClient", ["ngClient.controllers", "ngClient.services", "ngRoute"])

//Define Routing for app
//Uri /AddNewOrder -> template AddOrder.html and Controller AddOrderController
//Uri /ShowOrders -> template ShowOrders.html and Controller AddOrderController
    .config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.when('/book-list', {
                templateUrl: 'partials/book-list.html',
                controller: 'BookCtrl'
            }).when('/book-detail/:bookId', {
                templateUrl: 'partials/book-detail.html',
                controller: 'BookDetailCtrl'
            }).when('/book-creation', {
                templateUrl: 'partials/book-creation.html',
                controller: 'BookCreationCtrl'
            }).otherwise({
                redirectTo: '/book-list'
            });
        }]);