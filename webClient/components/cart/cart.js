angular.module("cart", [])
    .factory("cart", function () {
        var lineItems = [];
        return {
            addProduct: function (product) {
                var addedToExistingItem = false;
                for (var i = 0; i < lineItems.length; i++) {
                    if (lineItems[i].product.productId == product.productId) {
                        lineItems[i].quantity++;
                        addedToExistingItem = true;
                        break;
                    }
                }
                if (!addedToExistingItem) {
                    lineItems.push({
                        quantity: 1, product: product
                    });
                }
            },
            removeProduct: function (productId) {
                for (var i = 0; i < lineItems.length; i++) {
                    if (lineItems[i].product.productId == productId) {
                        lineItems.splice(i, 1);
                        break;
                    }
                }
            },
            getLineItems: function () {
                return lineItems;
            }
        }
    })
    .directive("cartSummary", function (cart) {
        return {
            restrict: "E",
            templateUrl: "components/cart/cartSummary.html",
            controller: function ($scope) {
                var lineItems = cart.getLineItems();
                $scope.total = function () {
                    var total = 0;
                    for (var i = 0; i < lineItems.length; i++) {
                        total += (lineItems[i].product.price * lineItems[i].quantity);
                    }
                    return total;
                }
                $scope.itemCount = function () {
                    var total = 0;
                    for (var i = 0; i < lineItems.length; i++) {
                        total += lineItems[i].quantity;
                    }
                    return total;
                }
            }
        };
    });
