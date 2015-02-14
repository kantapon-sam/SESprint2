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
app.controller('ShowpublicController', function($scope, $http, Shared){
	$scope.show = function() {
		$http.get("http://localhost:8080/orguser/show").success(function(data){
			$scope.datas = data;
		}).error(function (data, status, headers, config){
			console.log("ERR:" + status);
			console.log("ERR:" + headers);
		});
	}
	$scope.show();

	$scope.editpublic = function(id) {
		Shared.setid(id);
		//myNavigator.pushPage('club-publish/editpublic.html');
		ons.slidingMenu.setMainPage('club-publish/editpublic.html', {closeMenu: true});
	}

	$scope.editdetailpublic = function(){

		var id = Shared.getid();
		$http.get("http://localhost:8080/orguser/show/" + id).success(function(data){
			$scope.id				= data.id;
			$scope.publishsubscribe = data.publishsubscribe;
		});		
	}
	if(Shared.getid()) {
		$scope.editdetailpublic();
	}
	

	$scope.editsavepublic = function(){
		var data =
		{
			"id"				:Shared.getid(),
			"publishsubscribe"  :$scope.publishsubscribe
		};
		console.log(data)

		$http.post("http://localhost:8080/orguser/update",data).success(function(data){
			//alert(data);
			Shared.setid(false);
			//myNav.pushPage('showpublish.html');
		//	myNavigator.popPage()
			ons.slidingMenu.setMainPage('club-publish/showpublish.html', {closeMenu: true});
		});
    }

    myNavigator.on('postpop', function() {
    		$scope.show();
    })
});