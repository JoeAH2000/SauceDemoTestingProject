Feature: AS A User, I want to be able to see the details of the items I am ordering SO THAT I can make sure I have ordered the correct items

  Background:
    Given I have a valid username
    And  I have a valid password
    When I enter my username
    And I enter my password
    And I go to the inventory page from the login page

  Scenario: The User is looking at a specific item in the cart for quantity
    Then I should see the quantity of the item

    Scenario: The User is looking for item price
      Then I should see the name of the item

      Scenario: The user is looking for the item description
        Then I should see the item description
