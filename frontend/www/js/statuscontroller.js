app.controller('AddController', function($scope, $http, Auth) {

	$scope.addData = function() {
		
		var data = {
			comment : $scope.msg
		};

		$http.post('http://localhost:8080/status/add/'+Auth.getid(), data).success(function(data) {
			
			$scope.msg = ''
			ons.slidingMenu.setMainPage('club-status/status2.html', {closeMenu: true})
		});	
	}
	$scope.alert = function() {
		ons.notification.alert({message: 'กรุณาตรวจสอบรายละเอียด'});
	}
});

app.controller('PostController1', function($scope, $http, Auth) {	
	
		$http.get('http://localhost:8080/status/post/'+Auth.getid()).success(function(data) {
			$scope.datas = data;
			
		});
});
