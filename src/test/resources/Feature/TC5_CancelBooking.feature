@cancel
Feature: Validate the Cancel Booking functionality in Adactin Hotel

  Scenario Outline: Validate the cancel booking of created order id
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    And User search hotel by entering following details "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adultsperroom>" and "<childrenperroom>"
    Then User should verify after search by success message "Select Hotel"
    And User should select Hotel name
    Then User should verify after select Hotel with success message "Book A Hotel"
    And User should book a hotel by entering following details "<firstname>", "<lastname>" and "address"
      | CreditcardNumber | CreditcardType   | SelectMonth | SelectYear | Cvv  |
      | 9876543210123456 | VISA             | October     |       2022 | 4525 |
      | 1234567890123456 | Master Card      | November    |       2022 | 9696 |
      | 9876543210123456 | American Express | December    |       2022 | 7878 |
      | 7894561230123456 | Other            | October     |       2022 | 7841 |
    Then User should verify after book hotel with success message "Booking Confirmation" and saved order id
    And User should cancel created order id
    Then User should verify after cancel order id with success message "The booking has been cancelled."

    Examples: 
      | username   | password   | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adultsperroom | childrenperroom | firstname | lastname   | address |
      | arunarun91 | 9876543210 | Sydney   | Hotel Creek | Double   | 2 - Two       | 03/10/2022  | 04/10/2022   | 2 - Two       | 2 - Two         | Arun      | Ramalingam | Trichy  |

  Scenario Outline: Validate the cancel booking of existing order id
    Given User should navigate to the Adactin login page using url
    When User should login by entering "<username>", "<password>"
    Then User should verify successful login with message "Hello arunarun91!"
    And User should cancel existing order id "<orderid>"
    Then User should verify after cancel order id with success message "The booking has been cancelled."

    Examples: 
      | username   | password   | orderid    |
      | arunarun91 | 9876543210 | E9419Q0SS3 |
