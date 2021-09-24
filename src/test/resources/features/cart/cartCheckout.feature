Feature: AS A User, I WANT to be able to checkout with the items in my cart SO THAT I can complete my order

  Scenario: The User is beginning the checkout process from their Cart
    Given I am viewing my cart
    When I click the checkout button
    Then I should be taken to the checkout step one page
