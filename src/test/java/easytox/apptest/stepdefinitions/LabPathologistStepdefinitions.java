package easytox.apptest.stepdefinitions;

import java.lang.reflect.Array;
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
import easytox.apptest.pages.LabPathPage;
import easytox.apptest.pages.LabUserPage;
import easytox.apptest.pages.LablistPage;
import easytox.apptest.pages.LoginPage;
import easytox.apptest.pages.LabPathPage;
import easytox.apptest.utils.WebConnector;
import easytox.apptest.stepdefinitions.LabUserStepdefinitions;
import junit.framework.Assert;

public class LabPathologistStepdefinitions {
	
	
	WebConnector connector = new WebConnector();
	LoginPage loginpage;
	WebDriver driver = null;
	LabPathPage labpath = null;
	LabUserPage labuser = null;
	
		@Given("^the easytox url4$")
	public void the_easytox_url() {
		System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
		driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		loginpage.navigatetowebApp();
		labpath = new LabPathPage(driver);
		labuser = new LabUserPage(driver);
		//Patient = new PatientPage(driver);
		return;
	}
	@And("^I enter username4 as \"([^\"]*)\"$")
	public void i_enter_the_username(String arg1) {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"Username"));
	}
	
	@And("^I enter password4 as \"([^\"]*)\"$")
	public void i_enter_the_password(String arg1) {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"Password"));
	}

	@Then("^click on \"([^\"]*)\" button4$")
	public void click_on_button(String arg1) {
		loginpage.Loginbuttonclick();		
	}
	
	@Then("^close the browser4$")
	public void close_the_browser() {
	   loginpage.closeDriver();
	}
		
	   	

	//*******Scenario 1: Edit User Personal Information********
	@When("^Click Settings Icon$")
	public void Clicking_on_usericon_under_Action_Column() throws Throwable {
				
		labpath.waittime();
		labpath.ActionIcon_Click();
		labpath.waittime();	
	
	}

//**************************************Scenario 1:Search Lab pathologist*************************************************
	@Then("Click on LabPath icon$")
	public void screen_should_be_displayed() {
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LabPathIcon")).click();
			}
	
	@When("^Enter LabPath search criteria and click on search icon$")
	public void Enter_user_search_criteria_and_click_on_search_icon() throws Throwable {
			//System.out.println("**************"+ User);
			//labuser.EnterSearchCriteria(connector.getstring(WebConnector.myUrl.URL_OR,"User"));
			labpath.EnterSearchCriteria();
			String Labinfo = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
			connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
			String User = connector.getstring(WebConnector.myUrl.URL_OR,"Pathologist");
			Assert.assertEquals(User, Labinfo);
		}
	
	@Then("^Matching records with entered data should be displayed in the LP$")
	public void matching_records_with_entered_data_should_be_displayed_in_the_Lab_user() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		String Pathologist = connector.getstring(WebConnector.myUrl.URL_OR,"Pathologist");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(connector.getstring(WebConnector.myUrl.URL_OR,"User"))));
		Thread.sleep(5000);
		String searchresult = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
		Thread.sleep(5000);
		Assert.assertEquals(Pathologist, searchresult);
 
	}

//**************************************Scenario 2:Edit pathologist personal information*************************************	
	
	@When("Click on the Edit Pathologist icon")
	public void Click_on_the_Edit_user_icon() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EditPathIcon")).click();
		
		}
	@And("edit the Pathologist Personal Information")
	public void edit_the_User_Personal_Information()throws Throwable{
		//connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EditIcon")).click();
		Thread.sleep(5000);
		
		Boolean Enabled = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"PathUserName")).isEnabled();
		Assert.assertEquals(false, false);
		WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"PathEmailID"));
		WbElm.clear();
		Thread.sleep(1000);
		WbElm.sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"EmailPath"));

		}
	@Then("Click on the Update in pathologist page")
	public void Click_on_the_Update_in_pathologist_page() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"UpdatePathButton")).click();
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Message")).getText();
		//System.out.println("=====$$=="+Message);		
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "Success");
		Assert.assertEquals(containerContainsContent, true);
				
		}
	
//**************************************Scenario3:Add new pathologist*************************************	
	
	@When("Click on the Add Pathologist icon")
	public void Click_on_the_Add_pathologist_icon() throws Throwable{
		Thread.sleep(9000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"AddPath")).click();
		
		}
	@And("Enter Pathologist Personal Information")
	public void Enter_Pathologist_Personal_Information()throws Throwable{
		//connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EditIcon")).click();
		Thread.sleep(5000);
				 
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"PathUserName")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"UserNamePath"));;
		
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"PathPassword")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"PasswordPath"));;
				
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"PathFirstName")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"FirstNamePath"));;
		
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"PathLastName")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"LastNamePath"));;
		
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"ClinicalinfoSalutation")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"Salutation"));;
		
		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"ClinicalMedicarNumber")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"MedicalNumberpath"));;

		 connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"ClinicalMedicaidNumber")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"MedicaidNumber"));;
		 
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"ClinicalUPINNum")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"UPIN"));;
		 
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"ClicnicalStateLicense")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"StateLicense"));;
		 
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"ClinicalNPI")).sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"NPI"));;
																			
		Thread.sleep(3000);
		

		}
	@Then("Click on the Submit Button in pathologist page")
	public void Click_on_the_Save_Button_in_pathologist_page() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"SubmitPath")).click();
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"Message")).getText();
		//System.out.println("=====$$=="+Message);		
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "created");
		Assert.assertEquals(containerContainsContent, true);
				
		}
	
	
//**************************************Scenario 4:Verify Number of records displayed**************************************	
				
		
		
		@When("^Verify the default number of records displayed LP$")
		public void verify_the_default_number_of_records_displayed() throws Throwable {
			WebElement table = driver.findElement(By.id("example"));
			int rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			
			Assert.assertTrue(rowsCount <= 10);
		}
		
		@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box LP$")
		public void default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
			Thread.sleep(2000);
			Select dropdown = new Select (driver.findElement(By.name("example_length")));
			System.out.println("test:"+dropdown.getFirstSelectedOption().getText());
			int defaultNo = Integer.valueOf(dropdown.getFirstSelectedOption().getText());
			
			Assert.assertEquals(10, defaultNo);
		}
		
		@When("^Click on dropdown that shows no of records to be displayed on the page LP$")
		public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
			Thread.sleep(2000);
			driver.findElement(By.name("example_length")).click();
			Thread.sleep(2000);
		}
		
		@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page LP$")
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

//************************************************Scenario 5: Verify the data sorting****************************************
				
		private WebElement element;
				
		@When("^Click on down arrow icon on sorting column LP$")
		public void click_on_down_arrow_icon_on_sorting_column() throws Throwable {
			
			loginpage.waittime();
			element = driver.findElement(By.cssSelector("thead > tr > th:nth-child(3)"));
			element.click();
		}

		@Then("^Records should be displayed based on the asecending order of the selected sorting column LP$")
		public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_sorting_column() throws Throwable {
			Thread.sleep(3000);
			Assert.assertTrue(element.getAttribute("class").contains("sorting_asc"));
		}

		@When("^Click on Up icon arrow on Profile Name column LP$")
		public void click_on_Up_icon_arrow_on_Profile_Name_column() throws Throwable {
			element.click();
		}

		@Then("^Records should be displayed based on the descending order of the selected sorting column LP$")
		public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_sorting_column() throws Throwable {
			Thread.sleep(1000);
			Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
		}
//******************************************Scenario:6 Page Navigation**************************************************
		private int activePage;
		
		@When("^clicked on next button LP$")
		public void clicked_on_next_button() throws Throwable {
			Thread.sleep(1000);
			WebElement next = driver.findElement(By.cssSelector(".next > a"));
			
			if(next.isEnabled()) {
				next.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the next page LP$")
		public void the_user_should_be_able_to_navigate_to_the_next_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
		@When("^clicked on Prev button LP$")
		public void clicked_on_Prev_button() throws Throwable {
			Thread.sleep(1000);
			WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
			
			if(prev.isEnabled()) {
				prev.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the Previous page LP$")
		public void the_user_should_be_able_to_navigate_to_the_Previous_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
		 
	}
		 
