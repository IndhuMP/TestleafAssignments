Feature: Login to the Leaftaps Application

Scenario: Positive Login
Given Type the username as 'DemoSalesManager'
And Type the password as 'crmsfa'
When click the Login button
Then Verify the home page is displayed

Scenario: Negative Login
Given Type the username as 'Demouser'
And Type the password as 'crmsfa1'
When click the Login button
But Verify the error message is displayed