angular.module('ModuleAdherent').service('FicheAdherentService', ['$http', '$sce', function($http, $sce)
{
    var self = this;
    var url = "http://10.34.10.140:8080/resource/adherent.accession";
    
    self.getAdherent = function(id)
    {
    	var params = {params:{}};
    	params.params.id = id;
    	return $http.get(url, params).then(function(response)
        {
            var adherent = [];
            var itemFromServeur = response.data;
            adherent = {
                id : itemFromServeur.id,
                nom : itemFromServeur.nom,
                prenom : itemFromServeur.prenom,
                date_naissance : new Date(itemFromServeur.date_naissance),
                cotisation_correcte : itemFromServeur.cotisation_correcte,
                emprunt : itemFromServeur.nombre_media,
                medias : itemFromServeur.emprunt,
                adresse : itemFromServeur.adresse,
                debutCotisation : new Date(itemFromServeur.cotisation.debut),
                montantCotisation : itemFromServeur.cotisation.montant,
                email : itemFromServeur.email
            };
            return adherent;
        });
        
    }
  
    
}]);


