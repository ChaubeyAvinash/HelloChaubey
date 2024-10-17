Feature: Test google search functionality
  I want to use this template for my feature file

  Scenario: Validate google search is working
    Given browser is open
    And user is on google search page
    When user enters a text insearch box
    And hits enter
    Then User is navigated to search results
