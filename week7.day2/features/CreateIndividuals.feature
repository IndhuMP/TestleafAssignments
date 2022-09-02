Feature: Create a new lead in Leaftaps

Background: Positive Login
Given Type the username as 'hari.radhakrishnan@qeagle.com'
And Type the password as 'India$321'
When Click the Login button
And Click the toggle button


Scenario Outline: Create Individual with different data
Given Click the Individuals option
Then Click the Individuals dropdown
And CLick New Individual link
Then Type the first name as <firstName>
Then Type last name as <lastName>
Then Click the Save

Examples:
|firstName|lastName|
|Indhu|Mohan|
|Ponni|Mohanraj|