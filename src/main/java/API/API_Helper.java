package API;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import base.API_BaseTest;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class API_Helper extends API_BaseTest{

		
	    public String ResourcePath = "src/main/resources/";
	    public JSONParser parser = new JSONParser();
	    public Properties properties;
	    
	    public synchronized Response GetRequest(String Route) {
	    	    test.get().info("End point URL : " +  URL + Route);      
	            HashMap<String, String> Header = this.DefaultRequestHeader();
	            httpRequest.headers(Header);
	            response= httpRequest.request(Method.GET, Route);
	            logger.info("response code: " + response.getStatusCode());
	            logger.info("response body: " + response.getBody().asPrettyString());
	            test.get().info("response code : " +  response.getStatusCode());
	            test.get().info("response body : " +  response.getBody().asPrettyString());
	            return response;
	    }
	    
	    public synchronized Response postRequest(String Route, String filePath) {
            test.get().info("End point URL : " +  URL + Route);
            JSONObject req_body = null;
			try {
				req_body = ReadJsonInput(filePath);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            httpRequest.body(req_body);
            
            //HashMap<String, String> Header = this.DefaultRequestHeader();
            //httpRequest.headers(Header);
            response= httpRequest.request(Method.POST, Route);
            logger.info("response code: " + response.getStatusCode());
            logger.info("response body: " + response.getBody().asPrettyString());
            test.get().info("response code : " +  response.getStatusCode());
            test.get().info("response body : " +  response.getBody().prettyPrint());
            return response;
    }
	    
	    public HashMap<String, String> DefaultRequestHeader() {
	        HashMap<String, String> Header = new HashMap<String, String>();
	        Header.put("Authorization", longToken);
	        Header.put("accept", "application/json");
	        return Header;
	    }
	    
	    public HashMap<String, String> UpdateRequestHeader(String Key, String Value) {
	        HashMap<String, String> Header = new HashMap<String, String>();
	        Header.put("Authorization", longToken);
	        Header.put("Cache-Control", "no-cache");
	        Header.put("Content-Type", "application/json");
	        Header.put("Accept", "*/*");
	        Header.put("User-Agent", "Mozilla/5.0");
	        Header.put("Accept-Encoding", "gzip, deflate, br");
	        Header.put("Connection", "keep-alive");
	        Header.put("Host", Host);
	        Header.put(Key, Value);
	        logger.info("Updating the header :" + (String)Header.get(Key));
	        return Header;
	    }
	  
	    public synchronized JSONObject ReadJsonInput(String StrFileName) throws ParseException {
	    	 JSONObject RequestBody = null;
	        try {
	            FileReader reader;
	            if (this.ResourcePath.contains(StrFileName)) {
	                reader = new FileReader(this.ResourcePath);
	            } else {
	                reader = new FileReader(this.ResourcePath + StrFileName);
	            }
	            RequestBody = (JSONObject)this.parser.parse(reader);
	           
	        } catch (IOException e) {
				e.printStackTrace();
			}
	        return RequestBody;
	    }
}
