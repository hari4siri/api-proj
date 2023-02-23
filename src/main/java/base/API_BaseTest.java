package base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import common.GetProperty;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import listeners.API_ExtentReportListener;

public class API_BaseTest extends API_ExtentReportListener{
	
	public static GetProperty getProperty;
	public static Response response;
	public static RequestSpecification httpRequest;
	public Logger logger;
	public static String Scheme;
    public static String Host;
    public static String URL;
    public static String longToken;
	
	
	@BeforeClass
	public void setup() {
		// Initializing logger
		logger=Logger.getLogger("ICoreRestServices");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		// setting the base URL
		getProperty = new GetProperty();				
		getProperty.initiaze_prop();
        Scheme = getProperty.initiaze_prop().getProperty("Scheme");
        Host = getProperty.initiaze_prop().getProperty("Host");
        longToken=getProperty.initiaze_prop().getProperty("LongToken");
        URL = Scheme + "://" + Host + "/";
        // initializing the RestAssured
        RestAssured.baseURI=URL;       
        httpRequest = RestAssured.given();
	}
}
