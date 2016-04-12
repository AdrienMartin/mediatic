angular.module('ModuleMedia').controller('MediaController', ['RechercheMediaService', 'ListeMediaService', function(RechercheMediaService, ListeMediaService)
{
	var myCtrl = this;
	
	myCtrl.filters = RechercheMediaService;

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
}]);