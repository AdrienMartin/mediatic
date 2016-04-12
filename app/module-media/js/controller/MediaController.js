angular.module('ModuleMedia').controller('MediaController', ['RechercheMediaService', function(RechercheMediaService)
{
	var myCtrl = this;
	
	myCtrl.filters = RechercheMediaService.catalogue;
}