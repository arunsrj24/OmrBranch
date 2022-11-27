@select
Feature: Validate the Select hotel functionality in Adactin Hotel

  Scenario Outline: Validate the select hotel functionality
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    And User search hotel by entering following details "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adultsperroom>" and "<childrenperroom>"
    Then User should verify after search by success message "Select Hotel"
    And User should select Hotel name
    Then User should verify after select Hotel with success message "Book A Hotel"

    Examples: 
      | username   | password   | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adultsperroom | childrenperroom |
      | arunarun91 | 9876543210 | Sydney   | Hotel Creek | Double   | 2 - Two       | 03/10/2022  | 04/10/2022   | 2 - Two       | 2 - Two         |

  Scenario Outline: Validate the select hotel functionality without select hotel name
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    And User search hotel by entering following details "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adultsperroom>" and "<childrenperroom>"
    Then User should verify after search by success message "Select Hotel"
    And User should click continue without select hotel name
    Then User should verify after select Hotel with error message "Please Select a Hotel"

    Examples: 
      | username   | password   | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adultsperroom | childrenperroom |
      | arunarun91 | 9876543210 | Sydney   | Hotel Creek | Double   | 2 - Two       | 03/10/2022  | 04/10/2022   | 2 - Two       | 2 - Two         |
