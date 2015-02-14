app.controller('ReportController', function($scope, $http){	
	
	$scope.listRule = function() {
		$http.get('http://localhost:8080/report/list').success(function(data) {
			$scope.datas = data
		})
	}
	$scope.listRule()
	
	$scope.addRule = function(){
		var data = {
				name: $scope.name
		};
		$http.post('http://localhost:8080/report/add', data).success(function(data){
			//alert('เพิ่มสำเร็จ');
			$scope.name = ''
			$scope.listRule()
		});
	}

	$scope.deleteIdRule = function(id) {
		$http.get('http://localhost:8080/report/delete/' + id).success(function(data) {
		//	alert('ลบแล้ว');
			$scope.name = ''
			$scope.listRule()
		})
	}
	
});
