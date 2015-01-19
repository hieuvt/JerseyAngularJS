/**
 * Created by hieu.vutrong on 1/6/2015.
 */

angular.module('ngClient.controllers', ["ngResource"])

    .controller("BookCtrl", function ($scope, Books, Book, $location, $window) {
        Books.query().then(function (result) {
            $scope.books = result;
        }, function (error) {
            $scope.errorMess = JSON.stringify(error);
        });

        $scope.editBook = function (bookId) {
            $location.path('/book-detail/' + bookId);
        }

        $scope.deleteBook = function (bookId) {
            Book.delete(bookId);
            Books.query().then(function (result) {
                $window.location.reload()
            }, function (error) {
                $scope.errorMess = JSON.stringify(error);
            });
        }

        $scope.createNewBook = function() {
            $location.path('/book-creation')
        }
    })

    .controller("BookDetailCtrl", function ($scope, Book, $routeParams, $location){
        Book.get( $routeParams.bookId).then(function( result ) {
            $scope.book = result;
        }, function(error) {
        });

        $scope.cancelEditBook = function (){
            $location.path('/book-list')
        };

        $scope.updateBook = function (){
            Book.update($scope.book).then(function (result) {
                $location.path('/book-list');
            }, function (error) {
                $scope.errorMess = JSON.stringify(error);
            });
        }
    })

.controller('BookCreationCtrl', function ($scope, Books, $location){
        $scope.createNewBook = function (){
            Books.createNewBook($scope.book).then(function (result) {
                $location.path('/book-list');
            }, function (error) {
                $scope.errorMess = JSON.stringify(error);
            });
        }
        $scope.cancelCreateNewBook = function (){
            $location.path('/book-list')
        }
    })