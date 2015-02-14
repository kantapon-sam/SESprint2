app.controller('MenuCtrl', function($scope, $location, $route) {
	$scope.gotoPage = function(path) {
		$location.path('/' + path)
	}
})