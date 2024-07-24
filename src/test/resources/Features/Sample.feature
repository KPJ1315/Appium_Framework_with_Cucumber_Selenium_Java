@run
Feature: 

  Background: 
    Given User clicks the app
    And User enters login "7847881318" & "Kpj#1234"
    Then User clicks login button
    When User selects a app user, dashboard is displayed

  @TC1
  Scenario: User is logs in and logs out of patient app
  Then User logsout of the app
  @TC2
  Scenario: Search for speciality in top speciality section of consultation in patient app
    And User clicks consultation
    Then User clicks see more of top speciality
    Then User searches for a speciality by entering one in search bar
    Then User is shown search result
    Then User logsout of the app
    
    @TC3
  Scenario: Search for speciality in filter section of consultation in patient app
    And User clicks consultation
    Then User clicks see more of top speciality
    Then User searches for a particular speciality in search bar
    Then User logsout of the app
