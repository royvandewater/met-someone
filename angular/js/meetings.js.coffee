# Place all the behaviors and hooks related to the matching controller here.
# All this logic will automatically be available in application.js.
# You can use CoffeeScript in this file: http://coffeescript.org/


# console.log $resource

window.MeetingsController = ($scope, $resource) ->
  Meeting = $resource '/meetings/:meetingId', meetingId: '@id'

  $scope.meetings = Meeting.query()

  $scope.deleteMeeting = (meeting) ->
    if confirm 'Are you sure?'
      $scope.meetings = _($scope.meetings).without meeting
      meeting.$delete()

  $scope.createMeeting = ->
    meeting = new Meeting()
    meeting.$save()
    $scope.meetings.push(meeting)

