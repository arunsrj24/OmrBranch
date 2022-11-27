@book
Feature: Validate the Book hotel functionality in Adactin Hotel

  Scenario Outline: Validate the Book hotel by entering all details
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    And User search hotel by entering following details "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adultsperroom>" and "<childrenperroom>"
    Then User should verify after search by success message "Select Hotel"
    And User should select Hotel name
    Then User should verify after select Hotel with success message "Book A Hotel"
    And User should book a hotel by entering following details "<firstname>", "<lastname>" and "<address>"
      | CreditcardType   | CreditcardNumber | SelectMonth | SelectYear | Cvv  |
      | VISA             | 9876543210123456 | October     |       2022 | 4525 |
      | Master Card      | 1234567890123456 | November    |       2022 | 9696 |
      | American Express | 9876543210123456 | December    |       2022 | 7878 |
      | Other            | 7894561230123456 | October     |       2022 | 7841 |
    Then User should verify after book hotel with success message "Booking Confirmation"

    Examples: 
      | username   | password   | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adultsperroom | childrenperroom | firstname | lastname   | address |
      | arunarun91 | 9876543210 | Sydney   | Hotel Creek | Double   | 2 - Two       | 03/10/2022  | 04/10/2022   | 2 - Two       | 2 - Two         | Arun      | Ramalingam | Trichy  |

  Scenario Outline: Validate the Book hotel without entering any details
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    And User search hotel by entering following details "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adultsperroom>" and "<childrenperroom>"
    Then User should verify after search by success message "Select Hotel"
    And User should select Hotel name
    Then User should verify after select Hotel with success message "Book A Hotel"
    And User should book a hotel without entering any fields
    Then User should verify after book hotel with error message "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username   | password   | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adultsperroom | childrenperroom |
      | arunarun91 | 9876543210 | Sydney   | Hotel Creek | Double   | 2 - Two       | 03/10/2022  | 04/10/2022   | 2 - Two       | 2 - Two         |
