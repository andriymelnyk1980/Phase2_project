@regression
Feature: Login to sauce lab

  Background: 
    Given I have launched the application

  Scenario: Successful login
    Given User gives username "standard_user" and password "secret_sauce"
    When User clicks login button
    Then user is successfully loged in

  Scenario: Unsuccessful login
    Given User gives username "standard_user1" and password "secret_sauce"
    When User clicks login button
    Then user should get error message "Epic sadface: Username and password do not match any user in this service"

