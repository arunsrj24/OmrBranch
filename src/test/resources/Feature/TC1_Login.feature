
Feature: Validate the login functionality of Adactin Hotel Application
@login
  Scenario Outline: Verifying Adactin login with valid
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"

    Examples: 
      | username   | password   |
      | arunarun91 | 9876543210 |

  Scenario Outline: Verifying Adactin login with valid by Enter Key
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>" by Enter Key
    Then User should verify successful login with message "Hello arunarun91!"

    Examples: 
      | username   | password   |
      | arunarun91 | 9876543210 |

  Scenario Outline: Verifying Adactin login with invalid data
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify unsuccessful login with message contains "Invalid Login details"

    Examples: 
      | username   | password |
      | arunarun91 | 11345566 |
