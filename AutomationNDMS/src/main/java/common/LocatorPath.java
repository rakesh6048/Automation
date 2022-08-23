package common;

public interface LocatorPath {

	//NDMS Flows
	
	String userName="//android.widget.EditText[@id='com.wipro.gdms:id/username_et']";
	String password="//android.widget.EditText[@id=\"com.wipro.gdms:id/password_et\"]";
	String proceed_Button="//android.widget.Button[@id=\"com.wipro.gdms:id/login_button\"]";
	String dashboard_HDR="//android.widget.TextView[@id='com.wipro.gdms:id/toolbar_title']";
	
	String showPassword="com.wipro.gdms:id/text_input_password_toggle";
	String newPassword="//android.widget.EditText[@text='New Password']";
	String confirmPassword="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText";
    String proceed_BTN="com.wipro.gdms:id/proceed_btn";
    
    //Dashboard screen
    
    String dashboardButton="com.wipro.gdms:id/largeLabel";
    String dashboardButton1="com.wipro.gdms:id/navigation_dashboard";
    String myComplaints="//android.widget.TextView[@resource-id='com.wipro.gdms:id/smallLabel']";
    String myComplaint_HDR="com.wipro.gdms:id/toolbar_title";
    String noDataAvialable_Text="//android.widget.TextView[@text='No Data Available']";
    String homeVisit_BTN="//android.widget.TextView[@text='Home Visit']";
    String homeVisit_HDR="com.wipro.gdms:id/toolbar_title";
    String bellIcon="com.wipro.gdms:id/action_notifications";
    String notification_HDR="com.wipro.gdms:id/toolbar_title";
    String notification_List="com.wipro.gdms:id/notification_rv";
    String notification_Details="com.wipro.gdms:id/parent";
    
    String totalFollowup_HDR="com.wipro.gdms:id/total_followups";
    
    //Callback section
    String callBack_Section="com.wipro.gdms:id/call_back_by_mtd";
    String dayOne="//android.widget.TextView[@instance='1']";
    String dayTwo="//android.widget.TextView[@instance='2']";
    String dayThree="//android.widget.TextView[@instance='3']";
    
    String calanderIcon="com.wipro.gdms:id/calenderIcon";
    String followups_Title="//android.widget.TextView[@instance='4']";
    String totalCount="com.wipro.gdms:id/total_followups_today";
    
    String callbackNavigation="com.wipro.gdms:id/call_back_count_today";
    String homeVisitNavigation="com.wipro.gdms:id/home_visit_count_today";
    String showroomVisitNavigation="com.wipro.gdms:id/shrm_visit_count_today";
    String testDriveNavigation="com.wipro.gdms:id/test_drive_count_today";
    
    String enquiry_HDR="com.wipro.gdms:id/toolbar_title";
    
    String allLeads_Tab="//android.support.v7.app.ActionBar.Tab[@content-desc=\"All Leads\"]/android.widget.TextView";
    String callback_Tab="//android.support.v7.app.ActionBar.Tab[@content-desc=\"Call Back\"]/android.widget.TextView";
    String homeVisit_Tab="//android.support.v7.app.ActionBar.Tab[@content-desc=\"Home Visit\"]";
    String showroomVisit_Tab="//android.support.v7.app.ActionBar.Tab[@content-desc=\"Showroom Visit\"]/android.widget.TextView";
    String testDrive_Tab="//android.support.v7.app.ActionBar.Tab[@content-desc=\"Test Drive\"]/android.widget.TextView";
    
    String back_BTN="//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    
    //Home Visit Section
    
    String homeVisitSection="com.wipro.gdms:id/home_visit_by_mtd";
    
    //Showroom Visit Section
    
    String showroomVisitSection="com.wipro.gdms:id/showrm_visit_by_mtd";
    
    //Calender
    
    String year_HDR="android:id/date_picker_header_year";
    String dateAndDay="android:id/date_picker_header_date";
    String previuosMonth_Icon="android:id/prev";
    String nextMonth_Icon="android:id/next";
    String cancelCL_BTN="android:id/button2";
    String okCLS_BTN="android:id/button1";
    String selectDateInCL="//android.view.View[@instance='13']";
    
    //Test Drive Section
    String testDriveNavigationInDashboard="com.wipro.gdms:id/test_drive_by_mtd";
    
    //Hambruger Menu
    
    String hambrugerMenu="//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]";
    
    String sales_Tab="com.wipro.gdms:id/ivIndicator";
    
    String enquiry="//android.widget.TextView[@text='Enquiry']";
    String testDrive="//android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.TextView";
    String myCalendar="//android.widget.TextView[@text='My Calendar']";
    String stock="//android.widget.TextView[@text='Stock']";
    String reports="//android.widget.TextView[@text='Reports']";
    String price="//android.widget.TextView[@text='Price']";
    String promotions="//android.widget.TextView[@text='Promotions']";
    String emiCalculator="//android.widget.TextView[@text='EMI Calculator']";
    
    String about="//android.widget.TextView[@text='About']";
    String help="//android.widget.TextView[@text='Help']";
    
    String logOut_BTN="com.wipro.gdms:id/logout_btn";
    String logout_NO_BTN="android:id/button2";
    String logout_Yes_BTN="android:id/button1";
    
    String profileImage="com.wipro.gdms:id/imageView";
    
    //My Profile 
    String personalizeThemeToogle_BTN="com.wipro.gdms:id/switch_theme";
    String salesDataSync_BTN="com.wipro.gdms:id/btnSalesSync";
    String crmDataSync_BTN="//android.widget.Button[@instance='1']";
    String downloadAllMasterData="//android.widget.RelativeLayout/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.Button";
    String update_BTN="//android.widget.Button[@text='Update']";
    
    //Enquiry
    
    //Filter Section
    String enquiryFilter_BTN="com.wipro.gdms:id/filter";
    String filterClear_BTN="com.wipro.gdms:id/btn_clear";
    String filterSortby_BTN="com.wipro.gdms:id/btn_search";
    String filterClose_BTN="com.wipro.gdms:id/btn_close";
    String enquiryDateRadio_BTN="com.wipro.gdms:id/radio_enquiry_date";
    String ageingRadio_BTN="com.wipro.gdms:id/radio_age";
    String overdueRadio_BTN="com.wipro.gdms:id/radio_overdue";
    String filterApply_BTN="com.wipro.gdms:id/btn_apply";
    
    //Search Section
    
    String search_Icon="com.wipro.gdms:id/search";
    String searchClear_BTN="com.wipro.gdms:id/btn_clear";
    String searchClose_BTN="com.wipro.gdms:id/btn_close";
    String selectFromDate="com.wipro.gdms:id/et_from_date";
    String fromDateOk_BTN="android:id/button1";
    
    //String fromDateOk_BTN="//android.widget.Button[@text='OK']";
    String selectToDate="com.wipro.gdms:id/et_to_date";
    String searchCustomerName="com.wipro.gdms:id/et_customer_name";
    String searchMobileNumber="com.wipro.gdms:id/et_mobile_no";
    String searchStatus="com.wipro.gdms:id/spinner_status";
    String searchStatusNumber="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.view.ViewGroup[4]/android.widget.TextView";
    String searchApply_BTN="com.wipro.gdms:id/btn_apply";
    String searchModelType="com.wipro.gdms:id/spinner_model_type";
    String selectModel="//android.widget.CheckedTextView[@text='C4']";
    String statusList="//*[@class='android.widget.TextView']";
    String modelList="//*[@class='android.widget.CheckedTextView']";
    
    //Create Enquiry
    
    String ceateEnquiryPlus_BTN="com.wipro.gdms:id/imb_create_enquiry";
    String enquiryDetails="Enquiry Details";
    String exchangeDetails="Exchange Details";
    String customerDetails="Customer Details";
    
    //Enquiry Details
    
    String enquiryDetailsSection="//android.widget.RelativeLayout[@instance='1']";
    String enquiryDetailsList="//android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/*";
    String editEnquiryDetails_Icon="//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView";
    String enquiryCall="//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.ImageButton";
    
    String callNo_BTN="com.wipro.gdms:id/no_call_btn";
    String callYes_BTN="com.wipro.gdms:id/yes_call_btn";
    String callOK_BTN="android:id/button1";
    String call_Allow="com.android.packageinstaller:id/permission_allow_button";
    
    String enquiryDetailsCall="com.wipro.gdms:id/ib_fragment_enquiry_call";
    
    String enqDetailsFollowp="Followup";
    String enqDetailsTestDrive="Test drive";
    String enqDetailsExchange="Exchange";
    String enqDetailsEnquiry="Enquiry";
    
    //Close 
    
    String enqDetailsClose="com.wipro.gdms:id/tv_close";
    String lostDetailsRemarks="com.wipro.gdms:id/et_rem";
    String lostDetailsSubmit_BTN="com.wipro.gdms:id/btnLostSubmit";
    
    //Create Followup
    
    String addFollowup_BTN="com.wipro.gdms:id/ib_add_followup";
    String followupRemark_InputField="com.wipro.gdms:id/et_remarks";
    String callBackDropdown_BTN="com.wipro.gdms:id/call_back_spinner";
    String callBack_List="//android.widget.FrameLayout/android.widget.ListView/*";
    
    //Next Followup
    
   String nextCallBackDropdown_BTN="com.wipro.gdms:id/followup_spinner";
   String nextCallBack_List="//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/*";
   String selectDate="com.wipro.gdms:id/et_select_date";
   String selectDateOk_BTN="android:id/button1";
   String selectTime="com.wipro.gdms:id/et_select_time";
   String selectTimeOK_BTN="android:id/button1";
   String followup_Submit_BTN="com.wipro.gdms:id/btn_submit_add_followup_frag";
   
   //Test Drive 
   
    String totalCountTestDrive="com.wipro.gdms:id/tv_title_count";
	
    //My Calendar
	
    String prevMonthIcon="com.wipro.gdms:id/previousButton";
    String nextMonthIcon="com.wipro.gdms:id/forwardButton";
    String weekViewLink="com.wipro.gdms:id/action_month_view";
    String today_BTN="com.wipro.gdms:id/today_btn";
    String day_BTN="com.wipro.gdms:id/day_btn";
    String Week_BTN="com.wipro.gdms:id/week_btn";
    
    //Stock
    
    String allocated_Link="//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView";
    
    //Price
    String vehicleModelSpiner1_BTN="//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Spinner";
    String vehicleModelSpiner2_BTN="//*[@class='android.widget.Spinner']";
    String vehicleModelSpiner_BTN="//*[@class='android.widget.Spinner' and @instance='0']";
    
   String priceSectionList="//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/*";
    
    String vehicleModelList="//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/*";
    
    String vehicleDetailsList="//android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/*";
    String preview_BTN="com.wipro.gdms:id/button_preview";
    String share_BTN="com.wipro.gdms:id/button_share";
    String shareIcon_BTN="//android.widget.ImageView[@instance='0']";
    
    //EMI Calculator
   String vehicleVariantSpiner_BTN="//android.widget.TextView[@text='Variant']";
   String variantList="//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/*";
   String loanAmountInputTextField="//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.EditText";
   
   String emiCalculatorSectionList="//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/*";
   
   
   //Create Enquiry
   
   String customerMobileNoSearch_Icon="com.wipro.gdms:id/img_search";
   String customerMobileNoTextField="com.wipro.gdms:id/et_customer_mobile_no";
   String customerNameTextField="com.wipro.gdms:id/et_customer_name";
   
   //Customer Details
   String ceateEnquiryList="//android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/*";
   String stateandSubstateListSpiner="//android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/*";
   
   String individualList="//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/*";
   String maleList="//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/*";
   String stateList="//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/*";
   String subStateList="//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/*";
   String nancorieList="//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/*";
   
   
       
    
}
