package ndmsworkflow;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.JsonObject;

public class JsonFileWrite1 {

	public static void main(String[] args) throws IOException {

		JSONObject empDetails1=new JSONObject();

		empDetails1.put("FirstName", "Mohan");
		empDetails1.put("LastName", "Singh");
		empDetails1.put("CompanyName", "Hinduja");

		JSONObject empObject1=new JSONObject();
		empObject1.put("EmpDetails1", empDetails1);

		JSONObject empDetails2=new JSONObject();

		empDetails2.put("FirstName", "Sohan");
		empDetails2.put("LastName", "Sharma");
		empDetails2.put("CompanyName", "Photon");

		JSONObject empObject2=new JSONObject();
		empObject2.put("EmpDetails2", empDetails2);

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
