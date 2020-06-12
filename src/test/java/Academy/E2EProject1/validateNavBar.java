package Academy.E2EProject1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateNavBar extends base
{
//	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void launch() throws IOException
	{
		driver = initializeDriver();
	}
	
	@Test()
	public void validateNavMethod() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Validate Nav Bar page - Open URL");
		Thread.sleep(3000);
		LandingPage l=new LandingPage(driver);
		
		Assert.assertTrue(l.getNavContact().isDisplayed());
		log.info("Validate Nav Bar page - Navigation Bar is correct");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}

