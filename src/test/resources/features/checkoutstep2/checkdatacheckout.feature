Feature: The ability to check the checkout data

  Scenario: I want to check the names of the items I have ordered

    Given I add the backpack item to the cart
    And I proceed to the Checkout-Step-Two page
    When I check the item name
    Then The name should be as expected

  Scenario: I want to check the prices of the items I have ordered

    Given I add the backpack item to the cart
    And I proceed to the Checkout-Step-Two page
    When I check the item price
    Then The price should be as expected

  Scenario: I want to check the descriptions of the items I have ordered

    Given I add the backpack item to the cart
    And I proceed to the Checkout-Step-Two page
    When I check the item description
    Then The description should be as expected

  Scenario: I want to check the quantities of the items I have ordered

    Given I add the backpack item to the cart
    And I proceed to the Checkout-Step-Two page
    When I check the item quantity
    Then The quantity should be as expected

  Scenario: I want to check the payment information

    Given  I am on the Checkout-Step-Two page
    When I check the payment information
    Then The payment information should be as expected

  Scenario: I want to check the shipping information

    Given  I am on the Checkout-Step-Two page
    When I check the shipping information
    Then The shipping information should be as expected

  Scenario: I want to check the subtotal of the order

    Given I add the backpack item to the cart
    And I proceed to the Checkout-Step-Two page
    When I check the sub total value
    Then The subtotal should be as expected

  Scenario: I want to check the tax of the order

    Given I add the backpack item to the cart
    And I proceed to the Checkout-Step-Two page
    When I check the tax value
    Then The tax should be as expected

  Scenario: I want to check the total of the order

    Given I add the backpack item to the cart
    And I proceed to the Checkout-Step-Two page
    When I check the total value
    Then The total should be as expected