package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage 
{
	//Get driver object a life by passing it in a constructor
	public WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	//create objects of the page here
	By eleUserName = By.xpath("//*[@id='user_email']");
	By elePassword = By.xpath("//*[@id='user_password']");
	By eleLoginButton = By.xpath("//*[@id='new_user']/div[4]/input");
	By eleInvalidText = By.cssSelector("div.alert.alert-danger");
	
	//Create WebElement methods of the objects on the page.
	public WebElement getUserName()
	{
		return driver.findElement(eleUserName);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(elePassword);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(eleLoginButton);
	}
	public WebElement getInvalidCredentialsText()
	{
		return driver.findElement(eleInvalidText);
	}
}
