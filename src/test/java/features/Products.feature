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
      |  "3.9"             |

    Scenario: Validate post product endpoint
      Given that I have a new product
      When I make a request to the post url
      Then I should receive response code 200

    Scenario Outline: verify put request on the product endpoint
      Given that I have updated a product
      When I make a request to the put url with <productId>
      Then I should receive response code 200
      Examples:
        | productId |
        | 5         |

  Scenario Outline: verify the delete product endpoint
    Given that I want to delete a product
    When I make a request to the delete url with <productId>
    Then I should receive response code 200
    Examples:
      | productId |
      | 5         |
