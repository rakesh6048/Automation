package ndmsworkflow;

import org.testng.annotations.Test;

import common.Configuration;
import common.NDMS;
import utils.ReadingExcelData;
import utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class NDMSWorkFlows {
	private NDMS ndms;
	boolean isVerified = true;
	@BeforeTest
	public void setUpConfiguration() {

		try {

			//ReadingExcelData.readingWorkFlowData();
			
			ndms = new NDMS();

		} catch (Exception e) {

		}
	}
	@AfterTest
	public void afterTest() {
		Configuration.saveReport();
	}
	@AfterMethod
	public void afterMethod() {
		//Configuration.closeWorkFlowReport();
	}
	
	@Test
	  public void launchIdeal() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_LogInAndLogOut_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					Configuration.idealLaunch();
					Configuration.closeWorkFlowReport();

					Configuration.createNewWorkFlowReport("LogInAndLogOut In NDMSApp");
					//ndms.verifyLoginSuccess();
					//ndms.logOut();
					System.out.println("Launch Application");
		            Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
				e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }

  /*@Test
  public void loginLogoutInNDMSApp() throws InterruptedException, IOException {
	  try{
		  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
				System.out.println("===== NDMS Flows=====");
				Configuration.reportConfiguration("NDMS_LogInAndLogOut_Report_");
				Configuration.createNewWorkFlowReport("Login Details");
				ndms.login();
				Configuration.closeWorkFlowReport();

				Configuration.createNewWorkFlowReport("LogInAndLogOut In NDMSApp");
				ndms.verifyLoginSuccess();
				ndms.logOut();
	            Configuration.closeWorkFlowReport();
		 // }
	  } catch (Exception e) {
			e.printStackTrace();
			Configuration.takeScreenShotForFailedScripts();
		} finally {
			Configuration.saveReport();

		}
  }
	
	@Test
	  public void forgotPasswordInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_ForgotPassword_Report_");
					
					Configuration.createNewWorkFlowReport("Forgot Password In NDMStApp");
					ndms.forgotPassword();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
				e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
       
	@Test
	  public void hambrugerMenuNavigationInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_HambrugerNavigation_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("HambrugerMenu In NDMStApp");
					ndms.verifyHambrugerMenuScreen();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
				e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void dashboardNavigationInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_DashboardNavigation_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("Dashboard Navigation In NDMStApp");
					ndms.verifyNavigationFlowsInDashboardScreen();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
				e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void driveNavigationInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_DashboardTestDrive_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("Dashboard Test Drive In NDMStApp");
					ndms.verifyTestDriveNavigationInDashboardScreen();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
				e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void homeVisitSectionInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_HomeVisitSectionInDashboard_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("HomeVisitSectionInDashboard In NDMStApp");
					ndms.verifyHomeVisitSectionInDashboardScreen();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
				e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void showroomVisitSectionInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_ShowroomVisitSectionInDashboard_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("ShowroomVisitSectionInDashboard In NDMStApp");
					ndms.verifyShowroomVisitSectionInDashboardScreen();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
				e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void aboutNavigationNDMS() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_AboutNavigationNDMS_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("AboutNavigation In NDMStApp");
					ndms.verifyAboutNavigationNDMS();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
				e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void helpNavigationNDMS() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_HelpNavigationNDMS_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("HelpNavigation In NDMStApp");
					ndms.verifyHelpNavigationNDMS();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
				e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void myProfileNavigationInNDMS() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_MyProfileNavigationInNDMS_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("MyProfileNavigation In NDMStApp");
					ndms.myProfileNavigationInNDMS();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
                e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void enquiryFliterNavigationInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_EnquiryFliterNavigationInNDMSApp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("EnquiryFliterNavigation In NDMStApp");
					ndms.enquiryFilterInNDMSApp();	
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
              e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void enquirySearchNavigationInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_EnquirySearchNavigationInNDMSApp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("EnquirySearchNavigation In NDMStApp");
					ndms.enquirySearchInNDMSApp();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
            e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void enquiryCreateNavigationInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_enquiryCreateNavigationInNDMSApp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("enquiryCreateNavigation In NDMStApp");
					ndms.ceateEnquiryInNDMSApp();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
          e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	@Test
	  public void enquiryDetailsNavigationInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_enquiryDetailsNavigationInNDMSApp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("enquiryDetailsNavigation In NDMStApp");
					ndms.enquiryDetailsInNDMSApp();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
        e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void addFollowupInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_AddFollowupInNDMSApp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("AddFollowup In NDMStApp");
					ndms.addFollowupInNDMSApp();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
      e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void testDriveInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_TestDriveInNDMSAppp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("TestDrive In NDMStApp");
					ndms.testDriveInNDMSApp();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
    e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void myCalendarInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_MyCalendarInNDMSApp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("MyCalendar In NDMStApp");
					ndms.myCalendarInNDMSApp();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
  e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void stockAndReportsInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_StockAndReportsInNDMSApp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("StockAndReports In NDMStApp");
					ndms.stockAndReportsInNDMSApp();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void priceInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_PriceInNDMSApp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("Price In NDMStApp");
					ndms.priceInNDMSApp();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }
	
	@Test
	  public void emiCalculatorInNDMSApp() throws InterruptedException, IOException {
		  try{
			  //if (Utils.excelInputDataList != null && Utils.excelInputDataList.size() > 0) {
					System.out.println("===== NDMS Flows=====");
					Configuration.reportConfiguration("NDMS_EmiCalculatorInNDMSApp_Report_");
					Configuration.createNewWorkFlowReport("Login Details");
					ndms.login();
					Configuration.closeWorkFlowReport();
					
					Configuration.createNewWorkFlowReport("EmiCalculator In NDMStApp");
					ndms.emiCalculatorInNDMSApp();
					Configuration.closeWorkFlowReport();
			 // }
		  } catch (Exception e) {
                 e.printStackTrace();
				Configuration.takeScreenShotForFailedScripts();
			} finally {
				Configuration.saveReport();

			}
	  }*/
 
}
