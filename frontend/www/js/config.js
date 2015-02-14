app.config(function($routeProvider, $locationProvider) {
	$routeProvider
	.when('/login', {
		templateUrl : '/pages/login.html'
	})
	.when('/loginSuccess', {
		templateUrl : '/pages/user.html',
		controller : 'LoginCtrl'
	})
	.when('/index', {
		templateUrl : '/pages/index.html'
	})
	.when('/Chairman_inforclub', {
		templateUrl : 'club_chairman/showinforclub.html'

	})
	.when('/Chairman_name', {
		templateUrl : 'club_chairman/showname.html'
	})
	.when('/clublist', {
		templateUrl : 'club-club/clublist.html'
	})
	.when('/clubdetail', {
		templateUrl : 'club-club/clubdetail.html'
	})
	.when('/studentorganization', {
		templateUrl : 'club-project/AddMoney.html'
	})
	.when('/rule', {
		templateUrl : 'club-rule/addrule.html'
	})
	.when('/Chairman_status', {
		templateUrl : 'club-status/status.html'
	})
	
	.otherwise({
		redirectTo: '/index'
	})
})