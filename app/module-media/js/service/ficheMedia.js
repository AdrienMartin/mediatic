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
			var media =
			{
					id : response.data.id,
					titre : response.data.titre,
					auteur : response.data.auteur,
					type : response.data.type,
					emprunteur : response.data.emprunteur,
					emprunteurs : response.data.emprunteurs,
					retour : (response.data.retour != undefined)?new Date(response.data.retour):""
			};
			return media;
		});
	}
}]);