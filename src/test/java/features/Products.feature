Feature: Manage products

  Scenario: Get all products
    Given that I make a request to the get products endpoint
    When I send the request to the api
    Then I receive the response code 200 and the products data

  Scenario Outline: Verify that the rate of the first product is correct
    Given that I make a request to the get products endpoint
    When I send the request to the api
    Then verify that the rate of the first product is <firstProductRate>
    Examples:
      | firstProductRate |
      |  3.9             |

    Scenario: Validate post endpoint
      Given that I have a new product
      When I make a request to the post url
      Then I should receive response code 200