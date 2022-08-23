package ndmsworkflow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException {

        FileInputStream f1=new FileInputStream("D:/Read&WriteExcel/EmployeeDetails.xlsx");
        //Workbook wb=WorkbookFactory.create(f1);
	}

}
