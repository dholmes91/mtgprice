
(function () {


    var mtgapp = angular.module('mtgapp');

    mtgapp.controller('searchController', function ($scope, $http, $location) {

        $scope.showSpinner = true;

        $scope.getAllCards = function () {
            $scope.showSpinner = true;
            $http.get("http://localhost:8080/api/cards")
                .then(function (response) {
                    $scope.cards = response.data;
                    console.log('number of cards: ' + $scope.cards.length);
                    $scope.showSpinner = false;
                }, function (response) {
                    console.log('error http GET cards: ' + response.status);
                });
        }

        $scope.getTopMovers = function() {
            $scope.showSpinner = true;
            $http.get("http://localhost:8080/api/cards/topMovers")
            .then(function (response) {
                $scope.cards = response.data;
                console.log('number of cards: ' + $scope.cards.length);
                $scope.showSpinner = false;
            }, function (response) {
                console.log('error http GET cards: ' + response.status);
            });
        }

        // $scope.goToUpdateView = function (movieId) {
        //     console.log('go to update view: ' + movieId);
        //     $location.path('/update/' + movieId)
        // }

        // $scope.getAllMovies();
    });
})()





// Test data
// $scope.movies = [
//     {
//         createDateTime: "2018-11-01 19:52:28.0",
//         genre: "Action",
//         id: 10,
//         releaseYear: 1990,
//         title: "The World Is Not Enough"
//     },
//     {
//         createDateTime: "2018-11-08 19:42:35.0",
//         genre: "Horror",
//         id: 11,
//         releaseYear: 1977,
//         title: "Star Wars"
//     },
//     {
//         createDateTime: "2018-11-08 19:42:56.0",
//         genre: "Comedy",
//         id: 12,
//         releaseYear: 1987,
//         title: "Spaceballs"
//     },
//     {
//         createDateTime: "2018-11-08 20:14:06.0",
//         genre: "SciFi",
//         id: 13,
//         releaseYear: 1971,
//         title: "Java Rocks!"
//     },
//     {
//         createDateTime: "2018-11-08 20:14:06.0",
//         genre: "SciFi",
//         id: 14,
//         releaseYear: 1981,
//         title: "Angular Test Flick!"
//      }
//  ];
// });

