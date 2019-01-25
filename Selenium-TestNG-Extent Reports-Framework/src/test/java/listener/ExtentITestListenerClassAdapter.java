package listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;

import resources.Base;

public class ExtentITestListenerClassAdapter implements ITestListener{

	Base b = new Base();

	public void onTestStart(ITestResult result) {
		ExtentTestManager.createMethod(result, true);

	}

	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.log(result, true);

	}

	public void onTestFailure(ITestResult result) {
		ExtentTestManager.log(result, true);
		Object testClass = result.getInstance();
		WebDriver driver = ((Base) testClass).getDriver();

		try {
			String screenshotPath = b.getScreenshot(driver, result.getName());
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.log(result, true);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);

	}

	public void onFinish(ITestContext context) {
		ExtentService.getInstance().flush();

	}

}
