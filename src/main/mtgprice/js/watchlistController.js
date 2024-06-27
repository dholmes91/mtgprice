var app = angular.module('mtgApp', []);

app.controller('WatchlistController', function ($scope) {
    // Initialize watchlist from localStorage or as an empty array
    $scope.watchlist = JSON.parse(localStorage.getItem('watchlist')) || [];

    // Function to add card to watchlist
    $scope.addToWatchlist = function (card) {
        const existingCard = $scope.watchlist.find(item => item.cardId === card.cardId);
        if (!existingCard) {
            $scope.watchlist.push(card);
            localStorage.setItem('watchlist', JSON.stringify($scope.watchlist));
            $('#toastAddedToWatchlist').toast('show');
            setTimeout(function () {
                $('#toastAddedToWatchlist').toast('hide');
            }, 2000);
        } else {
            alert('Card is already in the watchlist.');
        }
    };
});