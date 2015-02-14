
app.factory('Auth', function() {
	var user
	var pw
	var id
	var clubid
	return {
		setUser : function(val) {
			user = val
		},
		isUser : function() {
			return (user) ? user : false
		},
		setPw : function(val) {
			pw = val
		},
		isPw : function() {
			return (pw) ? pw : ''
		},
		getid: function(){
            return id;
        },
        setid: function(value){
            id = value;
        },
        getclubid: function(){
            return clubid;
        },
        setclubid: function(valuess){
            id = valuess;
        }

	}
})


app.controller('LoginCtrl', function($scope, $route, $location, $http, Auth) {
	
	var url = 'http://localhost:8080'
	$scope.user = Auth.isUser()
	
	var user = [
		{id : 1, username : 'admin', name : 'jame jame', level : 'ADMIN'},
		{id : 2, username : 'user', name : 'test test', level : 'USER'}
	]
	var pw = [
		{pw:'a'},
		{pw:'b'}
	]


	$scope.login = function() {
		for(var i = 0; i < user.length; i++) {
			if(user[i].username == $scope.username) {
				Auth.setUser(user[i])
				$location.path('/loginSuccess')
			}
		}
		
		var us = $scope.username
		var pw = $scope.pw
		console.log(us)
		console.log(pw)

		$http.get(url + '/chairman/login/' + us + '/' + pw)
		.success(function(user) {
			console.log(user)
			if(angular.isObject(user)) {
				Auth.setUser(user)
				Auth.setid(user.id)
				$location.path('/loginSuccess')
				ons.notification.alert({
					title: user.level,
					message: user.name.concat(" ".concat(user.lastName)),
				  	buttonLabel: 'ตกลง',})
			} else {
			$http.get(url + '/council/login/' + us + '/' + pw)
			.success(function(user) {
			console.log(user)
				if(angular.isObject(user)) {
				Auth.setUser(user)
				Auth.setid(user.id)
				$location.path('/loginSuccess')
				ons.notification.alert({
					title: user.level,
					message: user.firstname.concat(" ".concat(user.surname)),
				  	buttonLabel: 'ตกลง',})
				} else {
					ons.notification.alert({
					title: 'แจ้งเตือน',
					message: 'ชื่อผู้ใช้/รหัสผ่าน ไม่ถูกต้อง',
				  	buttonLabel: 'ตกลง',
				})

			}

		
		})

	}

		
		})
		
	}


})


app.run(function($rootScope, $location, $route, Auth) {
	$rootScope.$on('$routeChangeStart', function(event) {
		var user = Auth.isUser()

		if($location.path() == '/logout') {
			Auth.setUser(false)
			MainMenu.closeMenu(true)
			ons.slidingMenu.setMainPage('pages/views.html', {closeMenu: true})
			$location.path('/index')
		}else if(!user) {
			console.log('NOT LOGIN')
			$location.path($location.path())
			// ทำ menu หลักให้เป็น menu admin 
			MainMenu.setMenuPage('menu/menu_guest-user.html')
		} else {
			console.log('LOGIN SUCCESS')
			$location.path($location.path())
			if(user.level == 'ประธานชมรม')
				MainMenu.setMenuPage('menu/menu_chairman.html')
			else
				MainMenu.setMenuPage('menu/menu_council.html')
		}

	})

})
