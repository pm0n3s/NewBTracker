<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NewBornTracker</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css"></link>
<script src="https://code.angularjs.org/1.8.2/angular.min.js"></script>
<script src="https://code.angularjs.org/1.8.2/angular-route.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/service.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/controller.js"></script>
</head>
<body ng-app="myApp">
	<span ng-cloak ng-controller="userController"
		ng-init="setUserId(${ user.id })"></span>
	<h2>welcome back ${user.userName}!</h2>
	<a href="/NewBTracker">Log out</a>
	<div class="container h-100" ng-controller="mainController as ctrl">
		<div class="container-fluid">
			<div class="row w-100 h-100">
				<div class="col" style="background-color: lightblue">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="lead font-weight-bold">Add a Changing</span>
						</div>
						<div class="formcontainer">
							<form ng-submit="ctrl.submit('change')" name="myChangeForm"
								class="form-horizontal">

								<input type="hidden" ng-model="ctrl.change.id" />

								<div class="row">
									<div class="form-group col">
										<label class="col control-label" for="changetime">Time*
											<!-- <span class="has-error" ng-show="myChangeForm.$dirty">
											<span ng-show="myChangeForm.changetime.$error.required">required</span>
										</span> -->
										</label>
										<div class="row">
											<div class="col-9">
												<input type="text" ng-model="ctrl.change.time"
													name="changetime" class="form-control input-sm"
													placeholder="MM-DD-YYYY HH:MM" ng-pattern="ctrl.regex"
													required />
											</div>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col">
										<label class="col control-label" for="changetype">Change
											Type*</label>
										<div class="col-9">
											<select class="form-select" name="changetype"
												ng-model="ctrl.change.type.changeType" required>
												<option value="">---Please select---</option>
												<option value="PEE">PEE</option>
												<option value="POO">POO</option>
											</select>
											<!-- <div class="has-error" ng-show="myChangeForm.$dirty">
												<span ng-show="myChangeForm.changetype.$error.required">This
													is a required field</span>
											</div> -->
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col">
										<label class="col-md-2 control-label" for="changeNotes">Notes</label>
										<div class="col-9">
											<input type="text" ng-model="ctrl.change.notes"
												name="changeNotes" class="form-control input-sm"
												placeholder="notes" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-actions floatRight">
										<input type="submit"
											value="{{!ctrl.change.id ? 'Add' : 'Update'}}"
											class="btn btn-primary btn-sm"
											ng-disabled="myChangeForm.$invalid">
										<button type="button" ng-click="ctrl.reset('change')"
											class="btn btn-warning btn-sm"
											ng-disabled="myChangeForm.$pristine">Reset Form</button>
									</div>
								</div>
							</form>
						</div>
					</div>

					<div class="row pt-1 px-1" ng-repeat="event in ctrl.changes">
						<div class="card p-2">
							<h5 class="card-title">{{ event.type.type }}</h5>
							<p class="card-text">date: {{ event.time.slice(0,10) }}</p>
							<p class="card-text">time: {{ event.time.slice(11) }}</p>
							<p class="card-text">type: {{ event.type.changeType }}</p>
							<p class="card-text">notes: {{ event.notes}}</p>
							<div>
								<button type="button"
									ng-click="ctrl.edit(event.id, event.type.type)"
									class="btn btn-warning col-4">Edit</button>
								<button type="button" ng-click="ctrl.remove(event)"
									class="btn btn-danger col-4">Remove</button>
							</div>
						</div>
					</div>
				</div>


				<div class="col">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="lead font-weight-bold">Add a Feeding</span>
						</div>
						<div class="formcontainer">
							<form ng-submit="ctrl.submit('feed')" name="myFeedForm"
								class="form-horizontal">

								<input type="hidden" ng-model="ctrl.feed.id" />

								<div class="row">
									<div class="form-group col-md-12">
										<label class="col control-label" for="feedtime">Time*</label>
										<div class="col-9">
											<input type="text" ng-model="ctrl.feed.time" name="feedtime"
												class="form-control input-sm" placeholder="MM-DD-YYYY HH:MM"
												ng-pattern="ctrl.regex" required />
											<!-- <div class="has-error" ng-show="myFeedForm.$dirty">
												<span ng-show="myFeedForm.feedtime.$error.required">This
													is a required field</span>
											</div> -->
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">
										<label class="col control-label" for="amount">Amount*</label>
										<div class="col-9">
											<input type="text" ng-model="ctrl.feed.type.amount"
												name="amount" class="form-control input-sm"
												placeholder="0.0 oz" required />
											<!-- <div class="has-error" ng-show="myForm.$dirty">
												<span ng-show="myFeedForm.amount.$error.required">This
													is a required field</span>
											</div> -->
										</div>
									</div>
								</div>


								<div class="row">
									<div class="form-group col-md-12">
										<label class="col control-label" for="feedNotes">Notes</label>
										<div class="col-9">
											<input type="text" ng-model="ctrl.feed.notes"
												name="feedNotes" class="form-control input-sm"
												placeholder="notes" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-actions floatRight">
										<input type="submit"
											value="{{!ctrl.feed.id ? 'Add' : 'Update'}}"
											class="btn btn-primary btn-sm"
											ng-disabled="myFeedForm.$invalid">
										<button type="button" ng-click="ctrl.reset('feed')"
											class="btn btn-warning btn-sm"
											ng-disabled="myFeedForm.$pristine">Reset Form</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="row pt-1 px-1" ng-repeat="event in ctrl.feeds">
						<div class="card p-2">
							<h5 class="card-title">{{ event.type.type }}</h5>
							<p class="card-text">date: {{ event.time.slice(0,10) }}</p>
							<p class="card-text">time: {{ event.time.slice(11) }}</p>
							<p class="card-text">amount: {{ event.type.amount }} oz</p>
							<p class="card-text">notes: {{ event.notes}}</p>
							<div>
								<button type="button"
									ng-click="ctrl.edit(event.id, event.type.type)"
									class="btn btn-warning col-4">Edit</button>
								<button type="button" ng-click="ctrl.remove(event)"
									class="btn btn-danger col-4">Remove</button>
							</div>
						</div>
					</div>
				</div>


				<div class="col" style="background-color: lightpink">
					<div class="panel panel-default">
						<div class="panel-heading">
							<span class="lead font-weight-bold">Add a Sleeping</span>
						</div>
						<div class="formcontainer">
							<form ng-submit="ctrl.submit('sleep')" name="mySleepForm"
								class="form-horizontal">

								<input type="hidden" ng-model="ctrl.sleep.id" />

								<div class="row">
									<div class="form-group col-md-12">
										<label class="col-md-4 control-label" for="sleeptime">Fell
											Asleep*</label>
										<div class="col-9">
											<input type="text" ng-model="ctrl.sleep.time"
												name="sleeptime" class="form-control input-sm"
												placeholder="MM-DD-YYYY HH:MM" ng-pattern="ctrl.regex"
												required />
											<!-- <div class="has-error" ng-show="mySleepForm.$dirty">
												<span ng-show="mySleepForm.sleeptime.$error.required">This
													is a required field</span>
											</div> -->
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-group col-md-12">
										<label class="col-md-4 control-label" for="wakeup">Woke
											up*</label>
										<div class="col-9">
											<input type="text" ng-model="ctrl.sleep.type.wakeup"
												name="wakeup" class="form-control input-sm"
												placeholder="MM-DD-YYYY HH:MM" ng-pattern="ctrl.regex"
												required />
											<!-- <div class="has-error" ng-show="mySleepForm.$dirty">
												<span ng-show="mySleepForm.wakeup.$error.required">This
													is a required field</span>
											</div> -->
										</div>
									</div>
								</div>


								<div class="row">
									<div class="form-group col-md-12">
										<label class="col-md-4 control-label" for="wakeupNotes">Notes</label>
										<div class="col-9">
											<input type="text" ng-model="ctrl.sleep.notes"
												name="wakeupNotes" class="form-control input-sm"
												placeholder="notes" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="form-actions floatRight">
										<input type="submit"
											value="{{!ctrl.sleep.id ? 'Add' : 'Update'}}"
											class="btn btn-sm btn-primary"
											ng-disabled="mySleepForm.$invalid">
										<button type="button" ng-click="ctrl.reset('sleep')"
											class="btn btn-sm btn-warning" style="background-color:darkpink"
											ng-disabled="mySleepForm.$pristine">Reset Form</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="row pt-1 px-1" ng-repeat="event in ctrl.sleeps">
						<div class="card p-2">
							<h5 class="card-title">{{ event.type.type }}</h5>
							<p class="card-text">date: {{ event.time.slice(0,10) }}</p>
							<p class="card-text">time: {{ event.time.slice(11) }}</p>
							<p class="card-text">wake up: {{ event.type.wakeup.slice(11)
								}}</p>
							<p class="card-text">notes: {{ event.notes}}</p>
							<div>
								<button type="button"
									ng-click="ctrl.edit(event.id, event.type.type)"
									class="btn btn-warning col-4">Edit</button>
								<button type="button" ng-click="ctrl.remove(event)"
									class="btn btn-danger col-4">Remove</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>