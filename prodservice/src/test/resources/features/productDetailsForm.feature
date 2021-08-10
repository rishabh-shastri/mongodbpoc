@ProductDetailsFormFeature
Feature: Test Product Details Form Functionality

  @ValidScenario-1
  Scenario: Check to view the product details
    Given I have login as valid user to Eldorado
    When I access the product detail page
    Then I can view product details

  @InValidScenario-1
  Scenario: Check to view the product details
    Given I have login as Invalid user to Eldorado
    When I access the product detail page
    Then I can not view product details
    
  @ValidScenario-2
  Scenario: Check to view the product's variant details
    Given I have login as valid user to Eldorado
    When I access the product detail page
    And I click on a product's variant
    Then I can view respective variant details 
    
  @ValidScenario-3
  Scenario: Check to view the respective product's image or video
    Given I have login as valid user to Eldorado
    When I access the product detail page
    And I click on an image or video
    Then I can view the respective image or video

  @ValidScenario-4
  Scenario: Check to view the product's manual
    Given I have login as valid user to Eldorado
    When I access the product detail page
    And I click on a pdf link
    Then I can view the pdf in the same view
