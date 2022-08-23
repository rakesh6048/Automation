package common;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utils;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.Utils;

public class Configuration {

	private static final String String = null;
	private static DesiredCapabilities desiredCapabilities;
	private WebElement element;
	protected static AndroidDriver ndmsDriver = null;
	protected static WebDriverWait ndmsWait = null; 	
	protected static AndroidDriver iAlertDriver = null;
	protected static WebDriverWait leyKartWait = null;
	protected static WebDriverWait mechWait = null;
	protected static WebDriverWait driverWait = null;
	// protected static Wait<WebDriver> fmWait;
	// protected static Wait<WebDriver> mechWait;
	public static ExtentReports extentReports;
	public static ExtentTest eLogger;
	public static String leyKartAppPackage = "WEBVIEW_com.al.leykart";
	public static String mechAppPackage = "WEBVIEW_com.servicemandi.mechanic";
	public static String driveAppPackage = "WEBVIEW_com.servicemandi.driver";
	
	public static String iAlertAppPackage = "WEBVIEW_com.al.ialert.uat";
	public static String iAlertNativeApp = "NATIVE_App";
	protected static WebDriver driver;
	public static Properties prop;
	
	//prop=new Properties();
	
	public enum LocatorType {
		XPATH, ID, CLASS, NAME, CSS
	}
	
	public static void idealLaunch() {
		try {
		prop=new Properties();
		prop.load(new FileInputStream("D:/Automation/AutomationNDMS/AutomationNDMS/data.properties"));
		String chromeDriver=prop.getProperty("ChromeDriver_path");
	    System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver=new ChromeDriver();
		driver.get(prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(prop.getProperty("UserName"));
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys(prop.getProperty("Password"));
		
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		}catch(Exception e) {
			
		}
	}

	public static void ndmsCapabilities() {

		try {

			File app = new File("E:\\Rakesh\\Rakesh_NDMS_APK\\gdms_20062019.apk");
			desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("deviceName", "LGH9183d12d48a");
			//desiredCapabilities.setCapability("appium-version", "1.13.0");
		    //desiredCapabilities.setCapability(MobileCapabilityType.UDID,"LGH9183d12d48a"); 
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformVersion", "7.0");
			desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100000");
			//desiredCapabilities.setCapability("appPackage", "com.wipro.gdms"); 
			//desiredCapabilities.setCapability("appActivity", "com.wipro.gdms.activities.LoginActivity");
			desiredCapabilities.setCapability("app", app.getAbsolutePath());
			//desiredCapabilities.setCapability("automationName", "uiautomator2");
			
			ndmsDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

			ndmsDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			ndmsWait = new WebDriverWait(ndmsDriver, 120);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error ::" + e.toString());
		}
	}
	public static AndroidDriver getNDMSInstance() {

		if (ndmsDriver != null) {
			return ndmsDriver;
		}
		return null;
	}	
	public static String reportConfiguration(String newWorkFlow) throws InterruptedException {

//		if (extentReports == null) {
//			extentReports = new ExtentReports(
//					System.getProperty("user.dir") + File.separator + "LeyKart_Reports.html", true,
//					DisplayOrder.OLDEST_FIRST);
//		}
		
		System.out.println("WorkflowName::::" + newWorkFlow);
		DateFormat df = new SimpleDateFormat("dd MM yyyy");
		Thread.sleep(2000);
		System.out.println("DateFormat::::" + df.format(new Date()));
		///C:\\Users\\14402\\git\\demoservicemandiautomation\\SM_Report\\
		extentReports = new ExtentReports("C:\\Users\\AutoEver\\eclipse-workspace\\NDMSReports" + newWorkFlow +" "+ df.format(new Date()) + ".html",true,DisplayOrder.OLDEST_FIRST);
		//extentReports = new ExtentReports("D:\\SMReports\\" + newWorkFlow + ".html",true,DisplayOrder.OLDEST_FIRST);
		return newWorkFlow;

	}
	
	public static void closeWorkFlowReport() {
		extentReports.endTest(eLogger);
	}

	public static void createNewWorkFlowReport(String newWorkFlow) {

		eLogger = extentReports.startTest(newWorkFlow);
	}

	public WebElement getNDMSWebElement(LocatorType type, String locator) {
		element = null;
		switch (type) {
		case XPATH:
			if (ndmsDriver.findElements(By.xpath(locator)).size() > 0) {
				element = ndmsDriver.findElement(By.xpath(locator));
			} else {
				element = null;
			}
			break;
		case NAME:
			if (ndmsDriver.findElements(By.name(locator)).size() > 0) {
				element = ndmsDriver.findElement(By.name(locator));
			} else {
				element = null;
			}
			break;
		case CLASS:
			if (ndmsDriver.findElements(By.className(locator)).size() > 0) {
				element = ndmsDriver.findElement(By.className(locator));
			} else {
				element = null;
			}
			break;
		case CSS:
			if (ndmsDriver.findElements(By.cssSelector(locator)).size() > 0) {
				element = ndmsDriver.findElement(By.cssSelector(locator));
			} else {
				element = null;
			}
			break;
		}
		return element;
	}

	public void clickNDMSElement(LocatorType type, String locator) {

		try {
			Thread.sleep(3000);
			WebElement elem = getNDMSWebElement(type, locator);
			if (elem != null) {
				elem.click();
			}
			writeReport(LogStatus.PASS, " Click on "+elem.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterNDMSValue(LocatorType type, String locator, String data) {

		try {
			WebElement elem = getNDMSWebElement(type, locator);
			if (elem != null) {
				elem.click();
				elem.clear();
				elem.sendKeys(data);
			}
		} catch (Exception e) {
		}
	}

	/**
	 * This method switches to web view context.
	 */
	public static void switchToNDMSWebView() {

		try {
			Thread.sleep(2000);
			Set<String> availableContexts = ndmsDriver.getContextHandles();
			for (String context : availableContexts) {
				if (context.contains(leyKartAppPackage)) {
					ndmsDriver.context(context);
					System.out.println("Context switched to web view ::: " + context);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*public static void switchToiAlertNativeView() {

		try {
			Thread.sleep(2000);
			Set<String> availableContexts = iAlertDriver.getContextHandles();
			for (String context : availableContexts) {
				if (context.contains(iAlertNativeApp)) {
					iAlertDriver.context(context);
					System.out.println("Context switched to web view ::: " + context);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public void leyKartWait(final String locator) throws InterruptedException {

		//Thread.sleep(1000);
		leyKartWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		/*
		 * fmWait.until(new Function<WebDriver, WebElement>() { public
		 * WebElement apply(WebDriver driver) {
		 * 
		 * WebElement element = driver.findElement(By.xpath(locator)); String
		 * getTextOnPage = element.getText(); System.out.println(getTextOnPage);
		 * return null; } });
		 */
	}

	/**
	 * This method destroys the created android driver instance.
	 */
	public static void tearDownNDMS() {
		try {
			Thread.sleep(5000);
			ndmsDriver.quit();
		} catch (InterruptedException e) {
		}
	}

	public static void saveReport() {
		String Status="Pass";
		
		System.out.println("saveReport");
		eLogger.log(LogStatus.PASS, "End of Work Flow");
		extentReports.endTest(eLogger);
		extentReports.flush();
		//extentReports.close();
	}

	

	public static String getElementTextValue(AndroidDriver driver, String locator) {

		try {
			return driver.findElement(By.xpath(locator)).getText();
		} catch (Exception e) {

		}
		return "";
	}

	public static String getElementAttributeValue(AndroidDriver driver, String locator) {

		try {
			return driver.findElement(By.xpath(locator)).getAttribute("value");
		} catch (Exception e) {

		}
		return "";
	}

	public static void writeReport(LogStatus logStatus, String status) throws InterruptedException {

		if (eLogger == null) {
			reportConfiguration(String );
		}

		status = status + " : " + Utils.timeCalculation();
		switch (logStatus) {

		case PASS:
			eLogger.log(LogStatus.PASS, status);
			break;
		case FAIL:
			eLogger.log(LogStatus.FAIL, status);
			break;
		case INFO:
			eLogger.log(LogStatus.INFO, status);
		}
	}

	public static void hideKeyBoard(AndroidDriver androidDriver) {

		try {
			androidDriver.hideKeyboard();
			Thread.sleep(1000);
		} catch (Exception e) {
			// Code change done by Shanthakumar
			e.printStackTrace();
		}
	}
	

	/**
	 ************************************************************* 
	 *Method - Method to verify if an element is present.
	 *Author -Rakesh
	 * @throws InterruptedException 
	 ************************************************************* 
	 */
	public void isElementPresentVerification(LocatorType type, String locator) throws InterruptedException {
		boolean isElementPresent = false;
		WebElement webElement = null;
		String element = null;
		try {
			webElement = getNDMSWebElement(type, locator);
			element=webElement.getText();
			if (webElement != null) {
				isElementPresent = true;
				writeReport(LogStatus.PASS, element +" is present in screen");
			}
		} catch (Exception e) {
			writeReport(LogStatus.ERROR, element +" is not present in screen");
			e.printStackTrace();
		}
		
	}
	/**
	 ************************************************************* 
	 *Method -  Method to scroll up in mobile app.
	 *Author - Rakesh
	 ************************************************************* 
	 */
	public static void scrollUpAppScreen() {
		try {
			
			TouchActions action = new TouchActions(ndmsDriver);
			//action.press(400, 600).waitAction(Duration.ofSeconds(1)).moveTo(400, 100).release().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
	}
	
	
	/**
	 ************************************************************* 
	 *Method -  Method to scroll down in mobile app.
	 *Author - Rakesh
	 ************************************************************* 
	 */
	public static void scrollDownAppScreen() {
		try {
			Thread.sleep(3000);
			TouchAction action = new TouchAction(ndmsDriver);
			//action.press("").waitAction(Duration.ofSeconds(1)).moveTo(600, 1000).release().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			
	}}
	/**
	 ************************************************************* 
	 *Method -   Method to close the mobile app.
	 *Author - Rakesh
	 ************************************************************* 
	 */
	public static void closeApp() {
		try {
			ndmsDriver.closeApp();
		} catch (Exception e) {
			
		}

	}
	
	/**
	 ************************************************************* 
	 *Method -   Method to perform the tap operation on given coordinates.
	 *Author - Rakesh
	 ************************************************************* 
	 */
	public static void tapOnCoordinates(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) ndmsDriver;

		HashMap<String, Double> coords = new HashMap<String, Double>();

		coords.put("x", (double) x); // in pixels from left

		coords.put("y", (double) y); // in pixels from top

		js.executeScript("mobile: tap", coords);
	}
	
	/**
	 ************************************************************* 
	 *Method -   Method to perform the take screen shot for failed scripts
	 *Author - Rakesh
	 ************************************************************* 
	 */
	public static void takeScreenShotForFailedScripts() throws InterruptedException, IOException {
		
		try {
		System.out.println("Inside take screen shot for failed scripts");
		((AppiumDriver<WebElement>) ndmsDriver).context("NATIVE_APP");
		Thread.sleep(2000);

		TakesScreenshot scrShot = ((TakesScreenshot) ndmsDriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		Thread.sleep(2000);

		DateFormat df1 = new SimpleDateFormat("dd MM yyyy hh mm ss");
		String DestFile = "C:\\Users\\AutoEver\\eclipse-workspace\\NDMSReports\\NDMSScreenShot\\"+"ErrorLK_"+ df1.format(new Date()) +".png";
		//String DestFile = System.getProperty("user.dir") + "\\target\\smImages\\"+"ERRFM_"+ df1.format(new Date()) + ".png";
							
		//String DestFile = "D:\\Deepa\\GitFolder\\GitPull\\Screenshots\\"+ "ERRFM_"+ df1.format(new Date()) + ".png";
		Thread.sleep(2000);
		System.out.println("Date Format::::" + df1.format(new Date()));
		FileUtils.copyFile(SrcFile, new File(DestFile));
		
		//FileUtils.getFile(SrcFile, "\\\\10.1.221.101\\SM_automation\\"+"ERRFM_"+ df1.format(new Date()) +".png");
		Thread.sleep(2000);
		writeReport(LogStatus.FAIL, "NDMS::::SNAPSHOT::::: " + eLogger.addScreenCapture(DestFile));
		
		//switchToLeyKartWebView();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public void scroller() throws IOException 
	{
	      Dimension dimensions = ad.manage().window().getSize();
	      System.out.println("Size of Window= " +dimensions);
	      int scrollStart = (int) (dimensions.getHeight() * 0.5);
	      System.out.println("Size of scrollStart= " +scrollStart);
	      int scrollEnd = (int) (dimensions.getHeight() * 0.2);
	      System.out.println("Size of cscrollEnd= " + scrollEnd);             
	      ndmsDriver.swipe(0,scrollStart,0,scrollEnd,1000);           
	      System.out.println("Screen Swiped " );
	 }*/
}
