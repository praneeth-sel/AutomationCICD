@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background:
  Given I Landed on the Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged with username <name> and password <Password>
    When I add Product <ProductName> in cart
    And Checkout <ProductName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name                      | Password   | ProductName |
      | kattapraneeth94@gmail.com | Saketa@1234| ZARA COAT 3 |
