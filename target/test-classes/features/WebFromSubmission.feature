Feature: Submission of web page form

@WebFormPage1
Scenario: General-Verify the user can able to submit the form successfully

Given I open the application in the "chrome" browser
Then I enter "SampleText" in the "TextInput" input field
Then I enter "Password" in the "password" input field
Then I select the "One" from the "Select" dropdown field
Then I enter "San Franciso" in the "DataList" input field
Then I click on "Submit" button
And I verify the "Received!" success message is displayed

@WebFormPage2
Scenario: DataTable-Verify the user can able to submit the form successfully using datatable

Given I open the application in the "chrome" browser
Then I enter the below values in the webpage
|TextInput |password | SelectDropdown | DataList    |DatePicker  |
|SampleText|Password | One            | San Fanciso | 12/04/2025 |
And I get the default value from the "Readonly input" field
Then I click on "Submit" button
And I verify the "Received!" success message is displayed
