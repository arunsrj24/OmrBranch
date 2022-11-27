@search
Feature: Validate the search hotel functionality in Adactin Hotel

  Scenario Outline: Validate the seach hotel by entering all details
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    And User search hotel by entering following details "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adultsperroom>" and "<childrenperroom>"
    Then User should verify after search by success message "Select Hotel"

    Examples: 
      | username   | password   | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adultsperroom | childrenperroom |
      | arunarun91 | 9876543210 | Sydney   | Hotel Creek | Double   | 2 - Two       | 03/10/2022  | 04/10/2022   | 2 - Two       | 2 - Two         |

  Scenario Outline: Validate the seach hotel by entering only mandatory fields
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    And User search hotel by entering only mandatory fields "<location>", "<numberofrooms>", "<checkindate>", "<checkoutdate>" and "<adultsperroom>"
    Then User should verify after search by success message "Select Hotel"

    Examples: 
      | username   | password   | location | numberofrooms | checkindate | checkoutdate | adultsperroom |
      | arunarun91 | 9876543210 | Sydney   | 2 - Two       | 03/10/2022  | 04/10/2022   | 2 - Two       |

  Scenario Outline: Validate the seach hotel by providing wrong checkin and checkout date
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    And User search hotel by entering following details "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adultsperroom>" and "<childrenperroom>"
    Then User should verify after search by error message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username   | password   | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adultsperroom | childrenperroom |
      | arunarun91 | 9876543210 | Sydney   | Hotel Creek | Double   | 2 - Two       | 08/10/2022  | 01/10/2022   | 2 - Two       | 2 - Two         |

  Scenario Outline: Validate the seach hotel without entering any details
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    When User click search button without entering any fields
    Then User verify after search by error message "Please Select a Location"

    Examples: 
      | username   | password   |
      | arunarun91 | 9876543210 |
