Feature: Add two numbers
  As a user
  I want to be able to find the sum of any two positive numbers
  So I should be able to enter two numbers of my choice

  Scenario: Successful addition of two positive numbers
    Given User has two positive numbers 5 and 3
    When the user adds them
    Then the user should be able to see a result of 8
