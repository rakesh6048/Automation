package ndmsworkflow;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonFileWrite {

	public static void main(String[] args) throws IOException {

       //Employee Details
	   JSONObject empdetails1=new JSONObject();
	   
	   empdetails1.put("FirastName", "Sohan");
	   empdetails1.put("LastName", "Das");
	   empdetails1.put("CompanyName", "Photon Infotech PVT LTD");
	   
	   JSONObject empObject1=new JSONObject();
	   empObject1.put("Employee1", empdetails1);
	   
	   JSONObject empdetails2=new JSONObject();
	   empdetails2.put("FirstName", "Mohan");
	   empdetails2.put("LastName", "Gupta");
	   empdetails2.put("CompanyName", "Hinduja Tech LTD");
	   
	   JSONObject empObject2=new JSONObject();
	   empObject2.put("Employee2", empdetails2);
	   
	   JSONArray empList=new JSONArray();
	   empList.add(empObject1);
	   empList.add(empObject2);
	   
	   System.out.println(empList);
	   
	   try(FileWriter file=new FileWriter("D:/Read&WriteExcel/JsonEmployeeDetails.json")){
		   
		   file.write(empList.toJSONString());
		   file.flush();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   

	}

}
