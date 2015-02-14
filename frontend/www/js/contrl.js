
app.service('Shared',function(){
    var id = 0;

    return{
        getid: function(){
            return id;
        },
        setid: function(value){
            id = value;
        }
    };
});
app.controller('NonController', function($scope, $http,Auth,Shared){	
	console.log(Auth.getid())
	$scope.show = function() {
		$http.get("http://localhost:8080/student/show/member/" + Auth.getid()).success(function(data){
			$scope.datas = data;
			console.log(data)
		});
	}
	$scope.show();
	$scope.showdetailstudent = function(id) {
		Shared.setid(id);

		ons.slidingMenu.setMainPage('club_chairman/showdetailstudent.html', {closeMenu: true});

	}
	
	    $scope.deletestudent = function(id){
		$http.get("http://localhost:8080/student/delete/" + id).success(function(data){
		$scope.show();
		});
		
	}
	
	
});

app.controller('AController', function($scope, $http,Shared){	


		
		$http.get("http://localhost:8080/student/show/" + Shared.getid()).success(function(data){
		$scope.datas = data;
	
		});
	
});


app.controller('ShowdetailstudentController', function($scope, $http,Auth){
	var id = Auth.getid();
	//alert(id)
	$http.get("http://localhost:8080/club/show/user/" + id).success(function(data){
		$scope.datas = data;
		console.log(data)
	})	


});


app.controller('ShowclubdetailController', function($scope, $http,Auth){
   
	var id = Auth.getid();

	$http.get("http://localhost:8080/club/show/" + id).success(function(data){
		$scope.datas = data;
	}).error(function (data, status, headers, config){
		console.log("ERR:" + status);
		console.log("ERR:" + headers);
	});	
		//alert(Shared.getId());
	console.log(id)
	$scope.showinforclub = function() {
		
		console.log(id)
		//myNav.pushPage('showinforclub.html');
		ons.slidingMenu.setMainPage('club_chairman/showinforclub.html', {closeMenu: true});
	}
	$scope.editclub = function() {
		
		console.log(id)
		//myNav.pushPage('editclub.html');
		ons.slidingMenu.setMainPage('club_chairman/editclub.html', {closeMenu: true});
	}
	$scope.editdetailclub = function(){

		
		$http.get("http://localhost:8080/club/show/" + id).success(function(data){
			$scope.datas 			= data
			$scope.id				= data.id;
			$scope.nameclub         = data.nameclub;
			$scope.description		= data.description;
			$scope.place			= data.place;
			$scope.advisor			= data.advisor;
			$scope.amount			= data.amount;	
			$scope.name			    = data.name;	
			$scope.lastname		    = data.lastName;	
			$scope.username		    = data.userName;	
			$scope.password		    = data.passWord;	
			$scope.level			= data.level;	
			$scope.register		    = data.register;			
		});		
	}
	//if(Shared.getid()) {
	//	$scope.showinforclub();
	//}
	$scope.editsaveclub = function(){
		var data =
		{
			"id"				:Auth.getid(),
			"nameclub"          :$scope.nameclub,
			"description"       :$scope.description,
			"place"             :$scope.place,
			"advisor"           :$scope.advisor,
			"amount"            :$scope.amount,
			"name"              :$scope.name,
			"lastName"          :$scope.lastname,
			"userName"          :$scope.username,
			"passWord"          :$scope.password,
			"level"             :$scope.level,
			"register"          :$scope.register

		};
		console.log(data)
		$http.post("http://localhost:8080/club/update",data).success(function(data){
			//alert(data);
			//Auth.setid(false);
			//myNav.pushPage('showpublish.html');
			//myNav.popPage()
			ons.slidingMenu.setMainPage('club_chairman/showinforclub.html', {closeMenu: true});
		});

	}

	myNavigator.on('postpop', function() {
		$scope.editdetailclub()
	})


});

app.controller('ShowclubController', function($scope, $http, Shared,Auth){
	$scope.show = function() {
		$http.get("http://localhost:8080/club/show").success(function(data){
			$scope.datas = data;
		});
	}
	$scope.show();
	$scope.createclub = function(id) {
		//alert('aaa');
		Auth.setid(id);
		//myNav.pushPage('club.html');
		ons.slidingMenu.setMainPage('club-publish/createclub.html', {closeMenu: true});
	}
	$scope.deleteclub = function(id){
		$http.get("http://localhost:8080/club/delete/" + id).success(function(data){
		$scope.show();
		});
		
	}
	$scope.addclub = function(){
		var data =
		{
			
			nameclub         :$scope.nameclub,
			description       :$scope.description,
			place           :$scope.place,
			advisor           :$scope.advisor,
			amount           :$scope.amount,
			name              :$scope.name,
			lastName          :$scope.lastname,
			userName          :$scope.username,
			passWord          :$scope.password,
			level             :$scope.level,
			register          :$scope.register

		};
		console.log(data)
		$http.post("http://localhost:8080/club/add",data).success(function(data){
			//alert(data);
			//Shared.setid(false);
			//myNav.pushPage('showpublish.html');
			//myNav.popPage()
			ons.slidingMenu.setMainPage('club-publish/showclub.html', {closeMenu: true});
		});

	}

	//myNavigator.on('postpop', function() {
		//$scope.editdetailclub()
	//})


});