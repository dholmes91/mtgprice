(function () {
    var mtgapp = angular.module('mtgapp', ['ngRoute']);

    mtgapp.config(function ($routeProvider) {
        $routeProvider
            .when("/topmovers", {
                templateUrl: "topmovers.html",
                controller: "searchController"
            })
            .when("/stack", {
                templateUrl: "stack.html",
                controller: "searchController"
            })
            .when("/resume", {
                templateUrl: "resume.html",
                controller: "searchController"
            })
            .when("/main", {
                templateUrl: "main.html",
                controller: "searchController"
            })
            .when("/search", {
                templateUrl: "search.html",
                controller: "searchController"
            })
            .when("/watchlist", {
                templateUrl: "watchlist.html",
                controller: "searchController"
            })
            .otherwise({
                redirectTo: "/main"
            });
    });
})();
