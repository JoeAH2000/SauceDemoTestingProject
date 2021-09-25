Feature: Inventory page stuff

  Scenario: Test to click on hamburger menu
    Given I am on the All items page
    When I click on the Hamburger menu
    Then A dropdown list of links should appear

  Scenario: Test to click on All items link
    Given I am on the All items page
    When I click on the ‘All Items’ link
    Then I should be navigated to the ‘All Items’ page, where I can see all items currently for sale

  Scenario: Test to click on About link
    Given I am on the All items page
    And I click on the Hamburger menu
    When I click on the ‘About’ link
    Then The ‘About’ page should open

  Scenario: If the user is logged in they should have the ability to log out
    Given I am on the All items page
    When The logout link is clicked
    Then The user should get logged out

  Scenario: Click on the Reset App State button to remove items from basket
    Given That I have items in the checkout basket
    When I click on the ‘Reset App State’ link
    Then Those items should be removed from the basket

  Scenario: Click on the Reset App State button to reset buttons
    Given That I have items in the checkout basket
    When I click on the ‘Reset App State’ link
    Then The state of the button should be reset

  Scenario: Navigate to Checkout page
    Given I am on the All items page
    When I click on the checkout cart link
    Then I should navigate to the checkout page

  Scenario: Test if the number of items in the basket represent the number of items I've chosen.
    Given I am on the All items page
    When I have added an item to the cart
    Then The number of items in the cart should match the number of items added

  Scenario: Click ‘A to Z’ for filter.
    Given I am on the All items page
    When I click on the A to Z filter
    Then The products should get sorted alphabetically, starting from A

  Scenario: Click ‘Z to A’ for filter.
    Given I am on the All items page
    When I click on the Z to A filter
    Then The products should get sorted alphabetically, starting from Z going backwards

  Scenario: Click ‘low to high’ for filter.
    Given I am on the All items page
    When I click on the low to high filter
    Then The products should get sorted by their price, starting from the lowest

  Scenario: Click 'high to low' for filter.
    Given I am on the All items page
    When I click on the high to low filter
    Then The products should get sorted by their price, starting from the highest

  Scenario: Click on the name of a product, to see more information
    Given I am on the All items page
    When I click on the name of a product
    Then I should be navigated to a new page that has more information for that product

  Scenario: Click on the image of a product, to see more information
    Given I am on the All items page
    When I click on the image for a product
    Then I should be navigated to a new page that has more information for that product

  Scenario: Click on the 'Add to Cart' button
    Given I am on the All items page
    When I have added an item to the cart
    Then The button should change from ‘Add to Cart’ to ‘Remove’ and the number in the checkout basket should increase by 1

  Scenario: Click on to 'Remove' button
    Given I am on the All items page
    And I have added an item to the cart
    When I click on the ‘Remove’ button
    Then The button should change from ‘Remove’ to ‘Add to Cart’ and the number in the checkout basket should decrease by 1

  Scenario: Click on the Facebook link
    Given I am on the All items page
    When The facebook link is pressed
    Then I should navigate to the Facebook page

  Scenario: Click on the Twitter link
    Given I am on the All items page
    When The twitter link is pressed
    Then I should navigate to the Twitter page

    Scenario: Click on the LinkedIn link
    Given I am on the All items page
    When The linkedin link is pressed
    Then I should navigate to the LinkedIn page