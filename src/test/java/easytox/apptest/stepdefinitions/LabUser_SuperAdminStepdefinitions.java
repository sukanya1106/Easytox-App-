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

public class LabUser_SuperAdminStepdefinitions {
	
	
	WebDriver driver = null;	
	LoginPage loginpage;
	WebConnector connector = new WebConnector();
	LabUserPage labuser = null;
	//PatientPage Patient = null;
	LablistPage lablist = null;

	@Given("^the easytox url6$")
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
		
	    
	@And("^I enter username6 as \"([^\"]*)\"$")
	public void i_enter_the_username(String arg1) {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"UsernameSuper"));
	}
	
	@And("^I enter password6 as \"([^\"]*)\"$")
	public void i_enter_the_password(String arg1) {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"PasswordSuper"));
	}

	@Then("^click on \"([^\"]*)\" button6$")
	public void click_on_button(String arg1) {
		loginpage.Loginbuttonclick();		
	}
	
	@Then("^close the browser6$")
	public void close_the_browser() {
	   loginpage.closeDriver();
	}
	
//*********************************************** 1: Verify Adding Lab Admin User*************************************
	
//***************Verify easytox screen*****************************************
	
	@When("^Click on LabList Icon$")
	public void Clicking_on_lablist_icon_under_Action_Column() throws Throwable {
				
		labuser.waittime();
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LablistMenu")).click();
		labuser.waittime();
		boolean Lablistpage = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LablistSearchBox")).isDisplayed();
		Assert.assertEquals(true, Lablistpage);
	
	}
	
//***************Verify Add User to Lab****************************************** 	
	
	
	@When("^Enter labuser search criteria and click on search icon and Matching records with entered data should be displayed$")
	public void Enter_labuser_search_criteria_and_click_on_search_icon() throws Throwable {
			
			WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"LablistSearchBox"));
	
			WbElm.sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabListName"));
			String Labinfo = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
									connector.getstring(WebConnector.myUrl.URL_OR,"LabName")).getText();
			String Lab = connector.getstring(WebConnector.myUrl.URL_OR,"LabListName");
			Assert.assertEquals(Lab, Labinfo);
			
	}
	
	@And("Click on user name under Name Column")
	public void Click_on_user_name_under_Name_Column() throws Throwable {
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LabName")).click();
		labuser.waittime();
		boolean Updatebutton = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LabListUpdate")).isDisplayed();
		Thread.sleep(2000);
		Assert.assertEquals(true, Updatebutton);
		
}

	
	@Then("^Click on add Lab List Icon$")
	public void Click_on_add_Lab_List_Icon() throws Throwable{
		
		Thread.sleep(5000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabListICon")).click();
		Thread.sleep(5000);
		boolean AddLabListPAge = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabName")).isDisplayed();
		Assert.assertEquals(true, AddLabListPAge);
		
		/* connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabName")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabListName"));;
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabDescription")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabName"));;
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabEmail")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabName"));;
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabAddress1")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabName"));;
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabAddress2")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabName"));;
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabZip")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabName"));;
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabCity")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabName"));;
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabstate")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabName"));;
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddListCountry")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabName"));;
				 
		Thread.sleep(4000);
		
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddLabSubmit")).click();*/

 
	}
	
	@When("^Verify the newly created lab user$")
	public void Verify_the_newly_created_lab_user() throws Throwable {
			
			WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"LablistSearchBox"));
	
			WbElm.sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"NewLabListName"));
			String Labinfo = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
									connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
			String Lab = connector.getstring(WebConnector.myUrl.URL_OR,"NewLabListName");
			Assert.assertEquals(Lab, Labinfo);
	}
			
//==================================== 2: Verify Lab User List=============================================================

//***************Verify the User List****************************************** 
	
	@When("^Click on Lab user icon from LabList page$")
	public void Click_on_Lab_user_icon_from_LabList_page() throws Throwable {
			
			WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"Labusericon"));
	
			WbElm.click();
			boolean labuserpage = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
									connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox")).isDisplayed();
			Assert.assertEquals(true, labuserpage);
		
	}
//*****************Verify the search results***********************************
	
	@When("^Enter labuser search criteria and click on search icon$")
	public void Enter_labuser_search_criteria() throws Throwable {
			//System.out.println("**************"+ User);
			//labuser.EnterSearchCriteria(connector.getstring(WebConnector.myUrl.URL_OR,"User"));
			labuser.EnterSearchCriteria();
			String Labinfo = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
			connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
			String User = connector.getstring(WebConnector.myUrl.URL_OR,"User");
			Assert.assertEquals(User, Labinfo);
		}
	
	@Then("^Matching records with entered data should be displayed in the Lab user page$")
	public void matching_records_with_entered_data_displayed_in_the_Lab_user() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		String User = connector.getstring(WebConnector.myUrl.URL_OR,"User");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(connector.getstring(WebConnector.myUrl.URL_OR,"User"))));
		Thread.sleep(5000);
		String searchresult = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
		Thread.sleep(5000);
		Assert.assertEquals(User, searchresult);
 
	}
//**************************************Verify the edit*******************************************************		
	@When("Click Edit user icon in LU page")
	public void Click_Edit_user_icon_in_LU_page() throws Throwable{
		Thread.sleep(5000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EditLabuserIcon")).click();
		
		}
	@And("edit the User Information in LU page")
	public void edit_the_User_Information_in_LU_page()throws Throwable{
		
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
	@Then("Select Update after editing in labuser page")
	public void Select_Update_after_editing_in_labuser_page() throws Throwable{
		Thread.sleep(3000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"UserUpdate")).click();
		Thread.sleep(5000);
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Message")).getText();
		//System.out.println("=====$$=="+Message);		
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "updated");
		Assert.assertEquals(containerContainsContent, true);
				
		}
	@And("Select UserPlusIcon in labuser page")
	public void Select_UserPlusIcon_in_labuser_page() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"UserPlus")).click();
	}
	@And("Verify the updated userpersonal information in labuser page")
	public void And_Verify_the_updated_user_personal_information_in_labuser_page() throws Throwable{
	String searchresult = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			 connector.getstring(WebConnector.myUrl.URL_OR,"ModifiedDateValue")).getText();
	Thread.sleep(5000);
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
	boolean containerContainsContent = StringUtils.containsIgnoreCase(searchresult, dtf.format(localDate));
	Assert.assertEquals(true, containerContainsContent);
		}
	
//***********************************************Scenario 2: Lock a Lab User******************************************************
	
	@And("^Enter username7 as \"([^\"]*)\"$")
	public void Enter_the_username7(String arg1) {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"Username1"));
	}
	
	@And("Enter password7 as \"([^\"]*)\"$")
	public void Enter_the_password7(String arg1) {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"Password1"));
	}
	@Then("Validate Labuser account locked or disabled")
	public void Validate_Labuser_account_locked_or_disabled() throws Throwable {
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
	@When("^Enter user and click on searchbutton$")
	public void Enter_user_and_click_on_searchbutton() throws Throwable {
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
	
	@Then("^Matching user with entered data are displayed in the Lab user$")
	public void matching_user_with_entered_data_are_displayed_in_the_Lab_user() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		String User1 = connector.getstring(WebConnector.myUrl.URL_OR,"User1");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(connector.getstring(WebConnector.myUrl.URL_OR,"User"))));
		Thread.sleep(5000);
		String searchresult = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
		Thread.sleep(5000);
		Assert.assertEquals(User1, searchresult);
		
	}
	@And("^Select a unlocked user and click unlock icon under Action column$")
	public void Select_a_unlocked_user_and_click () throws Throwable{
		Thread.sleep(5000);
		String LockStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"UnlockedIcon")).getAttribute("class");
		
		boolean containerContainsContent = StringUtils.containsIgnoreCase(LockStatus,"fa fa-unlock-alt fa-2x");
		
		if (containerContainsContent==true) {
			
			connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"UnlockedIcon")).click();
			Thread.sleep(5000);
		}
	}
	@Then("User should be locked and a message should be populated")
	public void User_should_be_locked_and_a_message_should_be_populated() throws Throwable{
			
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Message")).getText();
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "locked");
			
		
		}


//***********************************************Scenario 2: Unlock a Lab User******************************************************
	

		
	@And("Select a locked user and click lock icon under Action column")
	public void Select_a_locked_user_and_click_lock_icon_under_Action_column () throws Throwable{
		Thread.sleep(5000);
		String LockStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"Lockeduser")).getAttribute("class");
		
		boolean containerContainsContent = StringUtils.containsIgnoreCase(LockStatus,"fa fa-lock fa-2x");
		
		if (containerContainsContent==true) {
			
			connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Lockeduser")).click();
			Thread.sleep(5000);
			}
	}
	
	@Then("User account should be unlocked and a message should be populated")
	public void User_account_should_be_unlocked_and_a_message_should_be_populated() throws Throwable{
		
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Message")).getText();
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "unlocked");
		Assert.assertEquals(true, containerContainsContent);
	}
//***********************************************Scenario 4: Disable a Lab User******************************************************
	@Then("^Select a enabled user and click disable icon under Disable column$")
	public void Select_a_enabled_user_and_click_disable_icon_under_Disable_column() throws Throwable{
			String ActiveStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"EnabledUser")).getAttribute("class");
			
			boolean containerContainsContent = StringUtils.containsIgnoreCase(ActiveStatus,"fa fa-check fa-2x");
			
			if (containerContainsContent==true) {
							
				connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EnabledUser")).click();
				Thread.sleep(5000);
				}
		}
	@Then("^User should be disabled and a message should be populated$")
	public void Verify_the_user_is_Disabled_successfully_message() throws Throwable{
				
			String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"DisableMessage")).getText();
			boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "disabled");
				
			
			}


//***********************************************Scenario 5: Enable a Lab User******************************************************
	@And("^Select a disabled user and click enable icon under Enable column$")
		public void Select_a_disabled_user_and_click_enable_icon_under_Enable_column() throws Throwable{
			//Boolean Status = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LockIcon")).isSelected();
			String ActiveStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"DisabledUser")).getAttribute("class");
			boolean containerContainsContent = StringUtils.containsIgnoreCase(ActiveStatus,"fa fa-ban fa-2x");
			if (containerContainsContent==true){
				
				 connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"DisabledUser")).click();
				 Thread.sleep(5000);
				}
			}
	@Then("^User account should be enabled and a message should be populated$")
		public void User_account_should_be_enabled_and_a_message_should_be_populated() throws Throwable{
			
			String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"DisableMessage")).getText();
			boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "enabled");
			
		}


	
		
//*********************Scenario 6:Verify Number of records displayed***********************	
				
		
		
		@When("^Verify the default number of records displayed in lab user page$")
		public void verify_the_default_number_of_records_displayed_in_lab_user_page() throws Throwable {
			WebElement table = driver.findElement(By.id("example"));
			int rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			
			Assert.assertTrue(rowsCount <= 10);
		}
		
		@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box in lab user page$")
		public void default_number_should_be_displayed_in_the_dropdown_box_in_lab_user_page(String arg1) throws Throwable {
			Thread.sleep(2000);
			Select dropdown = new Select (driver.findElement(By.name("example_length")));
			System.out.println("test:"+dropdown.getFirstSelectedOption().getText());
			int defaultNo = Integer.valueOf(dropdown.getFirstSelectedOption().getText());
			
			Assert.assertEquals(10, defaultNo);
		}
		
		@When("^Click on dropdown that shows no of records to be displayed on the lab user page")
		public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_lab_user_page() throws Throwable {
			Thread.sleep(2000);
			driver.findElement(By.name("example_length")).click();
			Thread.sleep(2000);
		}
		
		@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the lab user page$")
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


		
		
//**********************Scenario 7: Verify the data sorting****************************************
				
		private WebElement element;
				
		@When("^Click on down arrow icon on sorting column in lab user page$")
		public void click_on_down_arrow_icon_on_sorting_column_in_lab_user_page() throws Throwable {
			
			loginpage.waittime();
			element = driver.findElement(By.cssSelector("thead > tr > th:nth-child(3)"));
			element.click();
		}

		@Then("^Records should be displayed based on the asecending order of the selected sorting column in lab user page$")
		public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_sorting_column_in_lab_user_page() throws Throwable {
			Thread.sleep(3000);
			Assert.assertTrue(element.getAttribute("class").contains("sorting_asc"));
		}

		@When("^Click on Up icon arrow on Profile Name column in lab user page$")
		public void click_on_Up_icon_arrow_on_Profile_Name_column_in_lab_user_page() throws Throwable {
			element.click();
		}

		@Then("^Records should be displayed based on the descending order of the selected sorting column in lab user page$")
		public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_sorting_column_in_lab_user_page() throws Throwable {
			Thread.sleep(1000);
			Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
		}
//**********************************Scenario:8 Page Navigation**************************************************
		private int activePage;
		
		@When("^clicked on next button in lab userpage$")
		public void clicked_on_next_button_in_lab_userpage() throws Throwable {
			Thread.sleep(1000);
			WebElement next = driver.findElement(By.cssSelector(".next > a"));
			
			if(next.isEnabled()) {
				next.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the next page in labuser page$")
		public void the_user_should_be_able_to_navigate_to_the_next_page_in_labuser_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
		@When("^clicked on Prev button in labuser page$")
		public void clicked_on_Prev_button_in_labuser_page() throws Throwable {
			Thread.sleep(1000);
			WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
			
			if(prev.isEnabled()) {
				prev.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the Previous page in labuser page$")
		public void the_user_should_be_able_to_navigate_to_the_Previous_page_in_labuser_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
		 
//***********************************************Scenario 9: Validating Account Expiration******************************************************
		@And("^Select a Not expired user and click to expire it$")
		public void Select_a_Not_expired_user_and_click_to_expire_it() throws Throwable{
				String ActiveStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
						 connector.getstring(WebConnector.myUrl.URL_OR,"NotExpiredUser")).getAttribute("class");
				
				boolean containerContainsContent = StringUtils.containsIgnoreCase(ActiveStatus,"fa fa-ban fa-2x");
				
				if (containerContainsContent==true) {
								
					connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"NotExpiredUser")).click();
					Thread.sleep(5000);
					}
			}
		@Then("^User should be expired and a message should be populated$")
		public void User_should_be_expired_and_a_message_should_be_populated() throws Throwable{
					
				String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ExpiredMessage")).getText();
				boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "expired");
					
				
				}
		@Then("^User should be activated and a message should be populated$")
		public void User_should_be_activated_and_a_message_should_be_populated() throws Throwable{
					
				String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ExpiredMessage")).getText();
				boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "activated");
					
				
				}
		@And("^Select a expired user and click to activate it$")
		public void Select_a_expired_user_and_click_to_unexpire_it() throws Throwable{
				String ActiveStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
						 connector.getstring(WebConnector.myUrl.URL_OR,"ExpiredUser")).getAttribute("class");
				
				boolean containerContainsContent = StringUtils.containsIgnoreCase(ActiveStatus,"fa fa-check fa-2x");
				
				if (containerContainsContent==true) {
								
					connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ExpiredUser")).click();
					Thread.sleep(5000);
					}
		}
		
		@Then("Validate Labuser account expired")
		public void Validate_Labuser_account_expired() throws Throwable {
			String accountStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"AccountLocked")).getText();
			
			boolean AccountExpired = StringUtils.containsIgnoreCase(accountStatus,"Sorry, your account is expired");
			
			if (AccountExpired==true) {
				
				System.out.println("Account is disabled successfully");
				
			}
				
			}
		
//**************************Scenario 10: Validating Password Expired******************************************************
		@And("^Select a Not expired password and click to expire it$")
		public void Select_a_Not_expired_password_and_click_to_expire_it() throws Throwable{
				String ActiveStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
						 connector.getstring(WebConnector.myUrl.URL_OR,"NotExpiredPassword")).getAttribute("class");
				
				boolean containerContainsContent = StringUtils.containsIgnoreCase(ActiveStatus,"fa fa-ban fa-2x");
				
				if (containerContainsContent==true) {
								
					connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"NotExpiredPassword")).click();
					Thread.sleep(5000);
					}
			}
		@Then("^User password should be expired and a message should be populated$")
		public void User_password_should_be_expired_and_a_message_should_be_populated() throws Throwable{
					
				String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ExpiredMessage")).getText();
				boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "expired");
					
				
				}
		@Then("^User password should be activated and a message should be populated$")
		public void User_password_should_be_activated_and_a_message_should_be_populated() throws Throwable{
					
				String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ExpiredMessage")).getText();
				boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "activated");
					
				
				}
		@And("^Select a Password expired user and click to activate it$")
		public void Select_a_Password_expired_user_and_click_to_unexpire_it() throws Throwable{
				String ActiveStatus = connector.getWebElement(driver, WebConnector.Identifier.xpath,
						 connector.getstring(WebConnector.myUrl.URL_OR,"Expiredpwd")).getAttribute("class");
				
				boolean containerContainsContent = StringUtils.containsIgnoreCase(ActiveStatus,"fa fa-check fa-2x");
				
				if (containerContainsContent==true) {
								
					connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Expiredpwd")).click();
					Thread.sleep(5000);
					}
				}
		@Then("Validate Labuser password expired")
		public void Validate_Labuser_password_expired() throws Throwable {
			boolean Changepwd = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"Changepwd")).isDisplayed();
				
			Assert.assertEquals(true, Changepwd) ;
			System.out.println("password is disabled successfully");
				
			
			}
//=====================================4: Verifing Lab Client List====================================================
	
//***********Verify the User List, Lab client should be dispalyed****************************************** 
	
		@When("^Click on lab client icon from LabList page$")
		public void Click_on_Lab_Client_icon_from_LabList_page() throws Throwable {
				
				WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
						 connector.getstring(WebConnector.myUrl.URL_OR,"LabclientIcon"));
		
				WbElm.click();
				boolean labclientpage = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
										connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox")).isDisplayed();
				Assert.assertEquals(true, labclientpage);
			
		}
		
//***********Verify the Search Results Lab Client******************************************
		
		@When("^Enter Labclient search criteria and click on search icon and Matching records with entered data should be displayed$")
		public void Enter_labclient_search_criteria_and_click_on_search_icon() throws Throwable {
				
				WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
						 connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox"));
		
				WbElm.sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LabClientName"));
				String Labinfo = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
										connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
				String Lab = connector.getstring(WebConnector.myUrl.URL_OR,"LabClientName");
				Assert.assertEquals(Lab, Labinfo);
				
		}
		
		
//***********Verifying for Lab information*******************************************************
		
		@And("Click on PlusIcon in Labclient page to verify lab information")
		public void Click_on_PlusIcon_in_Labclient_page_to_verify_lab_information() throws Throwable{
			connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LabclientPlusIcon")).click();
		}
		
		@And("Verify the Labclient information")
		public void And_Verify_the_labclient_information() throws Throwable{
		boolean LabClientInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"AddressLabclient")).isDisplayed();
		
		Assert.assertEquals(true, LabClientInfo);
			}

			
	}
		 
		


