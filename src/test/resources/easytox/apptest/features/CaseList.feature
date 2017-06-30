
Feature: Verifying the CaseList


Background: 
 Given the easytox url5
	And I enter username5 as "username"
	And I enter password5 as "password"
	And click on "Login" button5 
	

  Scenario: Verify the Search Results
    When Enter CaseList search criteria and Matching records with entered data should be displayed in the CaseList page
    Then close the browser5
	
  Scenario: Verify adding a new case
   	When Click on the Add CaseList icon
    Then "CaseList" screen should be displayed CL
	Then close the browser5

   Scenario:  Verify Number of records displayed per page
   	When Verify the default number of records displayed CL
    Then Default number "10" should be displayed in the dropdown box CL
	When Click on dropdown that shows no of records to be displayed on the page CL
    Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page CL
	Then close the browser5
	
   Scenario:  Verify data sorting 
   	When Click on down arrow icon on sorting column CL
	Then Records should be displayed based on the asecending order of the selected sorting column CL
	When Click on Up icon arrow on Profile Name column CL
	Then Records should be displayed based on the descending order of the selected sorting column CL
	Then close the browser5
  
   Scenario: Edit the case with Accession number
    When Enter CaseList search criteria and Matching records with entered data should be displayed in the CaseList page
  	When Click on Case Accession number
    Then Case screen should be displayed for editing
	Then close the browser5
	
   Scenario: Deleting a case under Action Column
  	When Enter CaseList search criteria and Matching records with entered data should be displayed in the CaseList page
   	When Click on the Delete Case
    Then close the browser5
  
   Scenario: Editing a case under Action Column
   	Then "case" should be displayed under column "action column"
   	When Click on the Edit icon under the Action column for finalised case
   	Then popup window should be displayed
    Then close the browser5
   	
   Scenario:  Verify the Report
    When Enter CaseList search criteria and Matching records with entered data should be displayed in the CaseList page
   	When Click on the Report order icon in page CL
    Then close the browser5

   Scenario: Verify the pagination
   	When clicked on next button CL
	Then the user should be able to navigate to the next page CL
	When clicked on Prev button CL
	Then the user should be able to navigate to the Previous page CL
	Then close the browser5
  