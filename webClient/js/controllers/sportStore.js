angular.module("sportsStore")
    .constant("categoriesUrl", "http://localhost:8080/categories")
    .constant("orderUrl", "http://localhost:8080/orders")
    .controller("sportsStoreCtrl", function ($scope, $http, categoriesUrl, cart, orderUrl, $location) {
        $scope.categories = {};
        $http.get(categoriesUrl)
            .success(function (data) {
                $scope.categories = data;
            })
            .error(function (error) {
                $scope.categoryError = error;
            });
        $scope.sendOrder = function (shippingDetails) {
            var order = angular.copy(shippingDetails);
            order.lineItems = cart.getLineItems();
            //order.lineItems =
            //[
            //    {
            //        "product":
            //            {
            //                "productId":1,
            //                "productName":"Kayak",
            //                "description":"A boat for one person",
            //                "category":
            //                {
            //                    "catId":1,
            //                    "catName":"Watersports"
            //                },
            //                "price":275.0},
            //        "quantity": "1"
            //    },
            //
            //]
            //;
            $http.post(orderUrl, order)
                .success(function (data) {
                    $scope.orderId = data.cartId;
                    cart.getLineItems().length = 0;
                })
                .error(function (error) {
                    $scope.orderError = error;
                })
                .finally(function () {
                    $location.path("/complete");
                });
        }
    });