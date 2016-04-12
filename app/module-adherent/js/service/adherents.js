angular.module('ModuleAdherent').service('RechercheAdherentService', ['$http', '$sce', function($http, $sce)
{
    var self = this;
    var url = "http://10.34.10.140:8080/resource/adherent.recherche";
    var promise = undefined;

    var initPromise = function()
    {
        if(promise == undefined)
        {
            promise = $http.post(url).then(function(response)
            {
                var adherents = [];
                for(var index in response.data)
                {
                    var itemFromServeur = response.data[index];
                    var itemForIHM = {
                            id : itemFromServeur.id,
                            nom : itemFromServeur.nom,
                            prenom : itemFromServeur.prenom,
                            date_naissance : itemFromServeur.date_naissance,
                            cotisation_correcte: itemFromServeur.cotisation_correcte,
                            email : itemFromServeur.email,
                            age : itemFromServeur.age
                    };
                    adherents.push(itemForIHM);
                }
                return adherents;
            });
        }
    }
    
    self.getListe = function()
    {
        initPromise();
        return promise;
    }
    
}]);


