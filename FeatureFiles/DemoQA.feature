Feature: To Test Selenium Functionality

@DemoQA_Login
Scenario: To test login functionality
Given user navigate to the website DemoQA
And user login to the website
And user click on Form
And user click on Practice Form
And user fill all the form and click on the submit button
And user click on Elements
And user click on WebTables
And user add a record in WebTable and store Email value into "Email"
And user search record for value "Email"
And user edit searched record
And user store data into database for newly created record
And user fetch DB export for the newly created customer
And user delete record for value "Email"


@DemoQA_Elements_Buttons_MouseAction
Scenario: To test mouse related automation functionality
Given user navigate to the website DemoQA
And user click on Elements
And user click on Buttons
And verify Double Click Me button is working
And verify Right Click Me button is working
#And verify Click Me button is working