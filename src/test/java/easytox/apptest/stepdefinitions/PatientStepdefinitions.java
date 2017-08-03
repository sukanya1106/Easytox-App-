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
import easytox.apptest.pages.LabUserPage;
import easytox.apptest.pages.LablistPage;
import easytox.apptest.pages.LoginPage;
import easytox.apptest.utils.WebConnector;
import easytox.apptest.stepdefinitions.LabUserStepdefinitions;
import junit.framework.Assert;

public class PatientStepdefinitions extends AbstractPage {
	
	
	WebConnector connector = new WebConnector();
	LoginPage loginpage;
	WebDriver driver = null;
	
	public PatientStepdefinitions(WebDriver driver) {
		super(driver);
		
	}

	@Given("^the easytox url2$")
	public void the_easytox_url() {
		System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
		driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		loginpage.navigatetowebApp();
		
		//Patient = new PatientPage(driver);
		return;
	}
	@And("^I enter username2 as \"([^\"]*)\"$")
	public void i_enter_the_username(String arg1) {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"Username"));
	}
	
	@And("^I enter password2 as \"([^\"]*)\"$")
	public void i_enter_the_password(String arg1) {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"Password"));
	}

	@Then("^click on \"([^\"]*)\" button2$")
	public void click_on_button(String arg1) {
		loginpage.Loginbuttonclick();		
	}
	
	@Then("^close the browser2$")
	public void close_the_browser() {
	   loginpage.closeDriver();
	}
		
	   	//WebDriver driver = PatientStepdefinitions extends AbstractPage ();	
	
//****************************************Scenario 1:Navigate to patient page*****************************************************
	@When("^Click on Patient Icon$")
	public void Click_on_Patient_Icon() throws Throwable {
		
		System.out.println("hi everybody i am here");
		Thread.sleep(7000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"LibraryIcon")).click();
		Thread.sleep(4000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"PatientIcon")).click();
	}
	
//****************************************Scenario 2:Verify the Search Results*****************************************************
		
	@When("^Enter Patient search criteria and Matching records with entered data should be displayed in the Patient page$")
	public void Enter_Patient_search_criteria_and_Matching_records_with_entered_data_should_be_displayed_in_the_Patient_page() throws Throwable {
		
		String PatientName = connector.getstring(WebConnector.myUrl.URL_OR,"PatientName");
		
		  int i ;
		  String[] PatientName1 = PatientName.split(";");
		  int Size = PatientName1.length;
		  for(i=0;i<Size;i++){
		
		  System.out.println(PatientName1[i]);
		  //connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox")).click();
		  Thread.sleep(4000);
		  connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox")).clear();
		  WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		  connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox"));

		  WbElm.sendKeys(PatientName1[i]);
		  Thread.sleep(4000);
		  String Patient1 = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
		  connector.getstring(WebConnector.myUrl.URL_OR,"UserName_Validation")).getText();
			
		  Assert.assertEquals(PatientName1[i], Patient1);
		  
		  }
		  
		}
	
//*******************************************Scenario 3:Edit patient information********************************************
	
	@When("Click on the Edit Patient icon")
	public void Click_on_the_Edit_Patient_icon() throws Throwable{
		Thread.sleep(7000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"EditPatient")).click();
		
		}
	@And("edit the Patient Personal Information")
	public void edit_the_Patient_Personal_Information()throws Throwable{
		Thread.sleep(5000);
		WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"PatientAddress"));
		WbElm.clear();
		Thread.sleep(1000); 
		WbElm.sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"Address"));

		}
	@Then("Click on the Patient Update Button")
	public void Click_on_the_Patient_Update_Button() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"PatientInfoUpdate")).click();
		String Message = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"SuccessMessage")).getText();
				
		boolean containerContainsContent = StringUtils.containsIgnoreCase(Message, "Success");
		Assert.assertEquals(containerContainsContent, true);
				
		}
	
	
//*************************************Scenario 4:Verify Number of records displayed***************************************
				
		
		
		@When("^Verify the default number of Patient records displayed$")
		public void verify_the_default_number_of_records_displayed() throws Throwable {
			WebElement table = driver.findElement(By.id("example"));
			int rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			
			Assert.assertTrue(rowsCount <= 10);
		}
		
		@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box on the page Patient$")
		public void default_number_should_be_displayed_in_the_dropdown_box_on_the_page_Patient(String arg1) throws Throwable {
			Thread.sleep(2000);
			Select dropdown = new Select (driver.findElement(By.name("example_length")));
			System.out.println("Patient:"+dropdown.getFirstSelectedOption().getText());
			int defaultNo = Integer.valueOf(dropdown.getFirstSelectedOption().getText());
			
			Assert.assertEquals(10, defaultNo);
		}
		
		@When("^Click on dropdown that shows no of records to be displayed on the page Patient$")
		public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page_Patient() throws Throwable {
			Thread.sleep(2000);
			driver.findElement(By.name("example_length")).click();
			Thread.sleep(2000);
		}
		
		@Then("^User should be able to view and select the options from the list and the corresponding number of Patient records should be displayed on the page Patient$")
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

	
//********************************************Scenario 5: Verify the data sorting****************************************
				
		private WebElement element;
				
		@When("^Click on down arrow icon on sorting column on page patient$")
		public void click_on_down_arrow_icon_on_sorting_column() throws Throwable {
			
			Thread.sleep(3000);
			element = driver.findElement(By.xpath("//*[@id='example']/thead/tr/th[3]"));
			element.click();
		}

		@Then("^Records should be displayed based on the ascending order of the selected sorting column on page patient$")
		public void records_should_be_displayed_based_on_the_ascending_order_of_the_selected_sorting_column() throws Throwable {
			Thread.sleep(3000);
			Assert.assertTrue(element.getAttribute("class").contains("sorting_asc"));
		}

		@When("^Click on Up icon arrow on Profile Name column on page patient$")
		public void click_on_Up_icon_arrow_on_Profile_Name_column() throws Throwable {
			element.click();
		}

		@Then("^Records should be displayed based on the descending order of the selected sorting column on page patient$")
		public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_sorting_column() throws Throwable {
			Thread.sleep(1000);
			Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
		}
//******************************************Scenario:6 Page Navigation**************************************************
		private int activePage;
		
		@When("^clicked on next button on page patient$")
		public void clicked_on_next_button() throws Throwable {
			Thread.sleep(1000);
			WebElement next = driver.findElement(By.cssSelector(".next > a"));
			
			if(next.isEnabled()) {
				next.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the next page on page patient$")
		public void the_user_should_be_able_to_navigate_to_the_next_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
		@When("^clicked on Prev button$")
		public void clicked_on_Prev_button() throws Throwable {
			Thread.sleep(1000);
			WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
			
			if(prev.isEnabled()) {
				prev.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the Previous page on page patient$")
		public void the_user_should_be_able_to_navigate_to_the_Previous_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
//*******************************************Scenario 7:Patient Insurance details information********************************************
		
		@When("Click on the Insurance Detail icon")
		public void Click_on_the_Insurane_Detail_icon() throws Throwable{
			connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"InsuranceDetail")).click();
			
			}
		@And("Verify Insurance Detail screen is popped")
		public void Verify_Insurance_Detail_screen_is_pop_uped()throws Throwable{
			Thread.sleep(5000);
			
			WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"Insurancescreen"));
			Thread.sleep(1000);
			boolean Status = WbElm.isDisplayed();
			
			Assert.assertTrue(Status);
			
			

			}
//*******************************************Scenario 8:Adding a new patient********************************************
		@When("^Click on the Add New Patient icon$")
		public void Click_on_the_Add_New_Patient_icon() throws Throwable{
			Thread.sleep(5000);
			connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"AddNewPatient")).click();
			
			}
		@Then("^Add Patient screen should be displayed$")
		public void Add_Patient_screen_should_be_displayed()throws Throwable{
			Thread.sleep(5000);
			
			WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
					 connector.getstring(WebConnector.myUrl.URL_OR,"PatientFirstName"));
			Thread.sleep(1000);
			boolean Status = WbElm.isDisplayed();
			
			Assert.assertTrue(Status);
			

			}
//***********************************************Scenario: Verifying for the patient information*******************************
		@And("Click on PatientPlusIcon")
		public void Click_on_UserPlusIcon() throws Throwable{
			Thread.sleep(5000);
			connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"PatientPlusIcon")).click();
		}
		
		@Then("Verify the patient information is displayed")
		public void Verify_the_patient_Information_is_displayed() throws Throwable{
			boolean status = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"PatientInformation")).isDisplayed();
			Assert.assertTrue(status);
		}
		
}
		 
		


