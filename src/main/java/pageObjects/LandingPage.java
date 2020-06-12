package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	//Get driver object a life by passing it in a constructor
	public WebDriver driver;
	public LandingPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	//create objects of the page here
	By signin = By.cssSelector("a[href*='sign_in']");
	By dismisspopup = By.cssSelector("#homepage > div.sumo-form-wrapper.listbuilder-popup > div.listbuilder-popup-content > div > div > div > span > div > div.sumome-react-wysiwyg-component.sumome-react-wysiwyg-outside-horizontal-resize-handles.sumome-react-wysiwyg-outside-vertical-resize-handles.sumome-react-wysiwyg-close-button.sumome-react-wysiwyg-popup-image.sumome-react-wysiwyg-image > div > div > div:nth-child(2)");
	By navBarContact = By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul/li[8]/a");
	By title = By.cssSelector("#content > div.container > div.text-center > h2");
	
	//Create WebElement methods of the objects on the page.
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public void checkAndGetPopup()
	{
		//boolean check = driver.findElement(dismisspopup).isDisplayed();
		boolean isPresent = driver.findElements(dismisspopup).size() > 0;

		if(isPresent==true)
		{
			getPopup().click();
			isPresent=false;
		}
		else
		{
		return;
		}
	}
	
	public WebElement getPopup()
	{
		return driver.findElement(dismisspopup);
	}
	
	public WebElement getNavContact()
	{
		return driver.findElement(navBarContact);
	}


}
