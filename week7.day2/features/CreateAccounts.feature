Feature: Create a new Account in Salesforce

Background: Positive Login
Given Type the username as 'hari.radhakrishnan@qeagle.com'
And Type the password as 'India$321'
When Click the Login button
And Click the toggle button


Scenario Outline: Create Account with different data
Given Click the Accounts option
Then Click the Accounts dropdown
And CLick New Account link
Then Type account name as <firstName>
And Select Employee
And Select ownership as public
Then Click Save button
Then Verify Account created for <firstName>

Examples:
|firstName|
|Indhu|
|Ponni|