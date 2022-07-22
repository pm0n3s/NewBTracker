'use strict';

angular.module('myApp').factory('mainService', mainServiceFactory)

mainServiceFactory.$inject = ['$http', '$log']

function mainServiceFactory($http, $log) {

	const URL = "http://localhost:8080/NewBornTracker/events/";

	const factory = {
		fetchAllEvents: fetchAllEvents,
		createEvent: createEvent,
		updateEvent: updateEvent,
		deleteEvent: deleteEvent
	}

	return factory;

	function fetchAllEvents(userId) {
		$log.log(URL + userId)
		return $http.get(URL + userId).then(
			function(response) {
				$log.log(response.data);
				return response.data;
			},
			function(errResponse) {
				$log.error('Error while fetching events ', errResponse);
			}
		);
	}

	function createEvent(userId, event) {
		$log.log("inside angular service create")
		$log.log(URL + userId)
		return $http.post(URL + userId, event)
			.then(
				function(response) {
					console.log(response);
					return response.data;
				},
				function(errResponse) {
					$log.error('Error while creating event', errResponse);
				}
			);
	}

	function updateEvent(userId, event) {
		$log.log("made it to service update")
		return $http.put(URL + userId + "/" + event.id, event).then(
			function(response) {
				$log.log(response)
				return response.data
			},
			function(errResponse) {
				$log.error('Error while updating event', errResponse);
			}
		);
	}

	function deleteEvent(userId, event) {
		return $http.delete(URL + userId + "/" + event.id).then(
			function(response) {
				return response.data
			},
			function(errResponse) {
				$log.error('Error while deleting event', errResponse);
			}
		);
	}

}
