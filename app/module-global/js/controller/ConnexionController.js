var module=angular.module('ModuleApp');

module.controller('ConnexionController', ['$http','$scope','$location','ConnexionService', function($http,$scope,$location,ConnexionService) {
	
	var conCtrl = this;
	
	conCtrl.connexion=function(){
		 var login=$scope.login;
		 var mdp=$scope.mdp;
		
		 var con=ConnexionService.connexion(login,mdp);
		
		 if(con==undefined){
			 
			 $scope.res="veuillez ressaisir vos identifiants";
		 }
		 else{
			 
			 $location.path('/adherent');
		 }
	}
	
}]);
	

