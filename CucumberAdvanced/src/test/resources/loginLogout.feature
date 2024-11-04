Feature: Verify login and logout
  As a user
  I need to be able to keep my session secure
  So I need to make sure the sign in and sign out works

  Scenario: Sign in to the website with a valid registered username and sign out
    Given I am on the "http://seleniumpractice.axone-tech.uk" page
    When I click the sign-in link
    And enter a valid registered email "sridhar.bandi@axone.uk" and password "password"
    Then I should be logged in successfully
    And if I click on logout
    Then I should be logged out of the session