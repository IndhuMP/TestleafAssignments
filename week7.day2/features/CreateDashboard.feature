Feature: Create a new Dashboard in Salesforce

Background: Positive Login
Given Type the username as 'hari.radhakrishnan@qeagle.com'
And Type the password as 'India$321'
When Click the Login button
And Click the toggle button


Scenario Outline: Create Dashboard with different data
Given Click the Dashboards option
And CLick New Dashboard button
Then Type Dashboard name as <dashboardName>
And Click Create button
Then Click Save
Then Verify Dashboard is created

Examples:
|dashboardName|
|Salesforce Automation by Indhu|
|Salesforce Automation by Ponni|