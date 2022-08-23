package ndmsworkflow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileReader1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser jspars=new JSONParser();
		
		try(FileReader reader=new FileReader("D:/Read&WriteExcel/JsonEmployeeDetails.json")){
			
			Object obj=jspars.parse(reader);
			
			JSONArray empList=(JSONArray) obj;
			System.out.println(empList);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
