Feature: Test login functionality

Scenario: Check login is successfull with credential
    Given User is on login page
    When User enters username and password
    And Clicks on login button
    Then User is navigated to homepage

#Scenario Outline: Title of your scenario
#    Given User is on login page
#    When User enters <username> and <password>
#    And Clicks on login button
#    Then User is navigated to homepage

#    Examples: 
#      | username  | password |
#      | name1 		|     5 	 |
#      | name2 		|     7 	 |
