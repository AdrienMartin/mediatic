angular.module('ModuleMedia').controller('MediaController', ['$http', '$rootScope', 'MediaService', 'ListeMediaService', function($http, $rootScope, MediaService, ListeMediaService)
{
	var myCtrl = this;
	
	// Je défini l'attribut PAGE pas si il n'ai pas déjà défini
	$rootScope.page = $rootScope.page || {};
	// Je défini l'attribut TITRE de PAGE
	$rootScope.page.titre = "Medias";
	
	myCtrl.filters = MediaService.get('rechercheFilters');

	myCtrl.medias = undefined;
	
	ListeMediaService.getListe().then(function(response)
	{
		myCtrl.medias = response;
	}, function(){
		// En cas d'erreur
		myCtrl.medias = -1;
	});
	
	myCtrl.hasErrorMedias = function()
	{
		return !(myCtrl.medias===undefined || (_.isArray(myCtrl.medias) && myCtrl.medias.length>0));
	}
	
	myCtrl.changeParams = function()
	{
		console.log(myCtrl.filters);
	}
}]);