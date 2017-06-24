@smoke
Feature: Verifying the Patient page


Background: 
 	Given the easytox url3
	And I enter username3 as "usernameOrderList"
	And I enter password3 as "passwordOrderList"
	And click on "Login" button3
	
		Scenario: Navigating to selected screen
			When Enter order search criteria and Matching records with entered data should be displayed in the OrderList page
			Then close the browser3
					
		Scenario:Verify Number of records displayed
		
			When Verify the default number of Patient Order records displayed
			Then Default number "10" should be displayed in the dropdown box on the page OrderList
			When Click on dropdown that shows no of records to be displayed on the page OrderList
			Then User should be able to view and select the options from the list and the corresponding number of Patient records should be displayed on the page OrderList
			Then close the browser3
		
				
		Scenario: Verify data Sorting 
			
			When Click on down arrow icon on sorting column on page OrderList
			Then Records should be displayed based on the ascending order of the selected sorting column on page OrderList
			When Click on Up icon arrow on Profile Name column on page OrderList
			Then Records should be displayed based on the descending order of the selected sorting column on page OrderList
			Then close the browser3
			
					
		Scenario: Verify the pagination
			
			When clicked on next button on page OrderList
			Then the user should be able to navigate to the next page on page OrderList
			When clicked on Prev button on the page OrderList
			Then the user should be able to navigate to the Previous page on page OrderList
			Then close the browser3
		
			
		Scenario:Verifying for the patient information
			
			And Click on PatientPlusIcon
			Then Verify the patient information is displayed
			Then close the browser3
			
		Scenario: :Verify the PrintOrder
			
			When Click on the Print order icon
			Then close the browser3
			
		Scenario: Verify the ReportOrder
			
			When Click on the Report order icon
			Then close the browser3
