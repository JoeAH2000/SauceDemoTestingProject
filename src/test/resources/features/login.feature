Feature: AS A User, I WANT to login to Swag Labs SO THAT I can purchace items from the shops

  Scenario: User successfully logs in
    Given  I have a valid username
    And I have a valid password
    When I enter my username
    And I enter my password
    Then I go to the inventory page from the login page

  Scenario: User does not have a valid password
    Given I have a valid username
    And I do not have a valid password
    When I enter my username
    And I enter my password
    Then I stay on the login page

  Scenario: User does not have a valid username
    Given I do not have a valid username
    And I have a valid password
    When I enter my username
    And I enter my password
    Then I stay on the login page

    Scenario: User does not have a valid username or password
      Given I do not have a valid username
      And I do not have a valid password
      When I enter my username
      And I enter my password
      Then I stay on the login page