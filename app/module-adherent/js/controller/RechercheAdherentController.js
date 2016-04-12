
angular.module('ModuleAdherent').controller('RechercheAdherentController', ['$http', '$rootScope', 'RechercheAdherentService', function($http, $rootScope, RechercheAdherentService){
	var myCtrl = this;
	
	// Je défini l'attribut PAGE pas si il n'ai pas déjà défini
	$rootScope.page = $rootScope.page || {};
	// Je défini l'attribut TITRE de PAGE
	$rootScope.page.titre = "Recherche Adhérent";
	
	myCtrl.listeAdherents = undefined;
	
	RechercheAdherentService.getListe().then(function(response) {
		myCtrl.listeAdherents = response;
	}, function(){
		// En cas d'erreur
		myCtrl.listeAdherents = -1;
	});
	
	myCtrl.hasErrorAdherent = function(){
		return myCtrl.listeAdherents===-1;
	}
	
}]);