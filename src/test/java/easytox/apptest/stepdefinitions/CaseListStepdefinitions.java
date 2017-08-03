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

public class CaseListStepdefinitions {
	
	
	WebDriver driver = null;	
	LoginPage loginpage;
	WebConnector connector = new WebConnector();
	

	@Given("^the easytox url5$")
	public void the_easytox_url() {
		System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
		driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		loginpage.navigatetowebApp();
		
		//Patient = new PatientPage(driver);
		return;
	//	Assert.assertEquals(forgotpwd, "Click here");
		//System.out.println(forgotpwd);
	}
		
	    
	@And("^I enter username5 as \"([^\"]*)\"$")
	public void i_enter_the_username(String arg1) {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"Username"));
	}
	
	@And("^I enter password5 as \"([^\"]*)\"$")
	public void i_enter_the_password(String arg1) {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"Password"));
	}

	@Then("^click on \"([^\"]*)\" button5$")
	public void click_on_button(String arg1) {
		loginpage.Loginbuttonclick();		
	}
	
	@Then("^close the browser5$")
	public void close_the_browser() {
	   loginpage.closeDriver();
	}
//****************************************Scenario 1:Verify the Search Results*****************************************************
	
		@When("^Enter CaseList search criteria and Matching records with entered data should be displayed in the CaseList page$")
		public void Enter_CaseList_search_criteria_and_Matching_records_with_entered_data_should_be_displayed_in_the_CaseList_page() throws Throwable {
			
			String CaseName = connector.getstring(WebConnector.myUrl.URL_OR,"Case");
			
			  int i ;
			  String[] CaseName1 = CaseName.split(";");
			  int Size = CaseName1.length;
			  for(i=0;i<Size;i++){
			
				  System.out.println(CaseName1[i]);
				  
				  Thread.sleep(4000);
				  connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"SearchOrder")).clear();
				  WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				  connector.getstring(WebConnector.myUrl.URL_OR,"SearchOrder"));
				 
				  WbElm.sendKeys(CaseName1[i]);
				  Thread.sleep(4000);
				  				  
				  String searchresult = connector.getWebElement(driver, WebConnector.Identifier.xpath,
							 connector.getstring(WebConnector.myUrl.URL_OR,"CaseName")).getText();
					Thread.sleep(5000);
					Assert.assertEquals(CaseName1[1], searchresult);
			  
			  }
		}
		  
//********************************************Scenario2:Edit the case with Accession number************************************
	
		
		  @When("^Click on Case Accession number$")
			public void click_on_Case_Accession_number() throws Throwable {
			  Thread.sleep(2000);
				connector.getWebElement(driver, WebConnector.Identifier.xpath, 
	  					connector.getstring(WebConnector.myUrl.URL_OR,"CaseAssertion")).click();
						
			}

			@Then("^Case screen should be displayed for editing$")
			
			public void case_screen_should_be_displayed_for_editing() throws Throwable {
				Thread.sleep(5000);
				boolean patientcolumn = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"SelectPatientName")).isDisplayed();
				Assert.assertEquals(true, patientcolumn);
				
			}

		
//*************************************Scenario 3:Verify Number of records displayed**************************************	
				
		
		
		@When("^Verify the default number of records displayed CL$")
		public void verify_the_default_number_of_records_displayed() throws Throwable {
			WebElement table = driver.findElement(By.id("caseorder"));
			int rowsCount = table.findElements(By.xpath("//table[@id='caseorder']/tbody/tr")).size();
			
			Assert.assertTrue(rowsCount <= 10);
		}
		
		@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box CL$")
		public void default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
			Thread.sleep(2000);
			Select dropdown = new Select (driver.findElement(By.name("caseorder_length")));
			System.out.println("test:"+dropdown.getFirstSelectedOption().getText());
			int defaultNo = Integer.valueOf(dropdown.getFirstSelectedOption().getText());
			
			Assert.assertEquals(10, defaultNo);
		}
		
		@When("^Click on dropdown that shows no of records to be displayed on the page CL$")
		public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
			Thread.sleep(2000);
			driver.findElement(By.name("caseorder_length")).click();
			Thread.sleep(2000);
		}
		
		@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page CL$")
		public void user_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
			Select dropdown = new Select (driver.findElement(By.name("caseorder_length")));
			dropdown.selectByIndex(1);
			Thread.sleep(2000);
			
			WebElement table = driver.findElement(By.id("caseorder"));
			int rowsCount;
			
			for (int i = 0; i < 4; i++) {
				dropdown.selectByIndex(i);
				int value = Integer.parseInt(dropdown.getFirstSelectedOption().getText());
				rowsCount = table.findElements(By.xpath("//table[@id='caseorder']/tbody/tr")).size();
				
				Assert.assertTrue(rowsCount <= value);
				
				Thread.sleep(2000);
			}
		}

//***********************************************Scenario 4: Verify the data sorting****************************************
				
		private WebElement element;
				
		@When("^Click on down arrow icon on sorting column CL$")
		public void click_on_down_arrow_icon_on_sorting_column() throws Throwable {
			
			loginpage.waittime();
			element = driver.findElement(By.cssSelector("thead > tr > th:nth-child(3)"));
			element.click();
		}

		@Then("^Records should be displayed based on the asecending order of the selected sorting column CL$")
		public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_sorting_column() throws Throwable {
			Thread.sleep(3000);
			Assert.assertTrue(element.getAttribute("class").contains("sorting_asc"));
		}

		@When("^Click on Up icon arrow on Profile Name column CL$")
		public void click_on_Up_icon_arrow_on_Profile_Name_column() throws Throwable {
			element.click();
		}

		@Then("^Records should be displayed based on the descending order of the selected sorting column CL$")
		public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_sorting_column() throws Throwable {
			Thread.sleep(1000);
			Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
		}
//***************************************************Scenario:5 Page Navigation**************************************************
		private int activePage;
		
		@When("^clicked on next button CL$")
		public void clicked_on_next_button() throws Throwable {
			Thread.sleep(1000);
			WebElement next = driver.findElement(By.cssSelector(".next > a"));
			
			if(next.isEnabled()) {
				next.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the next page CL$")
		public void the_user_should_be_able_to_navigate_to_the_next_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
		@When("^clicked on Prev button CL$")
		public void clicked_on_Prev_button() throws Throwable {
			Thread.sleep(1000);
			WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
			
			if(prev.isEnabled()) {
				prev.click();
				activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			}
		}
		
		@Then("^the user should be able to navigate to the Previous page CL$")
		public void the_user_should_be_able_to_navigate_to_the_Previous_page() throws Throwable {
			Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
		}
		
//*****************************************************Scenario 6:Add new CaseList**********************************************	
		
		@When("Click on the Add CaseList icon")
		public void Click_on_the_Add_pathologist_icon() throws Throwable{
			Thread.sleep(9000);
			connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"AddCaseList")).click();
			
			}
		
		@Then("^\"([^\"]*)\" screen should be displayed CL$")
		public void screen_should_be_displayed(String arg1) throws Throwable {
			Thread.sleep(2000);
			boolean patientcolumn = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"SelectPatientName")).isDisplayed();
			Assert.assertEquals(true, patientcolumn);
		}		
//************************************************* Scenario 7: Edit case under action column*******************************************
		private WebElement row;
		
				
		@Then("^\"([^\"]*)\" should be displayed under column \"([^\"]*)\"$")
		public void should_be_displayed_under_column(String arg1, String arg2) throws Throwable {
			Thread.sleep(5000);
			WebElement tableBody = driver.findElement(By.xpath("//table[@id='caseorder']/tbody/tr"));
			
			List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
			for(int i=1;i<=rows.size();i++) {
				row = driver.findElement(By.xpath("//table[@id='caseorder']/tbody/tr["+i+"]"));
				String cell = row.findElement(By.xpath("//td[7]")).getText();
				Assert.assertTrue(cell.contains("finalized"));
				break;
			}
		}

		@When("^Click on the Edit icon under the Action column for finalised case$")
		public void click_on_the_Edit_icon_under_the_Action_column_for_case() throws Throwable {
			row.findElement(By.cssSelector("#editlink > i")).click();
		}

		@Then("^popup window should be displayed$")
		public void Popup_window_should_be_displayed() throws Throwable {
			Thread.sleep(1000);
			driver.findElement(By.id("caseCorrectionModal"));
		}

//*******************************************Scenario 8:Verify the ReportOrder********************************************
		
		@When("Click on the Report icon in page CL")
		public void Click_on_the_report_icon_in_page_CL() throws Throwable{
			Thread.sleep(4000);
			boolean click = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ReportPDF")).isDisplayed();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  		
						
			if (click == true){
				connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ReportPDF")).click();
				Thread.sleep(4000);
				String view = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ViewICon")).getAttribute("tittle");
				boolean contain = StringUtils.containsIgnoreCase(view, "Report has been viewed");
				Assert.assertEquals(contain, true);
			}
				
			}
//*******************************************Scenario 9:Deleting a case under action column********************************************
		
		@When("Click on the Delete Case")
		public void Click_on_the_Delete_Case_Under_Action_Column() throws Throwable{
			Thread.sleep(3000);
			boolean click = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"DeleteIcon")).isDisplayed();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  		
			Assert.assertEquals(click, true);
			
			if (click == true){
				connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"DeleteIcon")).click();
				Thread.sleep(4000);
				boolean Confirmdelete = connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ConfirmDelete")).isDisplayed();
				Assert.assertEquals(true, Confirmdelete);
			}
				
			}

	}
		 
		


