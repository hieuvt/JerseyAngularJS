angular.module("sportsStore")
    .constant("productListActiveClass", "btn-primary")
    .constant("productListPageCount", 3)
    .constant("productListByCategoryUrl", "http://localhost:8080/products/category?categoryId=")
    .controller("productListCtrl", function ($scope, $filter, $http, productListByCategoryUrl, productListActiveClass, productListPageCount, cart) {

        $scope.selectedCategory = null;
        $scope.selectedPage = 1;
        $scope.pageSize = productListPageCount;

        $scope.selectCategory = function (newCategory) {
            $scope.selectedCategory = newCategory;
            newCategory.products = {};
            $http.get(productListByCategoryUrl + newCategory.catId)
                .success(function (data) {
                    newCategory.products = data;
                    $scope.products = data;
                })
                .error(function (error) {
                    newCategory.products = error;
                });
            $scope.selectedPage = 1;
        }

        $scope.selectPage = function (newPage) {
            $scope.selectedPage = newPage;
        }

        $scope.categoryFilterFn = function (product) {
            //console.log(product);
            return $scope.selectedCategory == null ||
                product.category.catId ==  $scope.selectedCategory.catId;
        }

        $scope.getCategoryClass = function (category) {
            return $scope.selectedCategory == category ? productListActiveClass : "";
        }

        $scope.getPageClass = function (page) {
            return $scope.selectedPage == page ? productListActiveClass : "";
        }

        $scope.addProductToCart = function (product) {
            cart.addProduct(product);
        }
    });