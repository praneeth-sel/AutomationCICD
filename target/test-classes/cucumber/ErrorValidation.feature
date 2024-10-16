
@tag
Feature: Error validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I Landed on the Ecommerce Page
    And Logged with username <name> and password <Password>
    Then "Incorrect email or password" message is displayed 

  Examples: 
      | name                      | Password   |
      | kattapraneeth94@gmail.com | Saketa@123 |
