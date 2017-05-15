package easytox.apptest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.utils.WebConnector;

public class LabUserPage extends AbstractPage {
	//WebDriver driver;
	
	public LabUserPage(WebDriver driver) {
		super(driver);
	}
	
	public LabUserPage ActionIcon_Click() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"ActionIcon")).click();
		
		Thread.sleep(4000);
		
		return new LabUserPage(driver);
	}
	
	public LabUserPage Clickonpostiveicon() throws Throwable{
		
		Thread.sleep(4000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"PlusIcon")).click();
		Thread.sleep(4000);
		//Closing the add lab frame
	connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"CloseIconinAddLabFrame")).click();
		return new LabUserPage(driver);
	}
	
	public LabUserPage EnterSearchCriteria(){
	//	driver.findElement(By.name(connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox"))).sendKeys(User);
		WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox"));

		WbElm.sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"User"));
		return new LabUserPage(driver);
	}                                                                       
	
	public void ChangingNumberofRecordsDisplayedonPage(){
		driver.findElement(By.name("example_length")).click();
		connector.getWebElement(driver, WebConnector.Identifier.name,connector.getstring(WebConnector.myUrl.URL_OR,"NoofUserRecords")).click();
		Select dropdown = new Select(connector.getWebElement(driver, 
								WebConnector.Identifier.name,
								connector.getstring(WebConnector.myUrl.URL_OR,"NoofUserRecords")));
		//RequiredNoofRecords
		dropdown.selectByVisibleText(connector.getstring(WebConnector.myUrl.URL_OR,"RequiredNoofUserRecords"));
		connector.getWebElement(driver, WebConnector.Identifier.name,connector.getstring(WebConnector.myUrl.URL_OR,"NoofUserRecords")).click();
		
	}
	
	public void SortingColumns() throws Throwable{
		
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"SortingUserarrowhead")).click();
		
		
	}

	
	
	

}
