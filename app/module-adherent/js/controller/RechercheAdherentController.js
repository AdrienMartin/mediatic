
angular.module('ModuleAdherent').controller('RechercheAdherentController', ['$http', '$rootScope', 'RechercheAdherentService', '$scope', 'MemoryFilter', '$location', '$routeParams',
                                                                            function($http, $rootScope, RechercheAdherentService, $scope, MemoryFilter, $location, $routeParams){
	var myCtrl = this;
	
	// Je défini l'attribut PAGE pas si il n'ai pas déjà défini
	$rootScope.page = $rootScope.page || {};
	// Je défini l'attribut TITRE de PAGE
	$rootScope.page.titre = "Recherche Adhérent";
	
	myCtrl.listeAdherents = undefined;
	
	
	myCtrl.filter = MemoryFilter.get('filtersRechercheAdherent');
	
	var id = $routeParams.idAdherent;
	
	RechercheAdherentService.getListe().then(function(response) {
		myCtrl.listeAdherents = response;
	}, function(){
		// En cas d'erreur
		myCtrl.listeAdherents = -1;
	});
	
	myCtrl.hasErrorAdherent = function(){
		return myCtrl.listeAdherents===-1;
	}
	
	myCtrl.tri = function(param)
	{
		myCtrl.filter.tri = param;
		myCtrl.rechercher();
	}
	
	myCtrl.rechercher = function()
	{
		var params = {};
		if (myCtrl.filter.id != undefined) {
			params.id = myCtrl.filter.id;
		}
		if (myCtrl.filter.texte != undefined) {
			params.texte = myCtrl.filter.texte;
		}
		if (myCtrl.filter.tri != undefined) {
			params.tri = myCtrl.filter.tri;
		}
		RechercheAdherentService.getListe(params).then(function(response) {
			myCtrl.listeAdherents = response;
		}, function(){
			// En cas d'erreur
			myCtrl.listeAdherents = -1;
		});
	}
	
	
	myCtrl.showAdherent = function(id) {
		$location.path('/adherent/'+id);
	}
	
}]);