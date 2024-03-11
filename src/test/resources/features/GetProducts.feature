Feature: Get all the products from the Api

  Scenario: verfiy the get api from the products
    Given i hit the url or the hit the api endpoint
    When i pass the url of products in the request
    Then i received the responce code as 200

  Scenario Outline: Verify the rate of first product
    Given i hit the url or the hit the api endpoint
    When i pass the url of products in the request
    Then i verify the rate of first product is <value>

    Examples: 
      | value |
      | "3.9" |
