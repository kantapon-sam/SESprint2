app.controller('ApplyRuleController', function($scope, $http){
		$scope.saverule = function(){
			var data = {
					"name" : $scope.name	
			};
			$http.post('http://localhost:8080/applyrule/add', data).success(function(data){
				alert(data);
				ons.slidingMenu.setMainPage('club-applyrule/addapplyrule.html', {closeMenu: true})
			})
		}
		
		$scope.showapplyrule = function() {

			$http.get("http://localhost:8080/applyrule/list").success(function(data){
				$scope.datas = data;	
			}).error(function (data, status, headers, config){
				console.log("ERR:" + status);
				console.log("ERR:" + headers);
			});
																
		}
		$scope.showapplyrule();
		
		$scope.deleteapplyrule = function(id){
			$http.get("http://localhost:8080/applyrule/delete/"+ id).success(function(data){
				alert(data);
				ons.slidingMenu.setMainPage('club-applyrule/addapplyrule.html', {closeMenu: true})
			}).error(function (data, status, headers, config){
				console.log("ERR:" + status);
				console.log("ERR:" + headers);
			});
		}
});