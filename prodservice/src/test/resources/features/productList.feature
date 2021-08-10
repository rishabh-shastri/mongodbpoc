@Feature
Feature: Test Product List functionality

  @ValidScenario-1
  Scenario: User View Product List Page
    Given User Is Valid User
    When User Just Logged In
    And GET request is received
    Then Product List response is send for the request

  @ValidScenario-2
  Scenario: User Select A Product on Product List Page
    Given User is on the product list page
    When User click a product from product list page
    Then GET Request for product detail is received
    And Product details response is send

  @ValidScenario-3
  Scenario: User Navigation Using Pagination
    Given User is on the product list page
    When User click on paginate button
    Then GET request for the next page is received
    And Product List response is send