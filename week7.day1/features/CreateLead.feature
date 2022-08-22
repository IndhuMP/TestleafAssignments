Feature: Create a new lead in Leaftaps

Background: Positive Login
Given Type the username as 'Demosalesmanager'
And Type the password as 'crmsfa'
When click the Login button
Then Verify the home page is displayed

Scenario Outline: Create Lead with different data
Given Click CRMSFA Link
And CLick Leads Tab
And Click Create Leads Link
When Type the company name as <companyName>
And Type the first name as <firstName>
And Type the last name as <lastName>
And Click Create Leads Button
Then Verify the View Leads Button

Examples:
|companyName|firstName|lastName|
|ABC|Indhu|Mohan|
|XYZ|Ponni|Mohan|
