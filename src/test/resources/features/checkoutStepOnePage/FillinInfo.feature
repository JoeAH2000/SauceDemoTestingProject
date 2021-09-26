@checkoutOnePage
Feature: Fill in Information
  AS A User, I WANT to type in my information SO THAT the order can be delivered

  Background:
    Given I am on the customer information page

    Scenario: User completes all fields and continues to the next page
      When I fill in the first name, last name and postcode fields
      And I click on Continue button
      Then I should be directed to the overview page

    Scenario: User cancels from the customer information page.
      When I click on Cancel button
      Then I should be directed to the cart page

    Scenario: User does not fill out the first name field
      When I fill in the last name field and the post code field
      And I click on Continue button
      Then I should get an error message “Error: First Name is required”

    Scenario: User does not fill out the last name field
      When I fill in the first name field and the post code field
      And I click on Continue button
      Then I should get an error message “Error: Last Name is required”

    Scenario: User does not fill out the postcode field
      When I fill in the first name field and the last name field
      And I click on Continue button
      Then I should get an error message “Error: Postal Code is required”

      @ignore
    Scenario: User does not fill out more than one field
      When I click on Continue button
      Then I should get a list of error messages for each field

