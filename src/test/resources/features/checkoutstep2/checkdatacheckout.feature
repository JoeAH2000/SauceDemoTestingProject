Feature: The ability to check the checkout data

  Scenario: I want to check the data for the items I have ordered

  Scenario: I want to check the payment and shipping information

  Scenario: I want to check the subtotal of the order

    Given I am on the Checkout-Step-Two page
    When I check the sub total value
    Then The subtotal should be as expected

  Scenario: I want to check the tax of the order

    Given I am on the Checkout-Step-Two page
    When I check the tax value
    Then The tax should be as expected

  Scenario: I want to check the total of the order

    Given I am on the Checkout-Step-Two page
    When I check the total value
    Then The total should be as expected