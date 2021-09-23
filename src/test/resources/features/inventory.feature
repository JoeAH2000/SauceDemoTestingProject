Feature: Inventory page stuff
  Scenario: Test to click on hamburger menu
    Given I am on the All items page
    When I click on the Hamburger menu
    Then A dropdown list of links should appear

  Scenario: Test to click on All items link
    Given That the ‘All Items’ link appears after clicking on the Hamburger menu.
    When I click on the ‘All Items’ link.
    Then I should be navigated to the ‘All Items’ page, where I can see all items currently for sale.

    Scenario: Test to click on About link
    Given I am on the ‘All Items’ page.
    And I click on the Hamburger menu.
    When I click on the ‘About’ link.
    Then The ‘About’ page should open.