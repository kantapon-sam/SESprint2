app.controller('CouncilController', function($scope, $http){
		var idcouncil = 1;
		$scope.showdate = function(){
			$http.get("http://localhost:8080/show/date/" + idcouncil).success(function(data){
				$scope.id = data[0].id;
				$scope.Username = data[0].username;
				$scope.Password = data[0].password;
				$scope.Firstname = data[0].firstname;
				$scope.Surname = data[0].surname;
				$scope.datetoapply1 = data[0].dateToApply1;
				$scope.datetoapply2 = data[0].dateToApply2;
				$scope.datetocreate1 = data[0].dateToCreate1;
				$scope.datetocreate2 = data[0].dateToCreate2;
				$scope.datadates= data;			
			}).error(function (data, status, headers, config){
				console.log("ERR:" + status);
				console.log("ERR:" + headers);
			});
			
		}
		
		$scope.showdate();
		
		$scope.editsavedate = function(){
			var data = {
			"id"		  : $scope.id,
			"username"	  : $scope.Username,
			"password"	  : $scope.Password,
			"firstname"	  : $scope.Firstname,
			"surname"	  : $scope.Surname,
			"dateToApply1": $scope.datetoapply1,
			"dateToApply2": $scope.datetoapply2,
			"dateToCreate1": $scope.datetocreate1,
			"dateToCreate2": $scope.datetocreate2,
			};
			$http.post('http://localhost:8080/save/date', data).success(function(data){
				alert(data);
				ons.slidingMenu.setMainPage('club-council/announceforcouncil.html', {closeMenu: true})
			}).error(function (data, status, headers, config){
				alert('error');
			});
			
		}
		
		$scope.showapplyrule = function() {

			$http.get("http://localhost:8080/applyrule/list").success(function(data){
				$scope.datarules = data;	
			}).error(function (data, status, headers, config){
				console.log("ERR:" + status);
				console.log("ERR:" + headers);
			});
																
		}
		$scope.showapplyrule();
});