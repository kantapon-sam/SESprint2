app.controller('RuleController', function($scope, $http){	
	
	$scope.listRule = function() {
		$http.get('http://localhost:8080/rule/list').success(function(data) {
			$scope.datas = data
		})
	}
	$scope.listRule()
	
	$scope.addRule = function(){
		var data = {
				name: $scope.name
		};
		$http.post('http://localhost:8080/rule/add', data).success(function(data){
			$scope.name = ''
			$scope.listRule()
			alert('เพิ่มกฎเกณฑ์เรียบร้อย');
		});
	}

	$scope.deleteIdRule = function(id) {
		$http.get('http://localhost:8080/rule/delete/' + id).success(function(data) {
			alert('ลบแล้ว')
			$scope.name = ''
			$scope.listRule()
		})
	}
	
});

