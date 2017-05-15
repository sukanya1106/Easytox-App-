@smoke
Feature: Verifying the Lab List


Background: 
 	Given the easytox url
	And I enter username as "username"
	And I enter password as "password"
	And click on "Login" button 
	

 
  Scenario: Verify the Search Results
   	When Click on Settings Icon
    Then Click on user icon
	When Enter user search criteria and click on search icon
    Then Matching records with entered data should be displayed in the Lab user
	Then close the browser
  
  Scenario: Verify Lab User List of particular user under Action Column
   	When Click on Settings Icon
    Then Click on user icon
	When Enter user search criteria and click on search icon
    Then Matching records with entered data should be displayed in the Lab user
   	When Click on the Edit user icon
   	And edit the User Personal Information
   	Then Click on the Update Button
   	When Enter user search criteria and click on search icon
   	And Click on UserPlusIcon
   	And Verify the Modified user personal information
	Then close the browser

   Scenario: Lock a Lab User
   	When Click on Settings Icon
    Then Click on user icon
	When Enter user search criteria and click on search button
   	Then Matching user with entered data should be displayed in the Lab user
    And Select a user which is unlocked and click "lock" icon under Action column
    Then User should be locked and "User locked successfully" message should be populated
	Then close the browser
	Given the easytox url
	And Enter username1 as "username1"
	And Enter password1 as "password1"
	And click on "Login" button
	Then Validate account locked or disabled
	Then close the browser

   	
   Scenario: Unlock a Lab User
  	When Click on Settings Icon
    Then Click on user icon
	When Enter user search criteria and click on search button
   	Then Matching user with entered data should be displayed in the Lab user
    And Select a user which is locked and click "Unlock" icon under Action column
    Then User account should be unlocked and "User unlocked successfully" message should be populated
	Then close the browser
	Given the easytox url
	And Enter username1 as "username1"
	And Enter password1 as "password1"
	And click on "Login" button
	Then close the browser
	



    Scenario: Disable a Lab User
   	When Click on Settings Icon
    Then Click on user icon
	When Enter user search criteria and click on search button
   	Then Matching user with entered data should be displayed in the Lab user
    And Select a user which is enabled and click "disable" icon under Enable/Disable column 
   	Then User should be disabled and "User disabled successfully" message should be populated
	Then close the browser
	Given the easytox url
	And Enter username1 as "username1"
	And Enter password1 as "password1"
	And click on "Login" button
	Then Validate account locked or disabled
	Then close the browser

  
   Scenario: Enable a Lab User
   	When Click on Settings Icon
    Then Click on user icon
	When Enter user search criteria and click on search button
   	Then Matching user with entered data should be displayed in the Lab user
   	And Select a user which is disabled and click "Enable" icon under Enable/Disable column 
    Then User account should be enabled and "User enabled successfully" message should be populated
    Then close the browser
	Given the easytox url
	And Enter username1 as "username1"
	And Enter password1 as "password1"
	And click on "Login" button 
	Then close the browser

	Scenario:  Verify Number of records displayed per page
   	When Click on Settings Icon
    Then Click on user icon
	When Verify the default number of records displayed LU
    Then Default number "10" should be displayed in the dropdown box LU
	When Click on dropdown that shows no of records to be displayed on the page LU
    Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page LU
	Then close the browser		

		
		   	
   	Scenario:  Verify data sorting 
   	When Click on Settings Icon
    Then Click on user icon
	When Click on down arrow icon on sorting column LU
	Then Records should be displayed based on the asecending order of the selected sorting column LU
	When Click on Up icon arrow on Profile Name column LU
	Then Records should be displayed based on the descending order of the selected sorting column LU
	Then close the browser



   	Scenario: Verify the page navigation
  	When Click on Settings Icon
    Then Click on user icon
	When clicked on next button AP
	Then the user should be able to navigate to the next page LU
	When clicked on Prev button LU
	Then the user should be able to navigate to the Previous page LU
	Then close the browser