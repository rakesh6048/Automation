package common;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import utils.ExcelInputData;

public class NDMS extends Configuration {

	//public void login(ExcelInputData excelInputData, boolean isVerified) throws InterruptedException {
	public void login() throws InterruptedException {
		try {
			ndmsCapabilities();

			ndmsDriver.findElement(By.id("com.wipro.gdms:id/username_et")).clear();
			ndmsDriver.findElement(By.id("com.wipro.gdms:id/username_et")).sendKeys("10000000");

			writeReport(LogStatus.PASS, "NDMS Login UserName Pass");

			ndmsDriver.findElement(By.id("com.wipro.gdms:id/password_et")).clear();
			ndmsDriver.findElement(By.id("com.wipro.gdms:id/password_et")).sendKeys("1234");

			writeReport(LogStatus.PASS, "NDMS Login Password Pass");

			ndmsDriver.findElement(By.id("com.wipro.gdms:id/text_input_password_toggle")).click();

			Thread.sleep(2000);
			ndmsDriver.findElement(By.id("com.wipro.gdms:id/login_button")).click();

			writeReport(LogStatus.PASS, "NDMS Login Pass");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyLoginSuccess() throws InterruptedException {

		String dashboard=ndmsDriver.findElement(By.id("com.wipro.gdms:id/toolbar_title")).getText();
		System.out.println("Title :"+dashboard);

		if(dashboard.equalsIgnoreCase("Dashboard")) {
			System.out.println("Dashboard title present in dashboard screen");
		}else {
			System.out.println("Dashboard title not present in dashboard screen");
		}
		writeReport(LogStatus.PASS, "Login Success Pass");
	}

	public void logOut() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		Thread.sleep(1000);
		ndmsDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"My Complaints\"]/android.widget.FrameLayout")).click();
		ndmsDriver.findElement(By.id("android:id/button2")).click();
		Thread.sleep(1000);
		ndmsDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"My Complaints\"]/android.widget.FrameLayout")).click();
		ndmsDriver.findElement(By.id("android:id/button1")).click();

		writeReport(LogStatus.PASS, "LogOut Successfully Pass");
	}

	public void forgotPassword() throws InterruptedException {

		ndmsCapabilities();

		ndmsDriver.findElement(By.id("com.wipro.gdms:id/forgot_button")).click();



		ndmsDriver.findElement(By.id("com.wipro.gdms:id/username_et")).sendKeys("12434");
		ndmsDriver.findElement(By.id("com.wipro.gdms:id/dealer_code_et")).sendKeys("123");
		ndmsDriver.findElement(By.id("com.wipro.gdms:id/mobile_no")).sendKeys("1111111111");
		Thread.sleep(1000);
		ndmsDriver.findElement(By.id("com.wipro.gdms:id/login_button")).click();

		ndmsDriver.findElement(By.id("com.wipro.gdms:id/forgot_button")).sendKeys("112233");
		ndmsDriver.findElement(By.id("com.wipro.gdms:id/proceed_btn")).click();

		writeReport(LogStatus.PASS, "ForgotPassword Page Pass");

		//Change password
		ndmsDriver.findElement(By.xpath(LocatorPath.newPassword)).sendKeys("112233");
		ndmsDriver.findElement(By.xpath(LocatorPath.confirmPassword)).sendKeys("112233");
		ndmsDriver.findElement(By.id(LocatorPath.showPassword)).click();
		ndmsDriver.findElement(By.id(LocatorPath.proceed_BTN)).click();

		writeReport(LogStatus.PASS, "Change password All Fields Pass");


		writeReport(LogStatus.PASS, "ForgotPassword Successfully Pass");
	}

	public void verifyNavigationFlowsInDashboardScreen() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.myComplaints)).click();
		writeReport(LogStatus.PASS, "Dashboard My Complaints Pass");

		Thread.sleep(1000);
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_BTN)).click();
		writeReport(LogStatus.PASS, "Dashboard Home Visit Pass");

		ndmsDriver.findElement(By.id(LocatorPath.dashboardButton1)).click();

        Thread.sleep(4000);   
		ndmsDriver.findElement(By.id(LocatorPath.bellIcon)).click();

		ndmsDriver.findElement(By.id(LocatorPath.notification_Details)).click();

		writeReport(LogStatus.PASS, "Dashboard Notification Flows Pass");

		ndmsDriver.findElement(By.id(LocatorPath.dashboardButton)).click();

		//Call Back Section
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.callBack_Section)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.dayOne)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.dayTwo)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.dayThree)).click();
		
		Thread.sleep(2000);

		ndmsDriver.findElement(By.id(LocatorPath.calanderIcon)).click();
		ndmsDriver.findElement(By.id(LocatorPath.okCLS_BTN)).click();

		//Navigation
		ndmsDriver.findElement(By.id(LocatorPath.callbackNavigation)).click();

		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Callback Flows Pass");
		Thread.sleep(2000);
		
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();

		//Home Visit Section

		ndmsDriver.findElement(By.id(LocatorPath.homeVisitNavigation)).click();

		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Home Visit Flows Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();

		//Showroom Visit
		ndmsDriver.findElement(By.id(LocatorPath.showroomVisitNavigation)).click();

		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Showroom Flows Pass");
		Thread.sleep(2000);
		
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();	

		// Test Drive Section
		ndmsDriver.findElement(By.id(LocatorPath.testDriveNavigation)).click();
		Thread.sleep(2000);
		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		Thread.sleep(1000);
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();	


		writeReport(LogStatus.PASS, "Dashboard TestDrive Flows Pass");
	}

	public void verifyTestDriveNavigationInDashboardScreen() throws InterruptedException {

		ndmsDriver.findElement(By.id(LocatorPath.testDriveNavigationInDashboard)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.dayOne)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.dayTwo)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.dayThree)).click();

		writeReport(LogStatus.PASS, "Dashboard TestDrive Day Selection Flows Pass");

		ndmsDriver.findElement(By.id(LocatorPath.calanderIcon)).click();
		ndmsDriver.findElement(By.id(LocatorPath.okCLS_BTN)).click();

		// Test Drive Section
		ndmsDriver.findElement(By.id(LocatorPath.testDriveNavigation)).click();

		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard TestDrive Tab Selection Flows Pass");

		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();	

		writeReport(LogStatus.PASS, "Dashboard Test Drive Navigation Flow Pass");
	}

	public void verifyHomeVisitSectionInDashboardScreen() throws InterruptedException {

		ndmsDriver.findElement(By.id(LocatorPath.homeVisitSection)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.dayOne)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.dayTwo)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.dayThree)).click();

		writeReport(LogStatus.PASS, "Dashboard Home Visit Day Selection Flows Pass");

		ndmsDriver.findElement(By.id(LocatorPath.calanderIcon)).click();
		ndmsDriver.findElement(By.id(LocatorPath.okCLS_BTN)).click();

		// Test Drive Section
		ndmsDriver.findElement(By.id(LocatorPath.testDriveNavigation)).click();

		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Home Visit Test Drive Flows Pass");

		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();	

		//Call Back Section
		ndmsDriver.findElement(By.id(LocatorPath.callbackNavigation)).click();

		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Home Visit Call Back Flows Pass");

		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();

		//Home Visit Section

		ndmsDriver.findElement(By.id(LocatorPath.homeVisitNavigation)).click();

		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Home Visit  Flows Pass");

		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();

		//Showroom Visit
		ndmsDriver.findElement(By.id(LocatorPath.showroomVisitNavigation)).click();

		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Home Visit  Showroom Flows Pass");

		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();	

		writeReport(LogStatus.PASS, "Dashboard Home Visit Pass");
	}

	public void verifyShowroomVisitSectionInDashboardScreen() throws InterruptedException {

		ndmsDriver.findElement(By.id(LocatorPath.showroomVisitSection)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.dayOne)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.dayTwo)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.dayThree)).click();

		writeReport(LogStatus.PASS, "Dashboard Showroom Day Selection Flows Pass");
        Thread.sleep(3000);
		ndmsDriver.findElement(By.id(LocatorPath.calanderIcon)).click();
		ndmsDriver.findElement(By.id(LocatorPath.okCLS_BTN)).click();

		Thread.sleep(2000);
		// Test Drive Section
		ndmsDriver.findElement(By.id(LocatorPath.testDriveNavigation)).click();

		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Showroom Test Drive Flows Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();	

		//Call Back Section
		ndmsDriver.findElement(By.id(LocatorPath.callbackNavigation)).click();
		Thread.sleep(1000);
		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Showroom Call Back Flows Pass");
         
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();

		//Home Visit Section

		ndmsDriver.findElement(By.id(LocatorPath.homeVisitNavigation)).click();
		Thread.sleep(1000);
		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Showroom Home Visit Flows Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();

		//Showroom Visit
		ndmsDriver.findElement(By.id(LocatorPath.showroomVisitNavigation)).click();
		Thread.sleep(2000);
		//Tab Navigation
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.callback_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.homeVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.showroomVisit_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive_Tab)).click();

		writeReport(LogStatus.PASS, "Dashboard Showroom Flows Pass");
		Thread.sleep(1000);
		ndmsDriver.findElement(By.xpath(LocatorPath.allLeads_Tab)).click();
		//Back Navigation 
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();	
		writeReport(LogStatus.PASS, "Dashboard Showroom Visit Section Pass");
	}

	public void verifyHambrugerMenuScreen() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();

		//Enquiry
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.enquiry)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu Enquiry Flows Pass");
        Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();

		//TestDrive
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu Test Drive Flows Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();

		//My Calendar
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.myCalendar)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu My Calendar Flows Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();

		//Stock
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.stock)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu Stock Flows Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();

		//Reports 
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.reports)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu Reports Flows Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();

		//Price
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.price)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu Price Flows Pass");
		Thread.sleep(2000);
		//ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();

		//Promotions
		/*ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.promotions)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu Promotions Flows Pass");*/

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();

		//EMI Calculator
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.emiCalculator)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu EMI Calculator Flows Pass");

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();

		//		 ndmsDriver.findElement(By.xpath(LocatorPath.about)).click();
		//		 ndmsDriver.findElement(By.xpath(LocatorPath.help)).click();

		ndmsDriver.findElement(By.id(LocatorPath.logOut_BTN)).click();
		ndmsDriver.findElement(By.id(LocatorPath.logout_NO_BTN)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu Loout Flows Pass");

		ndmsDriver.findElement(By.id(LocatorPath.profileImage)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();	

		writeReport(LogStatus.PASS, "Hambruger menu Profile Flows Pass");
	}

	public void verifyAboutNavigationNDMS() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click(); 
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.about)).click();
		//		 ndmsDriver.findElement(By.xpath(LocatorPath.help)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu NDMS About Flows Pass");

	}

	public void verifyHelpNavigationNDMS() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.help)).click();

		writeReport(LogStatus.PASS, "Hambruger Menu NDMS  Flows Pass");

	}

	public void myProfileNavigationInNDMS() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click(); 
		ndmsDriver.findElement(By.id(LocatorPath.profileImage)).click();

		Thread.sleep(1000);
		//Theme Toggle ON/OFF
		ndmsDriver.findElement(By.id(LocatorPath.personalizeThemeToogle_BTN)).click();

		writeReport(LogStatus.PASS, "My Profile Personalize Theme Toggle ON Flows Pass");
        
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click(); 
		ndmsDriver.findElement(By.id(LocatorPath.profileImage)).click();

		ndmsDriver.findElement(By.id(LocatorPath.personalizeThemeToogle_BTN)).click();

		writeReport(LogStatus.PASS, "My Profile Personalize Theme Toggle OFF Flows Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click(); 
		ndmsDriver.findElement(By.id(LocatorPath.profileImage)).click();
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.salesDataSync_BTN)).click();
		Thread.sleep(1000);
		//ndmsDriver.findElement(By.id(LocatorPath.crmDataSync_BTN)).click();

		//ndmsDriver.findElement(By.id(LocatorPath.downloadAllMasterData)).click();

		//ndmsDriver.findElement(By.id(LocatorPath.update_BTN)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.back_BTN)).click();	


		writeReport(LogStatus.PASS, "My Profile NDMS  Flows Pass");

	}

	public void enquiryFilterInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();

		Thread.sleep(2000);
		//Enquiry
		ndmsDriver.findElement(By.xpath(LocatorPath.enquiry)).click();
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.enquiryFilter_BTN)).click();
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.ageingRadio_BTN)).click();
		Thread.sleep(1000);
		ndmsDriver.findElement(By.id(LocatorPath.overdueRadio_BTN)).click();
		Thread.sleep(1000);
		ndmsDriver.findElement(By.id(LocatorPath.enquiryDateRadio_BTN)).click();

		writeReport(LogStatus.PASS, "Enquiry Filter Radio button selection Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.filterClose_BTN)).click();
		Thread.sleep(1000);
		ndmsDriver.findElement(By.id(LocatorPath.enquiryFilter_BTN)).click();
		ndmsDriver.findElement(By.id(LocatorPath.filterClear_BTN)).click();
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.enquiryFilter_BTN)).click();
		Thread.sleep(1000);
		ndmsDriver.findElement(By.id(LocatorPath.overdueRadio_BTN)).click();
		Thread.sleep(1000);
		ndmsDriver.findElement(By.id(LocatorPath.filterApply_BTN)).click();

		writeReport(LogStatus.PASS, "Enquiry Filter Flows Pass");

	}

	public void enquirySearchInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		ndmsDriver.findElement(By.xpath(LocatorPath.enquiry)).click();
        Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.search_Icon)).click();

		ndmsDriver.findElement(By.id(LocatorPath.searchClose_BTN)).click();
		writeReport(LogStatus.PASS, "Enquiry Search close Flows Pass");

		ndmsDriver.findElement(By.id(LocatorPath.search_Icon)).click();
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.selectFromDate)).click();
		ndmsDriver.findElement(By.id(LocatorPath.fromDateOk_BTN)).click();
		hideKeyBoard(ndmsDriver);
		
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.selectToDate)).click();
		ndmsDriver.findElement(By.id(LocatorPath.selectToDate)).click();
		ndmsDriver.findElement(By.id(LocatorPath.fromDateOk_BTN)).click();
		hideKeyBoard(ndmsDriver);

		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.searchCustomerName)).sendKeys("Test User");
		ndmsDriver.findElement(By.id(LocatorPath.searchClear_BTN)).click();
		writeReport(LogStatus.PASS, "Enquiry Search clear Flows Pass");
		
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.searchCustomerName)).sendKeys("Test User");
		ndmsDriver.findElement(By.id(LocatorPath.searchMobileNumber)).sendKeys("1111111111");

		ndmsDriver.findElement(By.id(LocatorPath.searchStatus)).click();
        
		Thread.sleep(2000);
		List<WebElement> statusList = ndmsDriver.findElements(By.xpath((LocatorPath.statusList)));
		System.out.println("Total search options :::" + statusList.size());
		for(int i=0;i<statusList.size();i++) {
			String statusName=statusList.get(i).getText();
			System.out.println("Status Name :::" + statusName);
			if(statusName.equalsIgnoreCase("Status One")){
				statusList.get(i).click();
				break;
			}
		}

		//Select status two
		Thread.sleep(3000);
		ndmsDriver.findElement(By.id(LocatorPath.searchModelType)).click();

		List<WebElement> modelList = ndmsDriver.findElements(By.xpath((LocatorPath.modelList)));
		System.out.println("Total search options :::" + modelList.size());
		for(int i=0;i<modelList.size();i++) {
			String modelName=modelList.get(i).getText();
			System.out.println("Model Name :::" + modelName);
			if(modelName.equalsIgnoreCase("C7")){
				modelList.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		//ndmsDriver.findElement(By.id(LocatorPath.searchApply_BTN)).click();

		ndmsDriver.findElement(By.id(LocatorPath.searchClose_BTN)).click();

		writeReport(LogStatus.PASS, "Enquiry Search Flows Pass");

	}

	public void ceateEnquiryInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
        Thread.sleep(2000);
		//Enquiry
		ndmsDriver.findElement(By.xpath(LocatorPath.enquiry)).click();
		Thread.sleep(1000);
		ndmsDriver.findElement(By.id(LocatorPath.ceateEnquiryPlus_BTN)).click();
		Thread.sleep(1000);
		ndmsDriver.findElement(By.id(LocatorPath.enquiryDetails)).click();
		ndmsDriver.findElement(By.id(LocatorPath.exchangeDetails)).click();
		ndmsDriver.findElement(By.id(LocatorPath.customerDetails)).click();



		writeReport(LogStatus.PASS, "Create Enquiry Flows Pass");

	}

	public void enquiryDetailsInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();

		//Enquiry
		ndmsDriver.findElement(By.xpath(LocatorPath.enquiry)).click();

		//ndmsDriver.findElement(By.id(LocatorPath.enquiryDetailsSection)).click();
        Thread.sleep(2000);
		List<WebElement> enqDetailsList = ndmsDriver.findElements(By.xpath((LocatorPath.enquiryDetailsList)));
		System.out.println("Total search options :::" + enqDetailsList.size());
		for(int i=0;i<enqDetailsList.size();i++) {
			String enqDetailsName=enqDetailsList.get(i).getText();
			System.out.println("Enquiry Details Name :::" + enqDetailsName);
			enqDetailsList.get(i).click();
			break;

		}
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.enquiryDetailsCall)).click();
		ndmsDriver.findElement(By.id(LocatorPath.callNo_BTN)).click();
		 Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.enquiryDetailsCall)).click();
		ndmsDriver.findElement(By.id(LocatorPath.callYes_BTN)).click();
		try {
			ndmsDriver.findElement(By.id(LocatorPath.call_Allow)).click();
			ndmsDriver.findElement(By.id(LocatorPath.callOK_BTN)).click();
		}catch(Exception e) {

		}

		writeReport(LogStatus.PASS, "Enquiry Details Call Flows Pass");
	    Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.enqDetailsFollowp)).click();
		ndmsDriver.findElement(By.id(LocatorPath.enqDetailsTestDrive)).click();
		ndmsDriver.findElement(By.id(LocatorPath.enqDetailsExchange)).click();
		ndmsDriver.findElement(By.id(LocatorPath.enqDetailsEnquiry)).click();

		writeReport(LogStatus.PASS, "Enquiry Details Flows Pass");
		Thread.sleep(2000);
		ndmsDriver.findElement(By.id(LocatorPath.enqDetailsClose)).click();
		ndmsDriver.findElement(By.id(LocatorPath.lostDetailsRemarks)).sendKeys("Test Remarks");
		hideKeyBoard(ndmsDriver);
		ndmsDriver.findElement(By.id(LocatorPath.lostDetailsSubmit_BTN)).click();

		writeReport(LogStatus.PASS, "Close Enquiry Flows Pass");

	}

	public void addFollowupInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.enquiry)).click();

		//ndmsDriver.findElement(By.id(LocatorPath.enquiryDetailsSection)).click();

		List<WebElement> enqDetailsList = ndmsDriver.findElements(By.xpath((LocatorPath.enquiryDetailsList)));
		System.out.println("Total search options :::" + enqDetailsList.size());
		for(int i=0;i<enqDetailsList.size();i++) {
			String enqDetailsName=enqDetailsList.get(i).getText();
			System.out.println("Enquiry Details Name :::" + enqDetailsName);
			enqDetailsList.get(i).click();
			break;

		}
		
	
		//Add Followup
		ndmsDriver.findElement(By.id(LocatorPath.enqDetailsFollowp)).click();
		ndmsDriver.findElement(By.id(LocatorPath.addFollowup_BTN)).click(); 
		
		//Followup Details
		ndmsDriver.findElement(By.id(LocatorPath.followupRemark_InputField)).sendKeys("Testing");
		ndmsDriver.findElement(By.id(LocatorPath.callBackDropdown_BTN)).click();

		List<WebElement> callbackList = ndmsDriver.findElements(By.xpath((LocatorPath.callBack_List)));
		System.out.println("Callback list :::" + callbackList.size());
		for(int i=0;i<callbackList.size();i++) {
			String callbackName=callbackList.get(i).getText();
			System.out.println("Callback Name :::" + callbackName);
			if(callbackName.equalsIgnoreCase("Home Visit")){
				callbackList.get(i).click();
				break;
			}

		}
		writeReport(LogStatus.PASS, "Call Back Followup Flows Pass");
		//Next Followup Details

		ndmsDriver.findElement(By.id(LocatorPath.nextCallBackDropdown_BTN)).click();

		List<WebElement> nextCallbackList = ndmsDriver.findElements(By.xpath((LocatorPath.nextCallBack_List)));
		System.out.println("Callback list :::" + nextCallbackList.size());
		for(int i=0;i<nextCallbackList.size();i++) {
			String nextCallbackName=nextCallbackList.get(i).getText();
			System.out.println("Callback Name :::" + nextCallbackName);
			if(nextCallbackName.equalsIgnoreCase("Home Visit")){
				nextCallbackList.get(i).click();
				break;
			}

		}
		writeReport(LogStatus.PASS, "Next Call Back Followup Flows Pass");
		// Select Date
		ndmsDriver.findElement(By.id(LocatorPath.selectDate)).click();
		ndmsDriver.findElement(By.id(LocatorPath.selectDateOk_BTN)).click();
		
		writeReport(LogStatus.PASS, "Date Selection Flows Pass");

		// Select Time
		ndmsDriver.findElement(By.id(LocatorPath.selectTime)).click();
		ndmsDriver.findElement(By.id(LocatorPath.selectTimeOK_BTN)).click();
		
		writeReport(LogStatus.PASS, "Time Selection Flows Pass");
		//Click on submit button
		ndmsDriver.findElement(By.id(LocatorPath.followup_Submit_BTN)).click();
		hideKeyBoard(ndmsDriver);

		writeReport(LogStatus.PASS, "Add Followup Flows Pass");
	}
	
	public void TestDriveInNDMSApp() throws InterruptedException {

		writeReport(LogStatus.PASS, "Create Enquiry Flows Pass");

	}
	
	public void testDriveInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();

		Thread.sleep(1000);
		ndmsDriver.findElement(By.xpath(LocatorPath.testDrive)).click();

//		String totalCount=ndmsDriver.findElement(By.xpath(LocatorPath.totalCountTestDrive)).getText();
//        System.out.println("Total Count :"+totalCount);

		writeReport(LogStatus.PASS, "Test Drive Flows Pass");

	}
	
	public void myCalendarInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();

		//My Calendar
		ndmsDriver.findElement(By.xpath(LocatorPath.myCalendar)).click();

		ndmsDriver.findElement(By.id(LocatorPath.prevMonthIcon)).click();
		ndmsDriver.findElement(By.id(LocatorPath.nextMonthIcon)).click();
		writeReport(LogStatus.PASS, "My Calendar Flows Pass");
		
		//Week View
		ndmsDriver.findElement(By.id(LocatorPath.weekViewLink)).click();
		ndmsDriver.findElement(By.id(LocatorPath.day_BTN)).click();
		ndmsDriver.findElement(By.id(LocatorPath.Week_BTN)).click();
		ndmsDriver.findElement(By.id(LocatorPath.today_BTN)).click();
		writeReport(LogStatus.PASS, "Week View Flows Pass");
		
	}
	
	public void stockAndReportsInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.stock)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.allocated_Link)).click();
		
		writeReport(LogStatus.PASS, "Stock Flows Pass");
		Thread.sleep(1000);
		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();
		
		ndmsDriver.findElement(By.xpath(LocatorPath.reports)).click();
		
		writeReport(LogStatus.PASS, "Reports Flows Pass");

	}
	
	public void priceInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.price)).click();
         /*try {
		ndmsDriver.findElement(By.id(LocatorPath.vehicleModelSpiner1_BTN)).click();
         }catch(Exception e) {
        	 try {
        		 ndmsDriver.findElement(By.id(LocatorPath.vehicleModelSpiner2_BTN)).click(); 
        	 }catch(Exception e2) {
        		 try {
        		 ndmsDriver.findElement(By.id(LocatorPath.vehicleModelSpiner_BTN)).click();
        		 }catch(Exception e3) {
        			 
        		 }
        	 }
        	
         }*/
         List<WebElement> priceSectionList = ndmsDriver.findElements(By.xpath((LocatorPath.priceSectionList)));
 		System.out.println("Vehicle Model list :::" + priceSectionList.size());
 		for(int i=0;i<priceSectionList.size();i++) {
 			String vehicleModelName=priceSectionList.get(i).getText();
 			System.out.println("Vehicle Model Name :::" + vehicleModelName);
 				priceSectionList.get(i).click();
 				break;
 			

 		}
        
		Thread.sleep(2000);
		//Select Vehicle Model
		List<WebElement> vehicleModelList = ndmsDriver.findElements(By.xpath((LocatorPath.vehicleModelList)));
		System.out.println("Vehicle Model list :::" + vehicleModelList.size());
		for(int i=0;i<vehicleModelList.size();i++) {
			String vehicleModelName=vehicleModelList.get(i).getText();
			System.out.println("Vehicle Model Name :::" + vehicleModelName);
			if(vehicleModelName.equalsIgnoreCase("Grand i10")){
				vehicleModelList.get(i).click();
				break;
			}

		}
		writeReport(LogStatus.PASS, "Selected Vehicle model Pass");
		Thread.sleep(2000);
		//Select Vehicle details
		List<WebElement> vehicleDetailsList = ndmsDriver.findElements(By.xpath((LocatorPath.vehicleDetailsList)));
		System.out.println("Vehicle details list :::" + vehicleDetailsList.size());
		for(int i=0;i<vehicleDetailsList.size();i++) {
			String vehicleDetailsName=vehicleDetailsList.get(i).getText();
			System.out.println("Vehicle Details Name :::" + vehicleDetailsName);
			vehicleDetailsList.get(i).click();
				break;
		}
		writeReport(LogStatus.PASS, "Selected Vehicle details Pass");
		Thread.sleep(1000);
	//Click on Preview
		ndmsDriver.findElement(By.id(LocatorPath.preview_BTN)).click();
		ndmsDriver.findElement(By.id(LocatorPath.share_BTN)).click();
		
	// Click on Share Icon
		
		//ndmsDriver.findElement(By.id(LocatorPath.shareIcon_BTN)).click();
	
		
		writeReport(LogStatus.PASS, "Price Flows Pass");

	}
	
	public void emiCalculatorInNDMSApp() throws InterruptedException {

		ndmsDriver.findElement(By.xpath(LocatorPath.hambrugerMenu)).click();
		ndmsDriver.findElement(By.id(LocatorPath.sales_Tab)).click();

		ndmsDriver.findElement(By.xpath(LocatorPath.emiCalculator)).click();
		
		Thread.sleep(2000);
		List<WebElement> emiCalculatorSectionList = ndmsDriver.findElements(By.xpath((LocatorPath.emiCalculatorSectionList)));
		System.out.println("Vehicle Model list :::" + emiCalculatorSectionList.size());
		for(int i=0;i<emiCalculatorSectionList.size();i++) {
			String vehicleModelName=emiCalculatorSectionList.get(i).getText();
			System.out.println("Vehicle Model Name :::" + vehicleModelName);
			if(i==0){
				emiCalculatorSectionList.get(i).click();
				break;
			}

		}
		Thread.sleep(2000);
		//Select Vehicle Model
		List<WebElement> vehicleModelList = ndmsDriver.findElements(By.xpath((LocatorPath.vehicleModelList)));
		System.out.println("Vehicle Model list :::" + vehicleModelList.size());
		for(int i=0;i<vehicleModelList.size();i++) {
			String vehicleModelName=vehicleModelList.get(i).getText();
			System.out.println("Vehicle Model Name :::" + vehicleModelName);
			if(vehicleModelName.equalsIgnoreCase("Grand i10")){
				vehicleModelList.get(i).click();
				break;
			}

		}
		writeReport(LogStatus.PASS, "Selected Vehicle model Pass");
		Thread.sleep(2000);
		//Select Variant Model		
		List<WebElement> emiCalculatorSectionList1 = ndmsDriver.findElements(By.xpath((LocatorPath.emiCalculatorSectionList)));
		System.out.println("Vehicle Model list :::" + emiCalculatorSectionList1.size());
		for(int i=0;i<emiCalculatorSectionList1.size();i++) {
			String vehicleModelName=emiCalculatorSectionList1.get(i).getText();
			System.out.println("Vehicle Model Name :::" + vehicleModelName);
			if(i==1){
				emiCalculatorSectionList1.get(i).click();
				break;
			}

		}
		Thread.sleep(2000);
		 List<WebElement> variantList = ndmsDriver.findElements(By.xpath((LocatorPath.variantList)));
			System.out.println("Variant Vehicle Model list :::" + variantList.size());
			for(int i=0;i<variantList.size();i++) {
				String variantVehicleName=variantList.get(i).getText();
				System.out.println("Variant Vehicle Name :::" + variantVehicleName);
				if(variantVehicleName.equalsIgnoreCase("Sportz")){
					variantList.get(i).click();
					break;
				}
			}
			writeReport(LogStatus.PASS, "Selected variant Vehicle model Pass");
			Thread.sleep(1000);
			ndmsDriver.findElement(By.xpath(LocatorPath.loanAmountInputTextField)).sendKeys("655000");
		
		writeReport(LogStatus.PASS, "EMI Calculator Flows Pass");

	}
	
    


}
