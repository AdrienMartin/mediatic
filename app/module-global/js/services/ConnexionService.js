var myApp =angular.module('ModuleApp');
myApp.service('ConnexionService',['$http', function($http) {
	
	var url = "http://10.34.10.140:8080/resource/connexion.login";
	var res=false;
	var con=false;
	this.connexion=function(login,mdp){
			
		return $http.post(url,{login:login,mdp:mdp}).then(function(response) {			
			res=response.data;
			con=true;
			return true;
		}, function myError(response) {
			
	        //res=response.statusText;
	        console.log(response.statusText)
			return false;
	    });
		
	}
	this.isConnected=function(){
		
		return con;
	}
	
}]);