Feature: Login page automation

	@smoke
  Scenario Outline: Check login successfully valid cred.
    Given User on login page
    When User enter valid "<username>" and "<password>"
    And Click on login button
    Then User nevigate to home page
    And Close browser

    Examples: 
      | username       | password      |
      | standard_user  | secret_sauce  |
     
  @regression
  Scenario Outline: Check login successfully valid cred.
    Given User on login page
    When User enter valid "<username>" and "<password>"
    And Click on login button
    Then User nevigate to home page
    And Close browser

    Examples: 
      | username       | password      |
      | standard_user1 | secret_sauce1 |
      