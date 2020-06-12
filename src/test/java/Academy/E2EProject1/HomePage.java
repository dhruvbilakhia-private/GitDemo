package Academy.E2EProject1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base
{
//	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void launch() throws IOException
	{
		driver = initializeDriver();
		log.info("Home page - Driver is Initialized");
	}
	
	@Test(dataProvider = "getData")
	public void baseNavigation(String UserName, String Password, String Text) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Home page - URL is Hit");
		Thread.sleep(3000);
		LandingPage l=new LandingPage(driver);
		LoginPage lp=new LoginPage(driver);
		
		l.checkAndGetPopup();
		log.info("Home page - Pop Up Handled");
//		l.getPopup().click();
		//Another widely used assert is Assert.assertTrue(condition)
		l.getLogin().click();
		log.info("Home page - Clicked on Login link");
		Thread.sleep(5000);
		lp.getUserName().sendKeys(UserName);
		log.info("Home page - User name Entered");
		lp.getPassword().sendKeys(Password);
		log.info(Text);
		lp.getLoginButton().click();
		log.info("Home page - Click on Login Button");
		Thread.sleep(2000);
		Assert.assertEquals(lp.getInvalidCredentialsText().getText(), "Invalid email or password.");
		log.info("Home page - Validation Passed");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different types of data. In this case it is Valid user and Invalid users
		//Column stands for how many values or dataset for each test. In this case it is 2 user name and password
		Object[][] data=new Object[2][3];
		//0th Row for the Valid User
		data[0][0] = "dhruvbilakhia@gmail.com";
		data[0][1] = "Test@123";
		data[0][2] = "Valid User";
		
		//0th Row for the invalid users
		data[1][0] = "someemail@email.com";
		data[1][1] = "Test@123";
		data[1][2] = "Invalid User";
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
