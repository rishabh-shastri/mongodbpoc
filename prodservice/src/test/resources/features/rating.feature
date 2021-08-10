@RatingFeature
Feature: Test rating Functionality

  @ValidScenario-1
  Scenario: check to perform give rating operation
    Given I login as valid user to Eldorado
    When I access product detail page for rating
    And I hover on your rating
    Then I can give rating to a product
        
  @ValidScenario-2
  Scenario: check to perform edit rating operation    
    Given I login as valid user to Eldorado
    When I access product detail page for rating
    And I hover on your rating
    Then I can edit rating of a product
    
  @ValidScenario-3
  Scenario: check to view average rating    
    Given I login as valid user to Eldorado
    When I access product detail page for rating
    Then I can view average rating to a product    