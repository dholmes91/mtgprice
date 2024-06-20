(function () {

    var mtgapp = angular.module('mtgapp', ['ngRoute']);
    mtgapp.config(function ($routeProvider) {

        $routeProvider
            .when("/search", {
                templateUrl: "search.html",
                controller: "searchController"
            })
            .when("/create", {
                templateUrl: "create.html",
                controller: "createController"
            })
            .when("/stack", {
                templateUrl: "stack.html"
            })
            .when("/resume", {
                templateUrl: "resume.html"
            })
            .when("/main", {
                templateUrl: "main.html"
            })
            // .when("/update/:movieId", {
            //     templateUrl: "update.html",
            //     controller: "updateController"
            // })
            .otherwise({
                templateUrl: "main.html"
            });
    });

})();
