@smoke
Feature: Verifying the Patient page


Background: 
 	Given the easytox url1
	And I enter username1 as "username"
	And I enter password1 as "password"
	And click on "Login" button1
	
		Scenario: Navigating to selected screen
			When Click on Patient Icon
			Then close the browser1
					
		
		Scenario: Navigating to selected screen
			When Click on Patient Icon
			When Enter Patient search criteria and Matching records with entered data should be displayed in the Patient page
			Then close the browser1
			
			
		Scenario: Adding a new patient
			When Click on Patient Icon
			When Click on the Add New Patient icon
			Then Add Patient screen should  be displayed
			Then close the browser1
			
		Scenario:Verify Number of records displayed
			When Click on Patient Icon
			When Verify the default number of Patient records displayed
			Then Default number "10" should be displayed in the dropdown box on the page Patient
			When Click on dropdown that shows no of records to be displayed on the page Patient
			Then User should be able to view and select the options from the list and the corresponding number of Patient records should be displayed on the page Patient
			Then close the browser1
		
				
		Scenario: Verify data Sorting 
			When Click on Patient Icon
			When Click on down arrow icon on sorting column on page patient
			Then Records should be displayed based on the ascending order of the selected sorting column on page patient
			When Click on Up icon arrow on Profile Name column on page patient
			Then Records should be displayed based on the descending order of the selected sorting column on page patient
			Then close the browser1
			
		Scenario: Editing patient information
			When Click on Patient Icon
			When Enter Patient search criteria and Matching records with entered data should be displayed in the Patient page
			When Click on the Edit Patient icon
			And edit the Patient Personal Information
			Then Click on the Patient Update Button
			Then close the browser1
		 
	
		Scenario: Verify the Insurance Details under Action Column
			When Click on Patient Icon
			When Enter Patient search criteria and Matching records with entered data should be displayed in the Patient page
			When Click on the Insurance Detail icon
			And Verify Insurance Detail screen is popped
			Then close the browser1
			
			
		Scenario: Verify the pagination
			When Click on Patient Icon
			When clicked on next button on page patient
			Then the user should be able to navigate to the next page on page patient
			When clicked on Prev button
			Then the user should be able to navigate to the Previous page on page patient
			Then close the browser1
		
			
		Scenario:Verifying for the patient information
			When Click on Patient Icon
			And Click on PatientPlusIcon
			Then Verify the patient information is displayed
			Then close the browser1
