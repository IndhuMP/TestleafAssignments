Feature: Create a new lead in Leaftaps

Background: Positive Login
Given Type the username as 'Demosalesmanager'
And Type the password as 'crmsfa'
When click the Login button
Then Verify the home page is displayed

Scenario Outline: Edit Lead with different data
Given Click CRM_SFA Link
And CLick the Leads Tab
And Click Find Leads Link
When Type first name as <firstName>
And Click the Find Leads button
Then Click on the first resulting lead
When Click the Edit button 
And Change the company name as <companyName>
When Click Update Button
Then Verify the company name changes as <companyName>

Examples:
|firstName|companyName|
|indhu|Facebook|
|ponni|Instagram|
