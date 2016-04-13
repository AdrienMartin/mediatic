angular.module('ModuleMedia').service('FicheMediaService', ['$http',function($http)
{
	var self = this;
	var url = "http://10.34.10.140:8080/resource/media.accession";
	
	// Appelle le serveur pour recuperer un media
	self.getPromise = function(id)
	{
		var urlParams = {params:{}};
		urlParams.params.id = id;
		return $http.get(url,urlParams).then(function(response)
		{
			var retourTmp = "";
			
			if(response.data.retour != undefined)
			{
				var regExp1 = new RegExp('[ ]', 'gi');
				retourTmp = response.data.retour.replace(regExp1, 'T') + 'Z';
				console.log(new Date(retourTmp));
			}
			var media =
			{
					id : response.data.id,
					titre : response.data.titre,
					auteur : response.data.auteur,
					type : response.data.type,
					emprunteur : response.data.emprunteur,
					emprunteurs : response.data.emprunteurs,
					retour : retourTmp
			};
			return media;
		});
	}
}]);