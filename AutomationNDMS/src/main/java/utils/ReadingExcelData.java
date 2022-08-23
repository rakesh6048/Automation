package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class ReadingExcelData {

	private static Workbook workbook = null;

	public static Workbook getWorkBook() {

		try {
			if (workbook == null) {
				String newFilePath = System.getProperty("user.dir") + "\\Ndms_Input.xls";
				System.out.println("New file path :::" + newFilePath);
				FileInputStream fs = new FileInputStream(newFilePath);
				workbook = Workbook.getWorkbook(fs);
			}

		} catch (Exception e) {

		}
		return workbook;
	}

	public static void readingWorkFlowData() throws IOException, BiffException {

		try {
			if (Utils.excelInputDataList == null) {
				Sheet sheet = getWorkBook().getSheet("WorkFlowData");

				List<String> ExpectedColumns = new ArrayList<String>();
                Thread.sleep(2000);
				int masterSheetColumnIndex = sheet.getColumns();

				for (int x = 0; x < masterSheetColumnIndex; x++) {
					Cell celll = sheet.getCell(x, 0);
					String d = celll.getContents();
					ExpectedColumns.add(d);
				}

				LinkedHashMap<String, List<String>> columnDataValues = new LinkedHashMap<String, List<String>>();

				List<String> column1 = new ArrayList<String>();

				/// read values from driver sheet for each column
				for (int j = 0; j < masterSheetColumnIndex; j++) {
					column1 = new ArrayList<String>();
					for (int i = 1; i < sheet.getRows(); i++) {
						Cell cell = sheet.getCell(j, i);
						column1.add(cell.getContents());
					}
					columnDataValues.put(ExpectedColumns.get(j), column1);
				}

				List<String> mobileNumberList = columnDataValues.get("MobileNumber");
				List<String> userNameList = columnDataValues.get("UserName");
				List<String> passwordList = columnDataValues.get("Password");
				List<String> appVersionList = columnDataValues.get("AppVersion");
				
				
				ArrayList<ExcelInputData> userDetailsList = new ArrayList<ExcelInputData>();

				for (int i = 0; i < mobileNumberList.size(); i++) {
					ExcelInputData appInputDetail = new ExcelInputData();
					userDetailsList.add(appInputDetail);
					userDetailsList.get(i).setMobileNumber(mobileNumberList.get(i));
					userDetailsList.get(i).setAppVersion(appVersionList.get(i));
					userDetailsList.get(i).setUserName(userNameList.get(i));
					userDetailsList.get(i).setPassword(passwordList.get(i));	
				}

				Utils.excelInputDataList = userDetailsList;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static LinkedHashMap<String, List<String>> readingFleetManagerData(String sheetName) {

		try {

			Sheet sheet = getWorkBook().getSheet(sheetName);
			List<String> ExpectedColumns = new ArrayList<String>();

			int masterSheetColumnIndex = sheet.getColumns();

			for (int x = 0; x < masterSheetColumnIndex; x++) {
				Cell celll = sheet.getCell(x, 0);
				String d = celll.getContents();
				ExpectedColumns.add(d);
			}

			LinkedHashMap<String, List<String>> columnDataValues = new LinkedHashMap<String, List<String>>();

			List<String> column1 = new ArrayList<String>();
			/// read values from user edit sheet for each column
			for (int j = 0; j < masterSheetColumnIndex; j++) {
				column1 = new ArrayList<String>();
				for (int i = 1; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);
					column1.add(cell.getContents());
				}
				columnDataValues.put(ExpectedColumns.get(j), column1);
			}
			return columnDataValues;
		} catch (Exception e) {

		}
		return null;
	}

	public static void readingNegativeData() throws IOException, BiffException {

		if (Utils.excelInputDataList == null) {
			Sheet sheet = getWorkBook().getSheet("NegativeWorkFlow");

			List<String> ExpectedColumns = new ArrayList<String>();

			int masterSheetColumnIndex = sheet.getColumns();

			for (int x = 0; x < masterSheetColumnIndex; x++) {
				Cell celll = sheet.getCell(x, 0);
				String d = celll.getContents();
				ExpectedColumns.add(d);
			}

			LinkedHashMap<String, List<String>> columnDataValues = new LinkedHashMap<String, List<String>>();

			List<String> column1 = new ArrayList<String>();

			/// read values from driver sheet for each column
			for (int j = 0; j < masterSheetColumnIndex; j++) {
				column1 = new ArrayList<String>();
				for (int i = 1; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);
					column1.add(cell.getContents());
				}
				columnDataValues.put(ExpectedColumns.get(j), column1);
			}

			List<String> mobileNumberList = columnDataValues.get("MobileNumber");
			
			ArrayList<ExcelInputData> userDetailsList = new ArrayList<ExcelInputData>();

			for (int i = 0; i < mobileNumberList.size(); i++) {
				ExcelInputData appInputDetail = new ExcelInputData();
				userDetailsList.add(appInputDetail);
				userDetailsList.get(i).setMobileNumber(mobileNumberList.get(i));
				
			}

			Utils.excelInputDataList = userDetailsList;

		}
	}
}
