@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @ErrorValidations
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    Given I logged in with username <name> and password <password>
    Then "Incorrect email password." message is displayed

    Examples: 
      | name  					 | password					|
      | Salaar@gmail.com | Salaar@gmail.com	|
