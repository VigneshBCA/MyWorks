
@timesheets
Feature: this feature is to get pending timesheets
Scenario Outline: This test to verify the pending timesheets
Given the user is on the homepage
And the user clicks on the time options from the menu 
And the user enters the name as "John Smith"
And clicks on the view button
Then the user should see the message as "<message>"
Examples:
|message|
|No Timesheets Found|