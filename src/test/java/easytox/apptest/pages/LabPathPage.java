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

public class LabPathPage extends AbstractPage {
	//WebDriver driver;
	
	public LabPathPage(WebDriver driver) {
		super(driver);
	}
	
	public LabPathPage ActionIcon_Click() throws Throwable{
		connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"SettingsIcon")).click();
		
		Thread.sleep(4000);
		
		return new LabPathPage(driver);
	}
	
	public LabPathPage Clickonpostiveicon() throws Throwable{
		
		Thread.sleep(4000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"PlusIcon")).click();
		Thread.sleep(4000);
		//Closing the add lab frame
	connector.getWebElement(driver, WebConnector.Identifier.xpath,connector.getstring(WebConnector.myUrl.URL_OR,"CloseIconinAddLabFrame")).click();
		return new LabPathPage(driver);
	}
	
	public LabPathPage EnterSearchCriteria(){
	//	driver.findElement(By.name(connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox"))).sendKeys(User);
		WebElement WbElm = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				 connector.getstring(WebConnector.myUrl.URL_OR,"SearchBox"));

		WbElm.sendKeys(connector.getstring(WebConnector.myUrl.URL_OR,"Pathologist"));
		return new LabPathPage(driver);
	}                                                                       
	
	}
