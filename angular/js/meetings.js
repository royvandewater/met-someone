// Place all the behaviors and hooks related to the matching controller here.
// All this logic will automatically be available in application.js.
// You can use CoffeeScript in this file: http://coffeescript.org/


(function(){
  
angular.module('met-someone', ['ngResource']);

window.MeetingsController = function($scope, $resource) {
  var Meeting;
  Meeting = $resource('/meetings/:meetingId', {meetingId: '@id'});

  $scope.meetings = Meeting.query();

  $scope.deleteMeeting = function(meeting) {
    if (confirm('Are you sure?')) {
      $scope.meetings = _($scope.meetings).without(meeting);
      meeting.$delete();
    }
  }

  $scope.createMeeting = function() {
    var meeting;
    meeting = new Meeting();
    meeting.$save();
    $scope.meetings.push(meeting);
  }
}

})();
