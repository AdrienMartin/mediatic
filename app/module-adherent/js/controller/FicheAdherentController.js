
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
		myCtrl.calculAge(myCtrl.adherent.date_naissance);
		myCtrl.calculFinAbonnement(myCtrl.adherent.debutCotisation);
	}, function(){
		// En cas d'erreur
		myCtrl.adherent = -1;
	});
	
	myCtrl.hasErrorAdherent = function(){
		return myCtrl.adherent===-1;
	}
	
	myCtrl.calculAge = function(dateNaissance){
		if (dateNaissance != undefined) {
			myCtrl.adherent.age = Math.floor(Math.floor((new Date).getTime()-dateNaissance.getTime()) / (365.24*24*3600*1000));
			if (myCtrl.adherent.age <= 0) {
				myCtrl.adherent.age = 0;
			}
		}
	}
	
	myCtrl.calculFinAbonnement = function(dateDebutAbonnement){
		if (dateDebutAbonnement != undefined){
			myCtrl.adherent.finCotisation = angular.copy(dateDebutAbonnement);
			myCtrl.adherent.finCotisation.setYear(dateDebutAbonnement.getFullYear()+1);
		}
	}
	
	myCtrl.showMedia = function(id) {
		$location.path('/ficheMedia/'+id);
	}


}]);