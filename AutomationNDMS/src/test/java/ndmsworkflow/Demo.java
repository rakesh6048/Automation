package ndmsworkflow;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Demo {
	
	private static final String String = null;
	private static DesiredCapabilities desiredCapabilities;
	private WebElement element;
	protected static AndroidDriver ndmsDriver = null;
	protected static WebDriverWait ndmsWait = null;
	
 
  @BeforeMethod
  public static void Launch() throws MalformedURLException {
	  File app = new File("E:\\Rakesh\\Rakesh_NDMS_APK\\gdms_20062019.apk");
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "LGH9183d12d48a");
		//desiredCapabilities.setCapability("appium-version", "1.13.0");
	    //desiredCapabilities.setCapability(MobileCapabilityType.UDID,"LGH9183d12d48a"); 
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "7.0");
	//	desiredCapabilities.setCapability("recreateChromeDriverSessions", "true");
		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100000");
		//desiredCapabilities.setCapability("appPackage", "com.wipro.gdms"); 
		//desiredCapabilities.setCapability("appActivity", "com.wipro.gdms.activities.LoginActivity");
		desiredCapabilities.setCapability("app", app.getAbsolutePath());
		//desiredCapabilities.setCapability("automationName", "uiautomator2");
		
		ndmsDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

		ndmsDriver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		//ndmsWait = new WebDriverWait(ndmsDriver, 120);
	  
  }
  
  @Test
  public void myTest() {
	  try {
		  Thread.sleep(4000);
		  ndmsDriver.findElement(By.id("com.wipro.gdms:id/username_et")).clear();
		  
		  ndmsDriver.findElement(By.id("com.wipro.gdms:id/username_et")).sendKeys("10000000");
		  
		  
	  
	// ndmsDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText")).sendKeys("Test");
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }

  @AfterMethod
  public void afterMethod() {
  }

}
