angular.module('ModuleAdherent').service('RechercheAdherentService', ['$http', '$sce', function($http, $sce)
{
    var self = this;
    var url = "http://10.34.10.140:8080/resource/adherent.recherche";
    
    self.getListe = function(params)
    {
    	return $http.get(url,{params:params}).then(function(response)
        {
            var adherents = [];
            for(var index in response.data)
            {
                var itemFromServeur = response.data[index];
                var itemForIHM = {
                        id : itemFromServeur.id,
                        nom : itemFromServeur.nom,
                        prenom : itemFromServeur.prenom,
                        date_naissance : new Date(itemFromServeur.date_naissance),
                        cotisation_correcte : itemFromServeur.cotisation_correcte,
                        emprunt : itemFromServeur.nombre_media
                };
       
                adherents.push(itemForIHM);
            }
            return adherents;
        });
        
    }
  
    
}]);


