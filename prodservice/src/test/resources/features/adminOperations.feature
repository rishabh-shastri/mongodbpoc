@AdminOperationsFeature
Feature: Test admin operations Functionality

  @ValidScenario-1
  Scenario: check to perform edit operation
    Given I have login to Eldorado as an Admin
    When I access product detail page
    And I click on edit button
    Then I can edit product
    And I get confirmation popup for saving edit

  @ValidScenario-2
  Scenario: check to perform delete operation
    Given I have login to Eldorado as an Admin
    When I access product detail page
    And I click on delete button
    Then I can delete product
    And I get confirmation popup for saving delete