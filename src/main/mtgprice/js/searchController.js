(function () {
    var mtgapp = angular.module('mtgapp');

    mtgapp.controller('searchController', function ($scope, $http) {

        $scope.showSpinner = true;
        $scope.cards = [];
        $scope.sortField = '';
        $scope.reverse = false;
        $scope.watchList = localStorage.getItem('watchlist');
        $scope.watchList = $scope.watchList ? new Set(JSON.parse($scope.watchList)) : new Set();

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
                    console.log('number of cards: ' + $scope.cards.length);
                    $scope.showSpinner = false;
                }, function (response) {
                    console.log('error http GET cards: ' + response.status);
                    $scope.showSpinner = false;
                });
        };

        $scope.orderByColumn = function (column) {
            $scope.orderByValue = column;
            if ($scope.reverse == true) {
                $scope.reverse = false;
            } else {
                $scope.reverse = true;
            }
        }


        $scope.getCardsByName = function (name) {
            if (!name) {
                console.log('error: no card name provided');
                return;
            }
            $scope.showSpinner = true;
            $http.get(`http://localhost:8080/api/cards/name/${name}`)
                .then(function (response) {
                    var cards = response.data;
                    if (cards.length > 0) {
                        $scope.cards = cards;
                    } else {
                        $scope.cards = [];
                        console.log('error: no cards found');
                    }
                    $scope.showSpinner = false;
                }, function (response) {
                    console.log('error http GET cards by name: ' + response.status);
                    $scope.showSpinner = false;
                });
        };

        $scope.getCardsById = function (cardId) {
            if (!cardId) {
                console.log('error: no ID provided');
                return;
            }
            $scope.showSpinner = true;
            $http.get(`http://localhost:8080/api/cards/id/${cardIdValue}`)
                .then(function (response) {
                    var cards = response.data;
                    if (cards.length > 0) {
                        $scope.cards = cards;
                    } else {
                        $scope.cards = [];
                        console.log('error: no cards found');
                    }
                    $scope.showSpinner = false;
                }, function (response) {
                    console.log('error http GET cards by id: ' + response.status);
                    $scope.showSpinner = false;
                });
        };

        $scope.getTopMovers = function () {
            $http.get("http://localhost:8080/api/cards/topMovers")
                .then(function (response) {
                    $scope.cards = response.data;
                    console.log('number of top movers: ' + $scope.cards.length);
                    $scope.showSpinner = false;
                }, function (response) {
                    console.log('error http GET top movers: ' + response.status);
                    $scope.showSpinner = false;
                });
        };

        $scope.watchList = JSON.parse(localStorage.getItem('watchlist')) || [];

        $scope.addToWatchList = function (card) {
            // Check if the card is already in the watchlist
            const existingCard = $scope.watchList.find(item => item.cardId === card.cardId);
            if (!existingCard) {
                $scope.watchList.push(card);
                localStorage.setItem('watchlist', JSON.stringify($scope.watchList));
                alert('Added to watchlist!');
            } else {
                alert('Card is already in the watchlist.');
            }
            console.log($scope.watchList);
        };

        $scope.getTopMovers();

        $scope.getPriceDiffClass = function (priceDiff) {
            return {
                'text-success': priceDiff > 0,
                'text-danger': priceDiff < 0
            };
        };

        $scope.openPurchaseUrl = function (purchase_url) {
            window.open(purchase_url, '_blank');
        };

        // $scope.getPriceDiffIndicator = function (priceDiff) {
        //     if (priceDiff > 0) {
        //         return priceDiff + ' &#9650;'; // Up arrow Unicode
        //     } else if (priceDiff < 0) {
        //         return priceDiff + ' &#9660;'; // Down arrow Unicode
        //     } else {
        //         return priceDiff;
        //     }
        // };

    });
})();