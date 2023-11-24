Feature: Is it Friday yet?
  As a user I want to know when it's Friday so that I can plan for the weekend.

  Scenario Outline: Today is or is not Friday
    Given today is "<day>"
    When I ask whether it's Friday yet
    Then I should be told "<answer>"

    Examples:
      | day        |   answer   |
      | Monday     |    No      |
      | Tuesday    |    No      |
      | Wednesday  |    No      |
      | Thursday   |    No      |
      | Friday     |    Yes     |
      | Sunday     |    No      |

