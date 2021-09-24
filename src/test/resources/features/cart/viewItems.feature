Feature: AS A User, I WANT to be able to view all the items in my cart SO THAT I can confirm what I am ordering

  Background:
    Given I have a valid username
    And  I have a valid password
    When I enter my username
    And I enter my password
    And I go to the inventory page from the login page

  Scenario: The User is viewing their cart
    Given I have items in my cart
    When I navigate to the cart page from the inventory page
    Then I should see all the items I have ordered in my cart

    Scenario: The User views an empty cart
      Given I have no items in my cart
      When I navigate to the cart page
      Then I should see no items in the cart