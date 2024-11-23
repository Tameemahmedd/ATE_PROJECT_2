Feature: Add to Cart

  Scenario: User adds item to cart and checks out
    Given the user is on the product page
    When the user clicks on the Add to Cart button
    And the user clicks on the Checkout button
    And the user fills in the billing address
    And the user clicks on the Place Order button
    Then the order is placed successfully