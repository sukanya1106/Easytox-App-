package easytox.apptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import easytox.apptest.utils.WebConnector;

public class LoginPage extends AbstractPage  {
	
		
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
		
	public LoginPage EnterUserName(String Username){
		driver.findElement(By.name(connector.getstring(WebConnector.myUrl.URL_OR,"LoginUsername"))).sendKeys(Username);
		return new LoginPage(driver);
	}
	
	public LoginPage EnterPassword(String Password){
		driver.findElement(By.name(connector.getstring(WebConnector.myUrl.URL_OR,"LoginPassword"))).sendKeys(Password);
		return new LoginPage(driver);
	}
	
	public void Loginbuttonclick(){
		driver.findElement(By.xpath(connector.getstring(WebConnector.myUrl.URL_OR,"LoginButton"))).click();
		
	}

}
