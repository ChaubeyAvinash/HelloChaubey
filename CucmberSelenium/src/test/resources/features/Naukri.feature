Feature: Naukri.com functionality
   
	Scenario Outline: Login with multiple user credentials
    Given User is on the Naukri.com login page
    When User enter the email <email> and password <password>
    Then User should see <title>

  Examples:
    | email               			| password        | title					            |
    | avikashyap5mar@gmail.com  | Achaubey@123    | Avinash Chaubey           |
    
  @smoke  
	Scenario Outline: Update Resume
    Given User is on the Naukri.com login page
    When User enter the email <email> and password <password>
    Then User should see <title>
    And User navigate the profile page and update the resume 

  Examples:
    | email               			| password        | title                       |
    | avikashyap5mar@gmail.com  | Achaubey@123    | Avinash Chaubey             |