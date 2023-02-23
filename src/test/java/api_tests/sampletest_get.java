package api_tests;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import API.API_Helper;
import io.restassured.path.json.JsonPath;



public class sampletest_get extends API_Helper{
	
	 String ResourcePath = "/payload";
	 JsonPath p;
	 
	@Test
	public void getWeatherDetails() {
		response = GetRequest("api/users?page=2");
		int code=response.getStatusCode();
		p=response.jsonPath();
		logger.info("*************from logger*********" + p.get("data.first_name"));
		Assert.assertEquals(code, HttpStatus.SC_OK);		
		}
	
	@Test
	public void createEmployee() {
		response = postRequest("api/v1/create", "/payload/apiname/samplepayload.json");
		int code=response.getStatusCode();		
		Assert.assertEquals(code, 201);
		} 
	 
	

}

