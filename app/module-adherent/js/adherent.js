
// Création du module ModuleCatalogue
angular.module('ModuleAdherent', ['ngRoute']);

angular.module('ModuleAdherent').config(function($routeProvider){
	$routeProvider.when('/adherent', {
		templateUrl : './module-adherent/templates/rechercheAdherent.html',
		controller : 'RechercheAdherentController',
		controllerAs : 'adhCtrl'
	});
});

angular.module('ModuleAdherent').config(function($routeProvider){
	$routeProvider.when('/adherent/:idAdherent', {
		templateUrl : './module-adherent/templates/ficheAdherent.html',
		controller : 'FicheAdherentController',
		controllerAs : 'adhCtrl'
	});
});
