/**
 * Created by hieu.vutrong on 1/6/2015.
 */

angular.module('ngClient.services', ['ngResource'])
    .factory("Books", function ($resource, $q) {
        var settings = {};
        var bookResource = $resource(
            "http://localhost:8080/books", {}, {
                create: {method: 'POST'}
            }
        );

        settings.query = function () {
            var deferredObject = $q.defer();
            bookResource.query().$promise.then(function (result) {
                deferredObject.resolve(result);
            }, function (errorMsg) {
                deferredObject.reject(errorMsg);
            });
            return deferredObject.promise;
        };

        settings.createNewBook = function (book) {
            var deferredObject = $q.defer();
            bookResource.create(book).$promise.then(function (result) {
                deferredObject.resolve(result);
            }, function (errorMsg) {
                deferredObject.reject(errorMsg);
            });
            return deferredObject.promise;
        };

        return settings;
    })

    .factory('Book', function ($resource, $q, $window) {
        var settings = {};
        var bookResource = $resource(
            "http://localhost:8080/books/:bookId",
            {bookId: '@id'}, {
                update: {method: 'PUT', params: {bookId: '@id'}}
            }
        );

        settings.get = function (id) {
            var deferredObject = $q.defer();
            bookResource.get({bookId: id}).$promise.then(function (result) {
                deferredObject.resolve(result);
            }, function (errorMsg) {
                deferredObject.reject(errorMsg);
            });
            return deferredObject.promise;
        }

        settings.delete = function (id) {
            bookResource.delete({bookId: id})
        }

        settings.update = function(book) {
            var deferredObject = $q.defer();
            bookResource.update(book).$promise.then(function (result) {
                deferredObject.resolve(result);
            }, function (errorMsg) {
                deferredObject.reject(errorMsg);
            });
            return deferredObject.promise;
        }

        return settings;
    })
