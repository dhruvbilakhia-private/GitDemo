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

public class validateTitle extends base
{
//	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void launch() throws IOException
	{
		driver = initializeDriver();
	}
	
	@Test()
	public void validateTitleMethod() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		LandingPage l=new LandingPage(driver);
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		log.info("Validation Home page - Title is correct");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}

