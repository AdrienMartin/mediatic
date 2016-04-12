angular.module('ModuleMedia').service('RechercheMediaService', function()
{
	var status = {};
	this.get = function(key)
	{
		status[key] = status[key] || {};
		return status[key];
	}
});