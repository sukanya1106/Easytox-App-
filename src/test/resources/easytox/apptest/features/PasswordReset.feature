@smoke
Feature: Verifying the Patient page


Background: 
 	Given the easytox url8
		
		Scenario:Password Reset screen
			When Verify the text Forgot Password Click here
			And Click on Click here link
			Then close the browser8	
		
		Scenario: Password Reset for a lab user
			When Verify the text Forgot Password Click here
			And Click on Click here link
			Then Enter Username as "LabUserone" valid email address and click Send my Password button
			Then close the browser8	
			Given the easytox url8
			And I enter username8 as "SNLabAdmin"
			And I enter password8 as "Test@123"
			Then click on "Login" button8
			Then Click Pending Password Requests link
			And Select the username for which password has to be reset and enter the new password
			Then close the browser8	
			Given the easytox url8
			When Login to Easytox with newly resetted credentials
			When Enter newly resetted credentials and click login
			Then Verify Change Password screen is displayed and reset a new passowrd
			Then close the browser8	
			Given the easytox url8
			When Login to Easytox with newly resetted credentials
			And Enter the newly resetted password
			Then click on "Login" button8
			Then close the browser8
			
		Scenario: Password Reset for a lab pathologist
			When Verify the text Forgot Password Click here
			And Click on Click here link
			Then Enter Username as "SPathOne" valid email address and click Send my Password button
			Then close the browser8	
			Given the easytox url8
			And I enter username8 as "SNLabAdmin"
			And I enter password8 as "Test@123"
			Then click on "Login" button8
			Then Click Pending Password Requests link
			And Select the username for which password has to be reset and enter the new password
			Then close the browser8	
			Given the easytox url8
			When Login to Easytox with newly resetted credentials
			When Enter newly resetted credentials and click login
			Then Verify Change Password screen is displayed and reset a new passowrd
			Then close the browser8	
			Given the easytox url8
			When Login to Easytox with newly resetted credentials
			And Enter the newly resetted password
			Then click on "Login" button8
			Then close the browser8
		
		Scenario: Password Reset for a lab physician
			When Verify the text Forgot Password Click here
			And Click on Click here link
			Then Enter Username as "SPhyOne" valid email address and click Send my Password button
			Then close the browser8	
			Given the easytox url8
			And I enter username8 as "SNLabAdmin"
			And I enter password8 as "Test@123"
			Then click on "Login" button8
			Then Click Pending Password Requests link
			And Select the username for which password has to be reset and enter the new password
			Then close the browser8	
			Given the easytox url8
			When Login to Easytox with newly resetted credentials
			When Enter newly resetted credentials and click login
			Then Verify Change Password screen is displayed and reset a new passowrd
			Then close the browser8	
			Given the easytox url8
			When Login to Easytox with newly resetted credentials
			And Enter the newly resetted password
			Then click on "Login" button8
			Then close the browser8
		
		Scenario: Password Reset for a lab admin
			When Verify the text Forgot Password Click here
			And Click on Click here link
			Then Enter Username as "SNLabAdmin" valid email address and click Send my Password button
			Then close the browser8	
			Given the easytox url8
			And I enter username8 as "superadmin"
			And I enter password8 as "admin"
			Then click on "Login" button8
			Then Click Pending Password Requests link
			And Select the username for which password has to be reset and enter the new password
			Then close the browser8	
			Given the easytox url8
			When Login to Easytox with newly resetted credentials
			When Enter newly resetted credentials and click login
			Then Verify Change Password screen is displayed and reset a new passowrd
			Then close the browser8	
			Given the easytox url8
			When Login to Easytox with newly resetted credentials
			And Enter the newly resetted password
			Then click on "Login" button8
			Then close the browser8
		
		Scenario:  Verify Number of records displayed per page
		    When Verify the text Forgot Password Click here
			And Click on Click here link
			Then Enter Username as "LabUserone" valid email address and click Send my Password button
			Then close the browser8	
			Given the easytox url8
			And I enter username8 as "SNLabAdmin"
			And I enter password8 as "Test@123"
			Then click on "Login" button8
			Then Click Pending Password Requests link
		   	When Verify the default number of records displayed in password reset page
		    Then Default number "10" should be displayed in the dropdown box in password reset page
			When Click on dropdown that shows no of records to be displayed on the password reset page
		    Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the password reset page
			Then close the browser8
			
		Scenario:   Verify data sorting 
		    When Verify the text Forgot Password Click here
			And Click on Click here link
			Then Enter Username as "LabUserone" valid email address and click Send my Password button
			Then close the browser8	
			Given the easytox url8
			And I enter username8 as "SNLabAdmin"
			And I enter password8 as "Test@123"
			Then click on "Login" button8
			Then Click Pending Password Requests link
		   	When Click on down arrow icon on sorting column in password reset page
		    Then Records should be displayed based on the asecending order of the selected sorting column in password reset page
			When Click on Up icon arrow on Profile Name column in password reset page
		    Then Records should be displayed based on the descending order of the selected sorting column in password reset page
			Then close the browser8
		
		Scenario: Verify the page navigation
			When Verify the text Forgot Password Click here
			And Click on Click here link
			Then Enter Username as "LabUserone" valid email address and click Send my Password button
			Then close the browser8	
			Given the easytox url8
			And I enter username8 as "SNLabAdmin"
			And I enter password8 as "Test@123"
			Then click on "Login" button8
			Then Click Pending Password Requests link
		   	When clicked on next button in password reset page
		    Then the user should be able to navigate to the next page in password reset page
			When clicked on Prev button in password reset page
		    Then the user should be able to navigate to the Previous page in password reset page
			Then close the browser8
			
				
		Scenario: Verify the Search Results
			When Verify the text Forgot Password Click here
			And Click on Click here link
			Then Enter Username as "LabUserone" valid email address and click Send my Password button
			Then close the browser8	
			Given the easytox url8
			And I enter username8 as "SNLabAdmin"
			And I enter password8 as "Test@123"
			Then click on "Login" button8
			Then Click Pending Password Requests link
			And Enter data in the search box and Verify the search results
			Then close the browser8	
		
		Scenario: Password Request List
			And I enter username8 as "SNLabAdmin"
			And I enter password8 as "Test@123"
			Then click on "Login" button8
			Then Click Pending Password Requests link
			And Verify the details displayed in Password Request List screen
			Then close the browser8	
