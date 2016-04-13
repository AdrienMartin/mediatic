angular.module('ModuleMedia').controller('RechercheMediaController', ['$rootScope', 'MediaService', 'ListeMediaService', '$location', function($rootScope, MediaService, ListeMediaService, $location)
{
	var myCtrl = this;
	
	// Je défini l'attribut PAGE pas si il n'ai pas déjà défini
	$rootScope.page = $rootScope.page || {};
	// Je défini l'attribut TITRE de PAGE
	$rootScope.page.titre = "Medias";
	
	myCtrl.filters = MediaService.get('rechercheFilters');

	myCtrl.medias = undefined;
	
	myCtrl.getListeTriee = function(param)
	{
		myCtrl.filters.tri = param;
		ListeMediaService.getPromise(myCtrl.filters).then(function(response)
		{
			myCtrl.medias = response;
		}, function(){
			// En cas d'erreur
			myCtrl.medias = -1;
		});
	}
	
	myCtrl.getListeTriee();
	
	myCtrl.hasErrorMedias = function()
	{
		return !(myCtrl.medias===undefined || (_.isArray(myCtrl.medias) && myCtrl.medias.length>0));
	}
	
	myCtrl.showMedia = function(id)
	{
		$location.path('/ficheMedia/'+id);
	}
}]);