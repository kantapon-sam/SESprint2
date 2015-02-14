

app.controller('PostController', function($scope, $http) {

	$scope.addData = function() {
		
		var data = {
			club	 : $scope.club,
			message  : $scope.message,
			date    : $scope.dates	 
		};
		$http.post('http://localhost:8080/event/add', data).success(function(data){
			$scope.club = ''
			$scope.message = ''
			ons.notification.alert({message: 'Success'});
		});
	}
});

app.controller('ShowController', function($scope, $http) {

		$http.get('http://localhost:8080/event/post').success(function(data){
			$scope.datas = data;
		});
		$scope.AiData = function(id) {
			
		$http.get('http://localhost:8080/event/post/'+id).success(function(id){
			console.log(id);
			alert(id.message);
			alert(id.date);

		});
		}
  	
});


