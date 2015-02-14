app.service('sharedProperties',function(){
var clubid=0;
return {
	getClubid: function(){
		return clubid;
	},
	setClubid: function(value){
		clubid=value;
	}
};
});

app.controller('ProjectController', function($scope, $http, sharedProperties){
	$scope.price = 1000000;
	$scope.addMoney = function() {
		var data = {
			projectName:          $scope.projectName, 
			description:          $scope.description,
			money: 				  $scope.money           
		}

		$scope.price -= $scope.money;
		console.log(data)	
		$http.post('http://localhost:8080/money/add/' + sharedProperties.getClubid(), data).success(function(data){
			console.log('success ' + data)
			
		})
		.error(function (data, status, headers, config){
			alert("Add OK");
		})

	}

	$scope.addUseMoney = function() {
		var data = { 
			usemoney:             $scope.usemoney,
			money: 				  $scope.money
		}
		$scope.total = 0;
	    $scope.total = $scope.total + $scope.money;
		$scope.price = $scope.price - $scope.total;


		console.log(data)	
		$http.post('http://localhost:8080/money/add', data).success(function(data){
			console.log('success ' + data)
			
		})
		.error(function (data, status, headers, config){
			alert("Add OK");
		})
	}

	$scope.show = function() {
		$http.get('http://localhost:8080/money').success(function(data) {
			$scope.datas = data;
		})
	}

	$scope.showclub = function() {
		
		$http.get("http://localhost:8080/showclub").success(function(data){
			$scope.datas1 = data;			
		}).error(function (data, status, headers, config){
			console.log("ERR:" + status);
			console.log("ERR:" + headers);
		});
		
	}
	
	$scope.showclub();

	$scope.MoneyClub = function(id) {
		sharedProperties.setClubid(id);
		
		ons.slidingMenu.setMainPage('club-project/AddMoney.html', {closeMenu: true})
		
	}

	$scope.MoneyClub2 = function(id) {
		sharedProperties.setClubid(id);
		
		ons.slidingMenu.setMainPage('club-UseMoney/page2.html', {closeMenu: true})
		
	}

	$scope.UseMoney = function(id) {
		sharedProperties.setClubid(id);
		
		ons.slidingMenu.setMainPage('club-UseMoney/page1.html', {closeMenu: true})
		
	}
});