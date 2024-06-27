(function () {
    var mtgapp = angular.module('mtgapp');

    mtgapp.controller('searchController', function ($scope, $http, $timeout) {
        $scope.showSpinner = true;
        $scope.cards = [];
        $scope.sortField = '';
        $scope.reverse = false;
        $scope.watchlist = JSON.parse(localStorage.getItem('watchlist')) || [];

        $scope.sortBy = function (field) {
            if ($scope.sortField === field) {
                $scope.reverse = !$scope.reverse;
            } else {
                $scope.sortField = field;
                $scope.reverse = false;
            }
        };

        $scope.getAllCards = function () {
            $scope.showSpinner = true;
            $http.get("http://localhost:8080/api/cards")
                .then(function (response) {
                    $scope.cards = response.data;
                    console.log('Number of cards: ' + $scope.cards.length);
                    $scope.showSpinner = false;
                }, function (response) {
                    console.log('Error HTTP GET cards: ' + response.status);
                    $scope.showSpinner = false;
                });
        };

        $scope.orderByColumn = function (column) {
            $scope.orderByValue = column;
            $scope.reverse = !$scope.reverse;
        };

        $scope.getCardsByName = function (name) {
            if (!name) {
                console.log('Error: No card name provided');
                return;
            }
            $scope.showSpinner = true;
            $http.get(`http://localhost:8080/api/cards/name/${name}`)
                .then(function (response) {
                    var cards = response.data;
                    $scope.cards = cards.length > 0 ? cards : [];
                    $scope.showSpinner = false;
                }, function (response) {
                    console.log('Error HTTP GET cards by name: ' + response.status);
                    $scope.showSpinner = false;
                });
        };

        $scope.getCardsById = function (cardId) {
            if (!cardId) {
                console.log('Error: No ID provided');
                return;
            }
            $scope.showSpinner = true;
            $http.get(`http://localhost:8080/api/cards/id/${cardId}`)
                .then(function (response) {
                    var cards = response.data;
                    $scope.cards = cards.length > 0 ? cards : [];
                    $scope.showSpinner = false;
                }, function (response) {
                    console.log('Error HTTP GET cards by ID: ' + response.status);
                    $scope.showSpinner = false;
                });
        };

        $scope.getTopMovers = function () {
            $http.get("http://localhost:8080/api/cards/topMovers")
                .then(function (response) {
                    $scope.cards = response.data;
                    console.log('Number of top movers: ' + $scope.cards.length);
                    $scope.showSpinner = false;
                }, function (response) {
                    console.log('Error HTTP GET top movers: ' + response.status);
                    $scope.showSpinner = false;
                });
        };

        $scope.addToWatchlist = function (card) {
            const existingCard = $scope.watchlist.find(item => item.cardId === card.cardId);
            if (!existingCard) {
                $scope.watchlist.push(card);
                localStorage.setItem('watchlist', JSON.stringify(Array.from($scope.watchlist)));
                alert('Added to watchlist!')
                $timeout(function () {
                    $scope.showToast = false;
                }, 2000);
            } else {
                alert('Card is already in the watchlist.');
            }
            console.log($scope.watchlist);
        };

        $scope.clearWatchlist = function () {
            $scope.watchlist = [];
            localStorage.setItem('watchlist', JSON.stringify($scope.watchlist));
            $scope.showToast = true;
            $timeout(function () {
                $scope.showToast = false;
            }, 2000);
            console.log('Watchlist cleared:', $scope.watchlist);
        };
        
        

        $scope.getTopMovers();

        $scope.getPriceDiffClass = function (priceDiff) {
            return {
                'text-success': priceDiff > 0,
                'text-danger': priceDiff < 0
            };
        };

        $scope.openPurchaseUrl = function (purchaseUrl) {
            window.open(purchaseUrl, '_blank');
        };

    });
})();