angular.module("sportsStore")
    .controller("cartSummaryController", function($scope, cart) {
        $scope.cartData = cart.getLineItems();
        $scope.total = function () {
            var total = 0;
            for (var i = 0; i < $scope.cartData.length; i++) {
                total += ($scope.cartData[i].price * $scope.cartData[i].quantity);
            }
            return total;
        }
        $scope.remove = function (id) {
            cart.removeProduct(id);
        }
    });