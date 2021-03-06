(function() {
    'use strict';
    angular
        .module('partyPaybackApp')
        .factory('PayBack', PayBack);

    PayBack.$inject = ['$resource', 'DateUtils'];

    function PayBack ($resource, DateUtils) {
        var resourceUrl =  'api/pay-backs/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.timestamp = DateUtils.convertDateTimeFromServer(data.timestamp);
                    }
                    return data;
                }
            },
            'byEvent': {
                method: 'GET',
                    isArray : true,
                    url : "api/pay-backs/event/:eventId",
                    transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
