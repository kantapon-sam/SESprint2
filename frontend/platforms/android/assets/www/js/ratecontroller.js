

    app.controller('RateController', function($scope, $route, $location,$http,sharedProperties,Auth) {
      
  $scope.showNameClub = function() {
    var id = sharedProperties.getClubid();
      $http.get("http://localhost:8080/showclubdetail/"+ id).success(function(data){
      $scope.NameClub = data;
    });
  }
  $scope.showNameClub();


  $scope.One = 0
  $scope.Two = 0
  $scope.Three = 0
  $scope.Four = 0
  $scope.Five = 0

  var clubid = sharedProperties.getClubid()
  $scope.addRate = function(){
    var data = {
      point1  :     $scope.One,
      point2  :     $scope.Two,
      point3  :     $scope.Three,
      point4  :     $scope.Four,
      point5  :     $scope.Five,
      score :       Number($scope.One) +Number($scope.Two)+Number($scope.Three) +Number($scope.Four)+ Number($scope.Five) 

    };
    console.log(clubid);
    $http.post('http://localhost:8080/rate/add/'+ clubid, data).success(function(){
       ons.notification.alert({
        title: 'แจ้งเตือน',
        message: 'บันทึกข้อมูลสำเร็จ',
        buttonLabel: 'ตกลง',
      });
    ons.slidingMenu.setMainPage('club-rate/selectrate.html', {closeMenu: true})
    });

  }
   
   $scope.rateshow = function() {

    console.log(Auth.getid());
    $http.get('http://localhost:8080/rate/show/'+Auth.getid()).success(function(data){
      $scope.rates = data;     
      $scope.total = data.length;
      console.log($scope.rates);
    })
    
  }
   $scope.rateshow();
  });
