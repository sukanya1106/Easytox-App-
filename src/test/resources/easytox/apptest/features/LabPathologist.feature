 @sanity
Feature: Verifying the Lab List


Background: 
 Given the easytox url4
	And I enter username4 as "username"
	And I enter password4 as "password"
	And click on "Login" button4
	

  Scenario: Verify the Search Results
    
   	When Click Settings Icon
    Then Click on LabPath icon
	When Enter LabPath search criteria and click on search icon
    Then Matching records with entered data should be displayed in the LP
	Then close the browser4
    
  Scenario: Add new pathologist
   	When Click Settings Icon
    Then Click on LabPath icon
	When Click on the Add Pathologist icon
    And Enter Pathologist Personal Information
	Then Click on the Submit Button in pathologist page
   	Then close the browser4


  Scenario: Edit pathologist personal information
   	When Click Settings Icon
    Then Click on LabPath icon
	When Enter LabPath search criteria and click on search icon
    Then Matching records with entered data should be displayed in the LP
	When Click on the Edit Pathologist icon
   	And edit the Pathologist Personal Information
    Then Click on the Update in pathologist page
   	Then close the browser4


	
  Scenario:  Verify Number of records displayed per page
   	When Click Settings Icon
    Then Click on LabPath icon
	When Verify the default number of records displayed LP
    Then Default number "10" should be displayed in the dropdown box LP
	When Click on dropdown that shows no of records to be displayed on the page LP
    Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page LP
	Then close the browser4	

		
		   	
  Scenario:  Verify data sorting 
   	When Click Settings Icon
    Then Click on LabPath icon
	When Click on down arrow icon on sorting column LP
	Then Records should be displayed based on the asecending order of the selected sorting column LP
	When Click on Up icon arrow on Profile Name column LP
	Then Records should be displayed based on the descending order of the selected sorting column LP
	Then close the browser4



  Scenario: Verify the page navigation
   	When Click Settings Icon
    Then Click on LabPath icon
    When clicked on next button LP
	Then the user should be able to navigate to the next page LP
	When clicked on Prev button LP
	Then the user should be able to navigate to the Previous page LP
	Then close the browser4
	
