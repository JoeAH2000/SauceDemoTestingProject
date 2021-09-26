@cart
Feature: AS A User I WANT to be able to remove individual items from my cart SO THAT I can remove unwanted items from my cart

  Scenario: The User wants to remove an item form their cart
    Given I am viewing my cart
    When I click the remove button for an item
    Then That item should be removed from the cart

