var myApp =angular.module('ModuleApp');
myApp.service('ConnexionService',['$http', function($http) {
	
	var url = "http://10.34.10.140:8080/resource/connexion.login";
	var res=undefined;
	this.connexion=function(login,mdp){
			
			$http.post(url,{login:login,mdp:mdp}).then(function(response) {
				
				
				res=response.data;
				
			}, function myError(response) {
				
		        //res=response.statusText;
				
		    });
			console.log("response",res);
		 return res;
	}
	
	
}]);