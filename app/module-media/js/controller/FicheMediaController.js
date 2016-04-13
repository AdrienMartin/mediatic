angular.module('ModuleMedia').controller('FicheMediaController', ['$rootScope', '$routeParams', 'FicheMediaService', function($rootScope, $routeParams, FicheMediaService)
{
	var myCtrl = this;
	
	// Je défini l'attribut PAGE pas si il n'ai pas déjà défini
	$rootScope.page = $rootScope.page || {};
	// Je défini l'attribut TITRE de PAGE
	$rootScope.page.titre = "Media";

	myCtrl.media = undefined;
	myCtrl.mediaTmp = {};
	
	// Récuparation du l'identifiant qui est le paramètre 'idMedia' de la route
	var id = $routeParams.idMedia;
	
	// Récuparation du media en fonction de son id
	FicheMediaService.getPromise(id).then(function(response)
	{
		myCtrl.media = response;
		myCtrl.mediaTmp.titre = myCtrl.media.titre;
		myCtrl.mediaTmp.auteur = myCtrl.media.auteur;
		myCtrl.mediaTmp.type = myCtrl.media.type;
	}, function(){
		// En cas d'erreur
		myCtrl.media = -1;
	});
	
	// Erreur si pas de media
	myCtrl.hasErrorMedias = function()
	{
		return !(myCtrl.media===undefined);
	}
	
	myCtrl.saveMedia = function()
	{
		myCtrl.media.titre = myCtrl.mediaTmp.titre;
		myCtrl.media.auteur = myCtrl.mediaTmp.auteur;
		myCtrl.media.type = myCtrl.mediaTmp.type;
		console.log('todo');
	}
}]);