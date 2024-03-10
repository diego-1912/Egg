
@all

Feature: Search in Spanish Wikipedia
  @Wikipedia1
  Scenario Outline: Navigate to Spanish Wikipedia
    Given I am on the Wikipedia home page
    When I click the "Español" link in the sidebar
    And  I enter "<word>" in the search
    Examples:
      | word |
      | hgdgfhghkj|
      | word2|

  @Wikipedia2
  Scenario Outline: Navigate to Louvre Wikipedia
    Given I am on the Louvre Wikipedia home page
    When I select "<option>"

    Examples:

      |option|
      |#Historia|
      |#Colecciones|

@GPSLogIn

Scenario Outline: I want to log in using valid email and password
  Given I am on the GPS home page
  When I enter <email> and <password>
Examples:
  |email|password|
  |gpsuser@gmail.com|Pssworduser|
  |gpsuser@gmail.com|Psworduser|


@AmazonTest
Scenario Outline: Outline: User selects adds to the cart the third item of the second page


  Given the user navigate to Amazon
  And the user Search for <product>
  And the user navigates to the second page
  And the user selects the third option
  Then the user is able to add it to the car


  Examples:
  |product|
  |Alexa     |
  |PlayStation   |


