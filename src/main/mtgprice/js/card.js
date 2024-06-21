(function () {
    var mtgapp = angular.module('mtgapp', ['ngRoute']);

    mtgapp.config(function ($routeProvider) {
        $routeProvider
            .when("/topmovers", {
                templateUrl: "topMovers.html",
                controller: "searchController"
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
            // .otherwise({
            //     redirectTo: "/main"
            // });
    });


})();
