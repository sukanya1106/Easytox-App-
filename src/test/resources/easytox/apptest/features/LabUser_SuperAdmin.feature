@smoke
Feature: Verifying the Lab List


Background: 
 Given the easytox url6
	And I enter username6 as "usernamesuper"
	And I enter password6 as "passwordsuper"
	And click on "Login" button6 
 	

  Scenario: Verify Adding Lab Admin User
    When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    And Click on user name under Name Column
    Then close the browser6
	
	Scenario: Verify Adding Lab Admin User
    When Click on LabList Icon
    Then Click on add Lab List Icon
    Then close the browser6
    
   Scenario: Verify the Search Results
    When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter labuser search criteria and click on search icon
    Then close the browser6
	
  Scenario: Verify Number of records displayed
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Verify the default number of records displayed in lab user page
    Then Default number "10" should be displayed in the dropdown box in lab user page
    When Click on dropdown that shows no of records to be displayed on the lab user page
    Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the lab user page
    Then close the browser6
  
  Scenario: Verify data sorting
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Click on down arrow icon on sorting column in lab user page
    Then Records should be displayed based on the asecending order of the selected sorting column in lab user page
    When Click on Up icon arrow on Profile Name column in lab user page
    Then Records should be displayed based on the descending order of the selected sorting column in lab user page
    Then close the browser6
    
   
  Scenario: Verify the edit
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
    When Click Edit user icon in LU page
    And edit the User Information in LU page
    Then Select Update after editing in labuser page
    Then close the browser6
       
    
    Scenario: Lock a Lab User
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
    And Select a unlocked user and click unlock icon under Action column
    Then User should be locked and a message should be populated
	Then close the browser6
	Given the easytox url6
	And Enter username7 as "username1"
	And Enter password7 as "password1"
	And click on "Login" button6
	Then Validate Labuser account locked or disabled
	Then close the browser6

   	
  Scenario: Unlock a Lab User
  
    When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
    And Select a locked user and click lock icon under Action column
    Then User account should be unlocked and a message should be populated
	Then close the browser6
	Given the easytox url6
	And Enter username7 as "username1"
	And Enter password7 as "password1"
	And click on "Login" button6
	Then close the browser6
		

   Scenario: Disable a Lab User
   
	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
    And Select a enabled user and click disable icon under Disable column
    Then User should be disabled and a message should be populated
	Then close the browser6
	Given the easytox url6
	And Enter username7 as "username1"
	And Enter password7 as "password1"
	And click on "Login" button6
	Then Validate Labuser account locked or disabled
	Then close the browser6
	  
   Scenario: Enable a Lab User
   
    When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
    And Select a disabled user and click enable icon under Enable column
    Then User account should be enabled and a message should be populated
	Then close the browser6
	Given the easytox url6
	And Enter username7 as "username1"
	And Enter password7 as "password1"
	And click on "Login" button6
	Then close the browser6
	 
  Scenario: Verify the pagination
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When clicked on next button in lab userpage
    Then the user should be able to navigate to the next page in labuser page
    When clicked on Prev button in labuser page
    Then the user should be able to navigate to the Previous page in labuser page
    Then close the browser6
    
   
   Scenario:  Validating Account Expiration
   
   When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
     And Select a Not expired user and click to expire it
    Then User should be expired and a message should be populated
	Then close the browser6
	Given the easytox url6
	And Enter username7 as "username1"
	And Enter password7 as "password1"
	And click on "Login" button6
	Then Validate Labuser account expired
	Then close the browser6
	
	
  Scenario:  Activate Account Expiration
    When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
    And Select a expired user and click to activate it
    Then User should be activated and a message should be populated
	Then close the browser6
	Given the easytox url6
	And Enter username7 as "username1"
	And Enter password7 as "password1"
	And click on "Login" button6
	Then close the browser6
		
  
	
   Scenario:  Validating Password Expiration
   
   When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
    And Select a Not expired password and click to expire it
    Then User password should be expired and a message should be populated
	Then close the browser6
	Given the easytox url6
	And Enter username7 as "username1"
	And Enter password7 as "password1"
	And click on "Login" button6
	Then Validate Labuser password expired
	Then close the browser6
	
 
	
		
  Scenario:  Activate Password Expiration
  
   When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
    And Select a Password expired user and click to activate it
    Then User password should be expired and a message should be populated
	Then close the browser6
	Given the easytox url6
	And Enter username7 as "username1"
	And Enter password7 as "password1"
	And click on "Login" button6
	Then close the browser6
	
	
  Scenario: Verify the edit
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on Lab user icon from LabList page
    When Enter user and click on searchbutton
    Then Matching user with entered data are displayed in the Lab user
    When Click Edit user icon in LU page
    And edit the User Information in LU page
    Then Select Update after editing in labuser page
    When Enter user and click on searchbutton
    And Select UserPlusIcon in labuser page
    And Verify the updated userpersonal information in labuser page
    Then close the browser6
	
	
   Scenario: Verify LabClient Search Results
    When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on lab client icon from LabList page
    When Enter Labclient search criteria and click on search icon and Matching records with entered data should be displayed
    Then close the browser6
    
  Scenario: Verify LabClient Number of records displayed
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on lab client icon from LabList page
    When Verify the default number of records displayed in lab user page
    Then Default number "10" should be displayed in the dropdown box in lab user page
    When Click on dropdown that shows no of records to be displayed on the lab user page
    Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the lab user page
    Then close the browser6
  
  Scenario: Verify LabClient data sorting
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on lab client icon from LabList page
    When Click on down arrow icon on sorting column in lab user page
    Then Records should be displayed based on the asecending order of the selected sorting column in lab user page
    When Click on Up icon arrow on Profile Name column in lab user page
    Then Records should be displayed based on the descending order of the selected sorting column in lab user page
    Then close the browser6
    
   Scenario: Verify the LabClient pagination
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on lab client icon from LabList page
    When clicked on next button in lab userpage
    Then the user should be able to navigate to the next page in labuser page
    When clicked on Prev button in labuser page
    Then the user should be able to navigate to the Previous page in labuser page
    Then close the browser6
    
   Scenario: Verify the Labclient information
   	When Click on LabList Icon
    When Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed
    When Click on lab client icon from LabList page
    When Enter Labclient search criteria and click on search icon and Matching records with entered data should be displayed
    And Click on PlusIcon in Labclient page to verify lab information
    And Verify the Labclient information
    Then close the browser6
    
    
	
	