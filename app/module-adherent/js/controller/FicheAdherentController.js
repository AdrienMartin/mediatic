
angular.module('ModuleAdherent').controller('FicheAdherentController', ['$http', '$rootScope', 'FicheAdherentService', '$scope', 'MemoryFilter', '$location', '$routeParams',
                                                                            function($http, $rootScope, FicheAdherentService, $scope, MemoryFilter, $location, $routeParams){
	var myCtrl = this;
	
	// Je défini l'attribut PAGE pas si il n'ai pas déjà défini
	$rootScope.page = $rootScope.page || {};
	// Je défini l'attribut TITRE de PAGE
	$rootScope.page.titre = "Fiche Adhérent";
	
	myCtrl.adherent = undefined;
	
	var id = $routeParams.idAdherent;
	
	FicheAdherentService.getAdherent(id).then(function(response) {
		myCtrl.adherent = response;
	}, function(){
		// En cas d'erreur
		myCtrl.adherent = -1;
	});
	
	myCtrl.hasErrorAdherent = function(){
		return myCtrl.adherent===-1;
	}

}]);