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

app.controller('UseMoneyProjectController', function($scope, $http, sharedProperties){

	$scope.showstudents = function() {

		$http.get("http://localhost:8080/show/money/"+ sharedProperties.getClubid()).success(function(data){
			$scope.price = data.money;	

		}).error(function (data, status, headers, config){
			console.log("ERR:" + status);
			console.log("ERR:" + headers);
		});
															
	}
	$scope.showstudents();
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
	$scope.show();
});