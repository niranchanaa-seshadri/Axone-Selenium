Feature: Life of an IT Tester
  As a tester
  I want my manager to appreciate me
  So I want to complete my testing tasks well

  Scenario Outline: Life of an IT Tester
    Given I am a "<typeOfTester>" tester
    When I "<statusOfTasks>" my tasks
    And "<action>" important bugs
    Then My manager "<outcomeFromManager>" me
    But Developer "<outcomeFromDeveloper>" me

    Examples:
      | typeOfTester | statusOfTasks  | action     | outcomeFromManager | outcomeFromDeveloper |
      | good         | complete       | find       | rewards            | hates                |
      | bad          | don't complete | don't find | warns              | likes                |
