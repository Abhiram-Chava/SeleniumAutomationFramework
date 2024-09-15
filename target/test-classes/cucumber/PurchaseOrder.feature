@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background: 
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test of Submitting the order
    Given I logged in with username <name> and password <password>
    When I add the product <productName> to cart
    And Chectout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on confirmationPage

    Examples: 
      | name  					 | password					| productName |
      | Salaar@gmail.com | Salaar@gmail.com1| ZARA COAT 3 |
