Feature: Create a new Opportunity in Salesforce

Background: Positive Login
Given Type the username as 'hari.radhakrishnan@qeagle.com'
And Type the password as 'India$321'
When Click the Login button
And Click the toggle button


Scenario Outline: Create Opportunity with different data
Given Click the Sales option
Then Click the Opportunities dropdown
And CLick New Opportunity link
And Select Close date
Then Click Save button
Then Verify mandatory alert 

Examples:
|opportunityName|
|Salesforce Automation by Indhu|
|Salesforce Automation by Ponni|