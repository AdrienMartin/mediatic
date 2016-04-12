angular.module('ModuleMedia').service('ListeMediaService', ['$http',function($http)
{
	var self = this;
	var url = "http://10.34.10.140:8080/resource/media.recherche";
	var promise = undefined;

	var initPromise = function()
	{
		if(promise == undefined)
		{
			promise = $http.get(url).then(function(response)
			{
				var medias = [];
				for(var index in response.data)
				{
					var itemFromServeur = response.data[index];
					var itemForIHM =
					{
							id : itemFromServeur.id,
							titre : itemFromServeur.titre,
							auteur : itemFromServeur.auteur,
							type : itemFromServeur.type,
							emprunteur : itemFromServeur.emprunteur,
							emprunteurs : itemFromServeur.emprunteurs,
							retour : (itemFromServeur.retour != undefined)?new Date(itemFromServeur.retour):""
					};
					medias.push(itemForIHM);
				}

				console.log(medias);
				return medias;
			});
		}
	}
	
	self.getListe = function()
	{
		initPromise();
		return promise;
	}
}]);