Feature: Adding Products

  Background: 
    Given I have launched the application
    And User gives username "standard_user" and password "secret_sauce"
    And User clicks login button

  @sanity
  Scenario: Successful login
    When Click on Product "Sauce Labs Bike Light" item add cart
    Then itmem will be added
