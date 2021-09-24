Feature: AS A User I WANT to be able to exit my cart and continue shopping SO THAT I can continue adding to my order

  Scenario: The User is on the cart page and wants to return to the store page
    Given I am viewing my cart
    When I click on the Continue Shopping Page
    Then I should be taken to the home page
