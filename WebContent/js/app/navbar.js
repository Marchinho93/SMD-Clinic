angular.module("navbar", [])
	.controller("navbar", function ($scope){
		$scope.navClick.click = function() {
			$scope.carousel = true;
			
		}
	})