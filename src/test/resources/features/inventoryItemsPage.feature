Feature: Viewing a Specific Products Information

  Background: Beginning on the Inventory-Item Page
    Given I am on a specific product page

    Scenario: I want to view details of a specific product
      Then I can see the specific product's title
      And I can see the specific product's description
      And I can see the specific product's price
      And I can see the specific product's image

    Scenario: I want to proceed to the checkout page
      When I click on the cart icon from the specific product Page
      Then I leave the specific product page and end on the cart checkout page

    Scenario: I want to add an item to my cart
      When I click the Add Product Button on the specific product page
      Then I see the cart logo on the specific product page increase by one

    Scenario: I want to remove an item from my cart
      When I click the Remove Product Button on the specific product page
      Then I see the cart logo on the specific product page decrease by one

    Scenario: I want to go back to the Inventory Page
      When I click the Back To Products button on the specific product page
      Then I leave the specific product page and I end on the inventory page

    Scenario: I want to visit the Swag Labs Twitter page from the specific item page
      When I click the Twitter Logo on the specific item page
      Then A new tab opens next to the specific item page with the Twitter page

    Scenario: I want to visit the Swag Labs Facebook page from the specific item page
      When I click the Facebook Logo on the specific item page
      Then A new tab opens next to the specific item page with the Facebook Page

    Scenario: I want to visit the Swag Labs LinkedIn page from the specific item page
      When I click the LinkedIn Logo on the specific item page
      Then A new tab opens next to the specific item page with the LinkedIn Page

