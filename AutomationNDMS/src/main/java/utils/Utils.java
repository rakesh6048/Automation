package utils;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shanthakumar on 29-01-2018.
 */

public class Utils {

	public static List<ExcelInputData> excelInputDataList;
	private static Date previousTime;
	private static long startTime = 0;
	private static long endTime = 0;
	private static long totalTime = 0;

	public static void sleepTimeLong() throws InterruptedException {

		Thread.sleep(20000);
	}

	public static void sleepTimeMedium() throws InterruptedException {
		Thread.sleep(10000);
	}

	public static void sleepTimeLow() throws InterruptedException {
		Thread.sleep(5000);
	}

	public static String timeCalculation() {

		if (startTime == 0) {
			startTime = System.nanoTime();
		}
		endTime = System.nanoTime();
		totalTime = endTime - startTime;  
		startTime = endTime; 
		return "The time duration is " + TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS) + " Seconds";

	}


	
}
