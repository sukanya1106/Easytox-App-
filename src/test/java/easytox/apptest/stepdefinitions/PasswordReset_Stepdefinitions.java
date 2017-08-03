package easytox.apptest.stepdefinitions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.easytox.automation.driver.DriverBase;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import easytox.apptest.pages.AbstractPage;
import easytox.apptest.pages.LabUserPage;
import easytox.apptest.pages.LablistPage;
import easytox.apptest.pages.LoginPage;
import easytox.apptest.utils.WebConnector;
import junit.framework.Assert;

public class PasswordReset_Stepdefinitions {
	private WebElement row;
	
	WebDriver driver = null;	
	LoginPage loginpage;
	WebConnector connector = new WebConnector();
	
	@Given("^the easytox url8$")
	public void the_easytox_url() {
		System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
		driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		loginpage.navigatetowebApp();
		
		return;
	}
		
	    
	@And("^I enter username8 as \"([^\"]*)\"$")
	public void i_enter_the_username(String arg1) {
		
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"UsernameAdmin"));
	}
	
	@And("^I enter password8 as \"([^\"]*)\"$")
	public void i_enter_the_password(String arg1) {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"PasswordAdmin"));
	}

	@Then("^click on \"([^\"]*)\" button8$")
	public void click_on_button(String arg1) {
		loginpage.Loginbuttonclick();		
	}
	
	@Then("^close the browser8$")
	public void close_the_browser() {
	   loginpage.closeDriver();
	}
	
//*********************************************** 1: Password Reset screen*************************************
	
	
	@When("^Verify the text Forgot Password Click here")
	public void Verify_the_text_Forgot_Password_Click_here() throws Throwable {
				
		
		boolean Clickhere = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Clickhere")).isDisplayed();
		Assert.assertEquals(true, Clickhere);
	
	}
	
	
	@And("^Click on Click here link")
	public void Click_Click_herelink() throws Throwable {
		int i;	
		String Data = "ForgotPassword;UserNameForgotPassword;EmailIDForgotPassword;Sendmypassword";
		 String[] Data1 = Data.split(";");
		 int Size = Data1.length;
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Clickhere")).click();
		Thread.sleep(2000);
		for(i=0;i<Size;i++){
			boolean ForgotPassword = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,Data1[i])).isDisplayed();
			Assert.assertEquals(true, ForgotPassword);
		}
		
	}
	
	
//*********************************************** 2: Password Reset for a lab user************************************************
	
	@Then("^Enter Username as \"([^\"]*)\" valid email address and click Send my Password button$")
	public void Enter_Username_as_LabUserone_valid_email_address_and_click_Send_my_Password_button(String arg1) throws Throwable{
		
		Thread.sleep(5000);
		WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				  connector.getstring(WebConnector.myUrl.URL_OR,"UserNameForgotPassword"));
		String UserNamereset = connector.getstring(WebConnector.myUrl.URL_OR,"UserNamereset");
	    WbElm.sendKeys(UserNamereset);
	    Thread.sleep(2000);
	    WebElement WbElm1 = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				  connector.getstring(WebConnector.myUrl.URL_OR,"EmailIDForgotPassword"));
		String EmailIDreset = connector.getstring(WebConnector.myUrl.URL_OR,"EmailIDreset");
	    WbElm1.sendKeys(EmailIDreset);
	    connector.getWebElement(driver, WebConnector.Identifier.xpath,
				  connector.getstring(WebConnector.myUrl.URL_OR,"Sendmypassword")).click();
	    Thread.sleep(3000);
	    boolean ResetMessage = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ResetMessage")).isDisplayed();
	    Assert.assertEquals(true, ResetMessage);
		
	}
	
	
			

//*****************************************Pending Password Requests***************************************** 
	
	@Then("^Click Pending Password Requests link$")
	public void Click_Pending_Password_Requests_link() throws Throwable {
		    Thread.sleep(5000);
			WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"PendingPasswordReequest"));
	
			WbElm.click();
			boolean SeeAllRequest = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
									connector.getstring(WebConnector.myUrl.URL_OR,"SeeAllRequest")).isDisplayed();
			Assert.assertEquals(true, SeeAllRequest);
			connector.getWebElement(driver, WebConnector.Identifier.xpath, 
					connector.getstring(WebConnector.myUrl.URL_OR,"SeeAllRequest")).click();
	}
	@And("^Select the username for which password has to be reset and enter the new password$")		
	public void Select_the_username_for_which_password_has_to_be_reset_and_enter_the_new_password() throws Throwable {
		Thread.sleep(5000);	
		boolean PasswordSearchBox = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
					connector.getstring(WebConnector.myUrl.URL_OR,"PasswordSearchBox")).isDisplayed();
			Assert.assertEquals(true, PasswordSearchBox);
			
			connector.getWebElement(driver, WebConnector.Identifier.xpath, 
					connector.getstring(WebConnector.myUrl.URL_OR,"PasswordSearchBox")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"UserNamereset"));
			Thread.sleep(5000);
			WebElement tableBody = driver.findElement(By.id("example"));
			
			List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
			for(int i=1;i<=rows.size();i++) {
				row = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]"+"/td[6]"));  //*[@id="example"]/tbody/tr[1]/td[4]  //*[@id="example"]/tbody/tr[3]/td[4]
				//String cell = row.findElement(By.xpath("//td[4]")).getText(); 
				String cell = row.getText();
				System.out.println("now row is "+i);
				System.out.println("(((((("+cell+"))))");
				if (cell.contains("Pending")){
					driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]"+"/td[7]/div/div/form/a")).click(); 
				boolean EnterNewPassword = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
						connector.getstring(WebConnector.myUrl.URL_OR,"EnterNewPassword")).isDisplayed();
				Assert.assertEquals(true, EnterNewPassword);
				connector.getWebElement(driver, WebConnector.Identifier.xpath, 
						connector.getstring(WebConnector.myUrl.URL_OR,"EnterNewPassword")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"NewPassword"));
				connector.getWebElement(driver, WebConnector.Identifier.xpath, 
						connector.getstring(WebConnector.myUrl.URL_OR,"SavePasswordReset")).click();
				Thread.sleep(5000);
				
				String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"PasswordResetMsg")).getText();
				//System.out.println("=====$$=="+Message);		
				boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "successfully");
				Assert.assertEquals(containerContainsContent, true);
				break;
				}
			}
			
			
		}
			
	
//********************************Change password***********************************
	
	@When("^Login to Easytox with newly resetted credentials$")
	public void Login_to_Easytox_with_credentials() throws Throwable {
			Thread.sleep(5000);
			
			loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"UsernameToResetPwd"));
			
	}
	@When("^Enter newly resetted credentials and click login")
	public void Enter_newly_resetted_credentials_and_click_login() throws Throwable {
			Thread.sleep(5000);
			
			
			loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"Resettedpwd"));
			loginpage.Loginbuttonclick();
	}
	
	@Then("^Verify Change Password screen is displayed and reset a new passowrd$")
	public void Verify_Change_Password_screen_is_displayed() throws Throwable {
			
		boolean Changepwd = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
		connector.getstring(WebConnector.myUrl.URL_OR,"Changepwd")).isDisplayed();
		Assert.assertEquals(true, Changepwd);
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR,"EnteroldPassword")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"NewPassword"));
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR,"EnterNewPassword")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"ResetNewPassword"));
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR,"ConfirmNewPassword")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"ResetNewPassword"));
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR,"SavePasswordReset")).click();
		Thread.sleep(5000);
		
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"PasswordChangedSuccessMsg")).getText();
		//System.out.println("=====$$=="+Message);		
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "successfully");
		Assert.assertEquals(containerContainsContent, true);
			
		}
	@And("^Enter the newly resetted password$")
	public void Enter_the_newly_resetted_password() {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"ResetNewPassword"));
	}
	
	
		
//***************************************************************************Scenario 2:Verify Number of records displayed*************************************************************************	
				
		
		
		@When("^Verify the default number of records displayed in password reset page$")
		public void verify_the_default_number_of_records_displayed_in_lab_user_page() throws Throwable {
			WebElement table = driver.findElement(By.id("example"));
			int rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			
			Assert.assertTrue(rowsCount <= 10);
		}
		
		@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box in password reset page$")
		public void default_number_should_be_displayed_in_the_dropdown_box_in_lab_user_page(String arg1) throws Throwable {
			Thread.sleep(2000);
			Select dropdown = new Select (driver.findElement(By.name("example_length")));
			System.out.println("test:"+dropdown.getFirstSelectedOption().getText());
			int defaultNo = Integer.valueOf(dropdown.getFirstSelectedOption().getText());
			
			Assert.assertEquals(10, defaultNo);
		}
		
		@When("^Click on dropdown that shows no of records to be displayed on the password reset page")
		public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_lab_user_page() throws Throwable {
			Thread.sleep(2000);
			driver.findElement(By.name("example_length")).click();
			Thread.sleep(2000);
		}
		
		@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the password reset page$")
		public void user_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_lab_user_page() throws Throwable {
			Select dropdown = new Select (driver.findElement(By.name("example_length")));
			dropdown.selectByIndex(1);
			Thread.sleep(2000);
			
			WebElement table = driver.findElement(By.id("example"));
			int rowsCount;
			
			for (int i = 0; i < 4; i++) {
				dropdown.selectByIndex(i);
				int value = Integer.parseInt(dropdown.getFirstSelectedOption().getText());
				rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
				
				Assert.assertTrue(rowsCount <= value);
				
				Thread.sleep(2000);
			}
		}


		
		
//**************************************************************************************Scenario 3: Verify the data sorting**********************************************************************
				
		private WebElement element;
				
		@When("^Click on down arrow icon on sorting column in password reset page$")
		public void click_on_down_arrow_icon_on_sorting_column_in_lab_user_page() throws Throwable {
			
			loginpage.waittime();
			element = driver.findElement(By.cssSelector("thead > tr > th:nth-child(3)"));
			element.click();
		}

		@Then("^Records should be displayed based on the asecending order of the selected sorting column in password reset page$")
		public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_sorting_column_in_lab_user_page() throws Throwable {
			Thread.sleep(3000);
			Assert.assertTrue(element.getAttribute("class").contains("sorting_asc"));
		}

		@When("^Click on Up icon arrow on Profile Name column in password reset page$")
		public void click_on_Up_icon_arrow_on_Profile_Name_column_in_lab_user_page() throws Throwable {
			element.click();
		}

		@Then("^Records should be displayed based on the descending order of the selected sorting column in password reset page$")
		public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_sorting_column_in_lab_user_page() throws Throwable {
			Thread.sleep(1000);
			Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
		}
//*****************************************************************************************Scenario:4 Page Navigation*********************************************************************************
		private int activePage;
		
		@When("^clicked on next button in password reset page$")
		public void clicked_on_next_button_in_lab_userpage() throws Throwable {
			Thread.sleep(1000);
			WebElement next = driver.findElement(By.cssSelector(".next > a"));
			
			if(next.isEnabled()) {
				next.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the next page in password reset page$")
		public void the_user_should_be_able_to_navigate_to_the_next_page_in_labuser_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
		@When("^clicked on Prev button in password reset page$")
		public void clicked_on_Prev_button_in_labuser_page() throws Throwable {
			Thread.sleep(1000);
			WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
			
			if(prev.isEnabled()) {
				prev.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the Previous page in password reset page$")
		public void the_user_should_be_able_to_navigate_to_the_Previous_page_in_labuser_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}

//*******************************************************************************Scenario5: Verify the search results**************************************************************************
		
		@And("^Enter data in the search box and Verify the search results$")		
		public void Enter_data_in_the_search_box_and_Verify_the_search_results() throws Throwable {
			Thread.sleep(2000);	
			boolean PasswordSearchBox = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
						connector.getstring(WebConnector.myUrl.URL_OR,"PasswordSearchBox")).isDisplayed();
				Assert.assertEquals(true, PasswordSearchBox);
				
				connector.getWebElement(driver, WebConnector.Identifier.xpath, 
						connector.getstring(WebConnector.myUrl.URL_OR,"PasswordSearchBox")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"FindwithEmail"));
				String Emailinfo = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
						connector.getstring(WebConnector.myUrl.URL_OR,"locateEmail")).getText();
				String Email = connector.getstring(WebConnector.myUrl.URL_OR,"FindwithEmail");
				Assert.assertEquals(Email, Emailinfo);
		}


//*******************************************************************************Scenario5: Password Request List**************************************************************************
				
				@And("^Verify the details displayed in Password Request List screen$")		
				public void Verify_the_details_displayed_in_Password_Request_List_screen() throws Throwable {
					Thread.sleep(2000);	
					
					String Data = "Request;Requested By;Requested Date;Requested Email;Resolved By;Status;Action";
					 String[] Data1 = Data.split(";");
					 int Size = Data1.length;
					for(int i=0;i<Size;i++){
						
						Thread.sleep(1000);
						WebElement tableBody = driver.findElement(By.id("example"));
						
						List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
						 int j=i+1;
							row = driver.findElement(By.xpath("//table[@id='example']/thead/tr[1]"+"/th["+j +"]"));  
							//String cell = row.findElement(By.xpath("//td[4]")).getText(); 
							String cell = row.getText();
							System.out.println(Data1[i]);
							System.out.println(cell);
							Assert.assertEquals(cell, Data1[i]);
							
					}
							
					}

}
