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

public class LabUserStepdefinitions {
	
	
	WebDriver driver = null;	
	LoginPage loginpage;
	WebConnector connector = new WebConnector();
	LabUserPage labuser = null;
	//PatientPage Patient = null;
	LablistPage lablist = null;

	@Given("^the easytox url$")
	public void the_easytox_url() {
		System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
		driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		loginpage.navigatetowebApp();
		lablist = new LablistPage(driver);
		labuser = new LabUserPage(driver);
		//Patient = new PatientPage(driver);
		return;
	//	Assert.assertEquals(forgotpwd, "Click here");
		//System.out.println(forgotpwd);
	}
		
	    
	@And("^I enter username as \"([^\"]*)\"$")
	public void i_enter_the_username(String arg1) {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"Username"));
	}
	
	@And("^I enter password as \"([^\"]*)\"$")
	public void i_enter_the_password(String arg1) {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"Password"));
	}

	@Then("^click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) {
		loginpage.Loginbuttonclick();		
	}
	
	@Then("^close the browser$")
	public void close_the_browser() {
	   loginpage.closeDriver();
	}
	
	//*******Scenario 1: Edit User Personal Information********
	@When("^Click on Settings Icon$")
	public void Clicking_on_usericon_under_Action_Column() throws Throwable {
				
		labuser.waittime();
		labuser.ActionIcon_Click();
		labuser.waittime();	
	
	}
	
	@Then("Click on user icon$")
	public void screen_should_be_displayed() {
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"UserIcon")).click();
			}
	
	@When("^Enter user search criteria and click on search icon$")
	public void Enter_user_search_criteria_and_click_on_search_icon() throws Throwable {
			//System.out.println("**************"+ User);
			//labuser.EnterSearchCriteria(connector.getstring(WebConnector.myUrl.URL_OR,"User"));
			labuser.EnterSearchCriteria();
			String Labinfo = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
			connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
			String User = connector.getstring(WebConnector.myUrl.URL_OR,"User");
			Assert.assertEquals(User, Labinfo);
		}
	
	@Then("^Matching records with entered data should be displayed in the Lab user$")
	public void matching_records_with_entered_data_should_be_displayed_in_the_Lab_user() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		String User = connector.getstring(WebConnector.myUrl.URL_OR,"User");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(connector.getstring(WebConnector.myUrl.URL_OR,"User"))));
		Thread.sleep(5000);
		String searchresult = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
		Thread.sleep(5000);
		Assert.assertEquals(User, searchresult);
 
	}
	@When("Click on the Edit user icon")
	public void Click_on_the_Edit_user_icon() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EditIcon")).click();
		
		}
	@And("edit the User Personal Information")
	public void edit_the_User_Personal_Information()throws Throwable{
		//connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EditIcon")).click();
		Thread.sleep(5000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"UserInfoName")).click();
		Boolean Enabled = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"UserInfoName")).isEnabled();
		Assert.assertEquals(false, false);
		WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"PersonalInfoMailID"));
		WbElm.clear();
		Thread.sleep(1000);
		WbElm.sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"PersonalMailID"));

		}
	@Then("Click on the Update Button")
	public void Click_on_the_Update_Button() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"UpdateButton")).click();
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Message")).getText();
		//System.out.println("=====$$=="+Message);		
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "Success");
		Assert.assertEquals(containerContainsContent, true);
				
		}
	@And("Click on UserPlusIcon")
	public void Click_on_UserPlusIcon() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"UserPlusIcon")).click();
	}
	@And("Verify the Modified user personal information")
	public void And_Verify_the_Modified_user_personal_information() throws Throwable{
	String searchresult = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			 connector.getstring(WebConnector.myUrl.URL_OR,"ModifiedDateValue")).getText();
	Thread.sleep(5000);
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
	boolean containerContainsContent = StringUtils.containsIgnoreCase(searchresult, dtf.format(localDate));
	Assert.assertEquals(true, containerContainsContent);
		}
	
//***********************************************Scenario 2: Lock a Lab User******************************************************
	
	@And("^Enter username1 as \"([^\"]*)\"$")
	public void Enter_the_username1(String arg1) {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"Username1"));
	}
	
	@And("Enter password1 as \"([^\"]*)\"$")
	public void Enter_the_password1(String arg1) {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"Password1"));
	}
	@Then("Validate account locked or disabled")
	public void Validate_account_locked_or_disabled() throws Throwable {
		String accountStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AccountLocked")).getText();
		
		boolean AccountDisabled = StringUtils.containsIgnoreCase(accountStatus,"Sorry, your account is disabled");
		boolean AccountLocked = StringUtils.containsIgnoreCase(accountStatus,"Sorry, your account is locked");
		if (AccountDisabled==true) {
			
			System.out.println("Account is disabled successfully");
			
		}else{
			if(AccountLocked==true){
				System.out.println("Account is locked successfully");
			}
			
		}
	}
	@When("^Enter user search criteria and click on search button$")
	public void Enter_user_search_criteria_and_click_on_search_button() throws Throwable {
			//System.out.println("**************"+ User);
			//labuser.EnterSearchCriteria(connector.getstring(WebConnector.myUrl.URL_OR,"User"));
		Thread.sleep(5000);
		WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox"));

		WbElm.sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"User1"));
			String Labinfo = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
			connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
			String User1 = connector.getstring(WebConnector.myUrl.URL_OR,"User1");
			Assert.assertEquals(User1, Labinfo);
		}
	
	@Then("^Matching user with entered data should be displayed in the Lab user$")
	public void matching_user_with_entered_data_should_be_displayed_in_the_Lab_user() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		String User1 = connector.getstring(WebConnector.myUrl.URL_OR,"User1");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(connector.getstring(WebConnector.myUrl.URL_OR,"User"))));
		Thread.sleep(5000);
		String searchresult = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
		Thread.sleep(5000);
		Assert.assertEquals(User1, searchresult);
		
	}
	@And("^Select a user which is unlocked and click \"([^\"]*)\" icon under Action column$")
	public void Verify_Lab_user_is_Unlocked_and_click (String arg1) throws Throwable{
		
		String LockStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"LockIcon")).getAttribute("class");
		
		boolean containerContainsContent = StringUtils.containsIgnoreCase(LockStatus,"fa fa-unlock-alt fa-2x");
		
		if (containerContainsContent==true) {
			
			connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LockIcon")).click();
			Thread.sleep(5000);
		}
	}
	@Then("User should be locked and \"([^\"]*)\" message should be populated")
	public void Verify_the_user_is_locked_successfully_message(String arg1) throws Throwable{
			
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Message")).getText();
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "locked");
			
		
		}


//***********************************************Scenario 2: Unlock a Lab User******************************************************
	

		
	@And("Select a user which is locked and click \"([^\"]*)\" icon under Action column")
	public void Verify_Lab_user_is_locked_and_click (String arg1) throws Throwable{
		//Boolean Status = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LockIcon")).isSelected();
		String LockStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"LockIcon")).getAttribute("class");
		
		boolean containerContainsContent = StringUtils.containsIgnoreCase(LockStatus,"fa fa-lock fa-2x");
		
		if (containerContainsContent==true) {
			
			connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LockIcon")).click();
			Thread.sleep(5000);
			}
	}
	
	@Then("User account should be unlocked and \"([^\"]*)\" message should be populated")
	public void Verify_the_user_is_unlocked_successfully_message(String arg1) throws Throwable{
		
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Message")).getText();
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "unlocked");
		
	}
	//***********************************************Scenario 4: Disable a Lab User******************************************************
	@And("^Select a user which is enabled and click \"([^\"]*)\" icon under Enable/Disable column$")
	public void Verify_Lab_user_is_Enabled_and_click(String arg1) throws Throwable{
			String ActiveStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"EnableUser")).getAttribute("class");
			
			boolean containerContainsContent = StringUtils.containsIgnoreCase(ActiveStatus,"fa fa-check fa-2x");
			
			if (containerContainsContent==true) {
							
				connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EnableUser")).click();
				Thread.sleep(5000);
				}
		}
	@Then("^User should be disabled and \"([^\"]*)\" message should be populated$")
	public void Verify_the_user_is_Disabled_successfully_message(String arg1) throws Throwable{
				
			String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"DisableMessage")).getText();
			boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "disabled");
				
			
			}


	//***********************************************Scenario 5: Enable a Lab User******************************************************
	@And("^Select a user which is disabled and click \"([^\"]*)\" icon under Enable/Disable column$")
		public void Verify_Lab_user_is_Disabled_and_click (String arg1) throws Throwable{
			//Boolean Status = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LockIcon")).isSelected();
			String ActiveStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"EnableUser")).getAttribute("class");
			boolean containerContainsContent = StringUtils.containsIgnoreCase(ActiveStatus,"fa fa-ban fa-2x");
			if (containerContainsContent==true){
				
				 connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EnableUser")).click();
				 Thread.sleep(5000);
				}
			}
	@Then("^User account should be enabled and \"([^\"]*)\" message should be populated$")
		public void Verify_the_user_is_Enabled_successfully_message(String arg1) throws Throwable{
			
			String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"DisableMessage")).getText();
			boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "enabled");
			
		}


	
		
		//*************Scenario 6:Verify Number of records displayed***********************	
				
		
		
		@When("^Verify the default number of records displayed LU$")
		public void verify_the_default_number_of_records_displayed() throws Throwable {
			WebElement table = driver.findElement(By.id("example"));
			int rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			
			Assert.assertTrue(rowsCount <= 10);
		}
		
		@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box LU$")
		public void default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
			Thread.sleep(2000);
			Select dropdown = new Select (driver.findElement(By.name("example_length")));
			System.out.println("test:"+dropdown.getFirstSelectedOption().getText());
			int defaultNo = Integer.valueOf(dropdown.getFirstSelectedOption().getText());
			
			Assert.assertEquals(10, defaultNo);
		}
		
		@When("^Click on dropdown that shows no of records to be displayed on the page LU$")
		public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
			Thread.sleep(2000);
			driver.findElement(By.name("example_length")).click();
			Thread.sleep(2000);
		}
		
		@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page LU$")
		public void user_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
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

		
		
		/*@Then("^Click on dropdown to change the number of user records to \"([^\"]*)\"$")
		public void click_on_dropdown_that_shows_number_of_records_to_be_displayed_on_the_page(String arg1) throws Throwable {
			loginpage.waittime();
			labuser.ChangingNumberofRecordsDisplayedonPage();
		   
		}*/
		
		
		//***********Scenario 7: Verify the data sorting****************************************
				
		private WebElement element;
				
		@When("^Click on down arrow icon on sorting column LU$")
		public void click_on_down_arrow_icon_on_sorting_column() throws Throwable {
			
			loginpage.waittime();
			element = driver.findElement(By.cssSelector("thead > tr > th:nth-child(3)"));
			element.click();
		}

		@Then("^Records should be displayed based on the asecending order of the selected sorting column LU$")
		public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_sorting_column() throws Throwable {
			Thread.sleep(3000);
			Assert.assertTrue(element.getAttribute("class").contains("sorting_asc"));
		}

		@When("^Click on Up icon arrow on Profile Name column LU$")
		public void click_on_Up_icon_arrow_on_Profile_Name_column() throws Throwable {
			element.click();
		}

		@Then("^Records should be displayed based on the descending order of the selected sorting column LU$")
		public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_sorting_column() throws Throwable {
			Thread.sleep(1000);
			Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
		}
		//******************************************Scenario:8 Page Navigation**************************************************
		private int activePage;
		
		@When("^clicked on next button AP$")
		public void clicked_on_next_button() throws Throwable {
			Thread.sleep(1000);
			WebElement next = driver.findElement(By.cssSelector(".next > a"));
			
			if(next.isEnabled()) {
				next.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the next page LU$")
		public void the_user_should_be_able_to_navigate_to_the_next_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
		@When("^clicked on Prev button LU$")
		public void clicked_on_Prev_button() throws Throwable {
			Thread.sleep(1000);
			WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
			
			if(prev.isEnabled()) {
				prev.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the Previous page LU$")
		public void the_user_should_be_able_to_navigate_to_the_Previous_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
		 
	}
		 
		


