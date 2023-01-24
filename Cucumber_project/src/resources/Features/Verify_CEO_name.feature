@GetCEOName
Feature: this feature is to get the CEO name of the OrangeHRM Application
Scenario: This test tp verify the ceo name
Given the user is logged in successfully and is on home page
When the clicks on the directory option from the menu bar
And the user selects the job title as Chief Executive Officer from the drop down
And clicks the search button
Then the user should see the ceo name as "John Smith"

