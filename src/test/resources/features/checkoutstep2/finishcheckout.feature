@checkoutStepTwo
Feature: The ability to finalise the order at checkout

  Scenario: Finishing a completed order on the Checkout-Step-Two page
    Given I am on the Checkout-Step-Two page
    When I click the FINISH button
    Then I should be on the Checkout-Complete page