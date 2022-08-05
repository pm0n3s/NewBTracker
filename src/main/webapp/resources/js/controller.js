'use strict';

let uId = ''

angular.module('myApp').controller('userController', ['$scope', function($scope) {

	$scope.setUserId = function setUserId(id) {
		uId = id
	}

}])

angular.module('myApp').controller("mainController", ['$scope', '$log', 'mainService', function($scope, $log, mainService) {

	const self = this;

	self.userId = uId

	self.feed = { id: null, eventTime: '', notes: '', type: { selectType: 'feed', amount: '', id: null } }
	self.change = { id: null, eventTime: '', notes: '', type: { selectType: 'change', changeType: '', id: null } }
	self.sleep = { id: null, eventTime: '', notes: '', type: { selectType: 'sleep', wakeup: '', id: null } }

	self.feeds = []
	self.changes = []
	self.sleeps = []

	self.submit = submit;
	self.edit = edit;
	self.remove = remove;
	self.reset = reset;

	self.regex = /^[0-9]{2}-[0-9]{2}-[0-9]{4}\s[0-9]{2}:[0-9]{2}$/

	fetchAllEvents();

	function fetchAllEvents() {
		self.feeds = []
		self.changes = []
		self.sleeps = []
		$log.log("fetching items")
		mainService.fetchAllEvents(self.userId)
			.then(
				function(d) {
					for (let event of d.eventList) {
						delete event.time
						if (event.type.selectType === 'feed') {
							self.feeds.push(event)
						} else if (event.type.selectType === 'change') {
							self.changes.push(event)
						} else if (event.type.selectType === 'sleep') {
							self.sleeps.push(event)
						}
					}
				},
				function(errResponse) {
					$log.error('Error while fetching events ', errResponse);
				}
			);
	}

	function createEvent(event) {
		mainService.createEvent(self.userId, event)
			.then(
				fetchAllEvents,
				function(errResponse) {
					$log.error('Error while creating main ', errResponse);
				}
			);
	}

	function updateEvent(event) {
		mainService.updateEvent(self.userId, event)
			.then(
				fetchAllEvents,
				function(errResponse) {
					$log.error('Error while updating event ', errResponse);
				}
			);
	}

	function deleteEvent(event) {
		mainService.deleteEvent(self.userId, event)
			.then(
				fetchAllEvents,
				function(errResponse) {
					$log.error('Error while deleting event ', errResponse);
				}
			);
		reset(event.type.selectType)
	}

	function submit(type) {
		if (type === 'feed') {
			if (self.feed.id === null) {
				$log.log('Saving New Feed', self.feed);
				createEvent(self.feed);
			} else {
				updateEvent(self.feed);
				$log.log('Feed updated with id ', self.feed.id);
			}
		} else if (type === 'change') {
			if (self.change.id === null) {
				$log.log('Saving New Change', self.change);
				createEvent(self.change);
			} else {
				updateEvent(self.change, self.change.id);
				$log.log('Change updated with id ', self.change.id);
			}
		} else if (type === 'sleep') {
			if (self.sleep.id === null) {
				$log.log('Saving New Sleep', self.sleep);
				createEvent(self.sleep);
			} else {
				updateEvent(self.sleep, self.sleep.id);
				$log.log('Sleep updated with id ', self.sleep.id);
			}
		}
		reset(type)
	}

	function edit(id, type) {
		$log.log('id to be edited', id);
		if (type === 'feed') {
			for (let e of self.feeds) {
				if (e.id === id) self.feed = angular.copy(e)
			}
		} else if (type === 'change') {
			for (let e of self.changes) {
				if (e.id === id) self.change = angular.copy(e)
			}
		} else if (type === 'sleep') {
			for (let e of self.sleeps) {
				if (e.id === id) self.sleep = angular.copy(e)
			}
		}

	}

	function remove(event) {
		$log.log('id to be deleted', event.id);
		deleteEvent(event);
	}

	function reset(type) {
		if (type === 'feed') {
			self.feed = { id: null, eventTime: '', notes: '', type: { selectType: 'feed', amount: '', id: null } }
			$scope.myFeedForm.$setPristine()
		} else if (type === 'change') {
			self.change = { id: null, eventTime: '', notes: '', type: { selectType: 'change', changeType: '', id: null } }
			$scope.myChangeForm.$setPristine();
		} else if (type === 'sleep') {
			self.sleep = { id: null, eventTime: '', notes: '', type: { selectType: 'sleep', wakeup: '', id: null } }
			$scope.mySleepForm.$setPristine();
		}
	}

}])
