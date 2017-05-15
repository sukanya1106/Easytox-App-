package easytox.apptest.stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

public class LabListStepdefinitions {
	
	WebDriver driver = null;	
	LoginPage loginpage;
	WebConnector connector = new WebConnector();
	LablistPage lablist = null;
	LabUserPage labuser = null;
	

		//*******Scenario 1: Verifying Lab list table of contents********
	@When("^Click on \"([^\"]*)\" on the menu$")
	public void click_on_on_the_menu(String arg1) throws Throwable {
		lablist.waittime();
		lablist.Name_colu_click();
		lablist.waittime();	  
	}
	
	@Then("^\"([^\"]*)\" screen should be displayed$")
	public void screen_should_be_displayed(String arg1) {
				
		String Labinfo = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR,"LabName_Validation")).getText();
		Assert.assertEquals("Lab name", Labinfo);
	}
	
	//************Scenario 2: Verify adding a new lab******************
	
		@When("^Click on \"([^\"]*)\" icon beside the Search Box$")
		public void Click_on_icon_beside_the_Search_Box(String arg1) throws Throwable {
			
			lablist.Clickonpostiveicon();			
		}

		@Then("^\"([^\"]*)\" window should be displayed$")
		public void window_should_be_displayed(String arg1) throws Throwable{
			String Addlab = connector.getWebElement(driver, WebConnector.Identifier.xpath, 
					connector.getstring(WebConnector.myUrl.URL_OR,"Addlab_Validation")).getText();
			//Assertion is still pending to implement
			System.out.println(Addlab);
		}

	//**********Scenario 3: Verify the search box in lablist screen********
	@When("^Enter any search criteria and click on search icon$")
	public void enter_any_search_criteria_and_click_on_search_icon() throws Throwable {
			lablist.EnterSearchCriteria();		
	}

	@Then("^Matching records with entered data should be displayed in the Lab list$")
	public void matching_records_with_entered_data_should_be_displayed_in_the_Lab_list() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(connector.getstring(WebConnector.myUrl.URL_OR,"SearchCriteria"))));
		String searchresult = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"SearchResults")).getText();
		Thread.sleep(5000);
		Assert.assertEquals("Lab Test", searchresult);
 
	}

	//*************Scenario 4:Verify Number of records displayed***********************	
	
	@When("^Verify the default \"([^\"]*)\" number of records displayed$")
	public void Verify_the_default_number_of_records_displayed(String arg1) {
		
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='lablist']/tbody/tr/td[1]"));
		Assert.assertEquals(15, list.size());
		
	}
	
	
	@Then("^Click on dropdown to change the number of records to \"([^\"]*)\"$")
	public void click_on_dropdown_that_shows_number_of_records_to_be_displayed_on_the_page(String arg1) throws Throwable {
		loginpage.waittime();
		lablist.ChangingNumberofRecordsDisplayedonPage();
	   
	}

		
	@Then("^User should be able to view selected number of records$")
	public void user_should_be_able_to_view_selected_number_of_records() {
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='lablist']/tbody/tr/td[1]"));
		System.out.println(list.size());
	}
	
	//***********Scenario 5: Verify the data sorting****************************************
	
	@When("^Click on \"([^\"]*)\" down arrow icon on any column$")
	public void click_on_down_arrow_icon_on_any_column(String arg1) throws Throwable{
		loginpage.waittime();
		lablist.SortingColumns();
	}

	@Then("^Records should be displayed based on the asecending order of the selected field$")
	public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field(){
	   //Validation for assecending order is pending
	}

	@When("^Click on \"([^\"]*)\" Up arrow icon on any column$")
	public void click_on_Up_arrow_icon_on_any_column(String arg1) throws Throwable {
		loginpage.waittime();
		lablist.SortingColumns();
	   
	}

	@Then("^Records should be displayed based on the descending order of the selected field$")
	public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_field() {
	 //Validation for descending order is pending   
	}
}
	
	//******************************************************************************************
	
		