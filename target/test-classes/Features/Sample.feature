@run
Feature:

@TC1
Scenario: User is opening an app  
Given User clicks the app
And User enters login "7847881318" & "Kpj@1234"
Then User clicks login button
When User selects a app user, dashboard is displayed
Then User logsout of the app