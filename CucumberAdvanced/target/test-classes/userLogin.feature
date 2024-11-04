Feature: Register a user
  As a user
  I need to be able to track my activities on the site
  So I need to be able to login

  Scenario Outline: Login with an existing user name and show error message for incorrect user name
    Given I am on https://the-internet.herokuapp.com/login registration page
    And I enter user name "<username>"
    And I enter password "<password>"
    And I click on Login button
    Then user should be shown "<message>"

    Examples:
      | username | password             | message |
      | princess | Wales@123            | warning |
      | tomsmith | SuperSecretPassword! | success   |
