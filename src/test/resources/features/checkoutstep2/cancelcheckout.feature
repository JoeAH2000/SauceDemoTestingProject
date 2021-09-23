Feature: The ability to cancel the order at checkout

  Scenario: Finishing a completed order on the Checkout-Step-Two page
    Given I am on the Checkout-Step-Two page
    When I click the CANCEL button
    Then I should be on the Inventory page