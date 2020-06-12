package Academy.E2EProject1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.base;

public class listener extends base implements ITestListener //ITestListner is by the TestNG 
{

	@Override
	public void onTestStart(ITestResult result) {	}

	@Override
	public void onTestSuccess(ITestResult result) {	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		WebDriver driver = null;
		//get failure driver object and method name
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String testMethodName = result.getMethod().getMethodName();
		try {
			getScreenShotPath(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Screenshot code.
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }

	@Override
	public void onStart(ITestContext context) { }

	@Override
	public void onFinish(ITestContext context) { }
	
}
